package com.project.ServiceImpl;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.UUID;

import javax.annotation.processing.FilerException;
import javax.imageio.ImageIO;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.project.Exception.FileStorageException;
import com.project.Exception.MyFileNotFoundException;
import com.project.Response.FileResponse;
import com.project.SellerService.ResponseStatus;
import com.project.Service.FileStorageService;

@Service
public class FileStorageServiceImpl implements FileStorageService {

	private Path fileStorageLocation;

	static final String PNG_MIME_TYPE = "image/png";
	static final String JPEG_MIME_TYPE = "image/jpeg";
	static final String JPG_MIME_TYPE = "image/jpg";
	static final String GIF_MIME_TYPE = "image/gif";

//	@Autowired
//	public void FileStorageService(FileStorageProperties fileStorageProperties) {
//		if (fileStorageProperties != null)
//			this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
//
//		try {
//			Files.createDirectories(this.fileStorageLocation);
//		} catch (Exception ex) {
//			throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",
//					ex);
//		}
//	}

	@Override
	public String storeFile(MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}

			// Copy file to the target location (Replacing existing file with the same name)
			Path targetLocation = this.fileStorageLocation.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

			return fileName;
		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	@Override
	public Resource loadFileAsResource(String fileName) {
		try {
			Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists()) {
				return resource;
			} else {
				throw new MyFileNotFoundException("File not found " + fileName);
			}
		} catch (MalformedURLException ex) {
			throw new MyFileNotFoundException("File not found " + fileName, ex);
		}

	}

	@Override
	public FileResponse getStoreFile(MultipartFile file) {

		FileResponse response = new FileResponse();
		String fileName = file.getName().substring(0, 1).toUpperCase() + "_" + LocalDate.now() + "_"
				+ UUID.randomUUID().toString() + "."
				+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

		Boolean validFormat = isValidFormatJPG(file);
		Boolean validImageSize = isValidImageSize(file);
		if (!validFormat) {
			response.setMessage("Image is not in valid format!");
			response.setStatus(ResponseStatus.ERROR);
		} else if (!validImageSize) {
			response.setMessage("Image size is more than 6 MB!");
			response.setStatus(ResponseStatus.ERROR);
		}

		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new FilerException("Sorry! Filename contains invalid path sequence " + fileName);
			}

			// Copy file to the target location (Replacing existing file with the same name)
			Path targetLocation = this.fileStorageLocation.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

			response.setMessage("File Stored");
			response.setStatus(ResponseStatus.OK);
			response.setUrl("/viewFile/" + fileName);
			return response;
		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	@Override
	public Resource loadFileAsRequestSize(String fileName, String imageRequest) {
		try {

			String[] namesData = fileName.split("\\.");

			Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
			File file = new File(filePath.toUri());

			Resource resource = null;

			if (isValidImageFormat(file)) {

				int scaledWidth = Integer.parseInt(imageRequest.split("x")[0]);
				int scaledHeight = Integer.parseInt(imageRequest.split("x")[1]);

				try {
					BufferedImage inputImage = ImageIO.read(file);

					Image resultingImage = inputImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_DEFAULT);
					BufferedImage outputImage = new BufferedImage(scaledWidth, scaledHeight,
							BufferedImage.TYPE_INT_RGB);
					outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);

					ByteArrayOutputStream baos = new ByteArrayOutputStream();

					ImageIO.write(outputImage, namesData[namesData.length - 1], baos);

					resource = new ByteArrayResource(baos.toByteArray());
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else {
				resource = new UrlResource(filePath.toUri());
			}

			if (resource != null && resource.exists()) {
				return resource;
			} else {
				throw new MyFileNotFoundException("File not found " + fileName);
			}
		} catch (MalformedURLException ex) {
			throw new MyFileNotFoundException("File not found " + fileName, ex);
		}
	}

	public static Boolean isValidImageSize(MultipartFile file) {
		if (file.getSize() < 10485760) {
			return true;
		} else {
			return false;
		}
	}

	public static Boolean isValidImageSize40K(MultipartFile file) {
		if (file.getSize() < 40000) {
			return true;
		} else {
			return false;
		}
	}

	public static Boolean isValidImageSize200K(MultipartFile file) {
		if (file.getSize() < 200000) {
			return true;
		} else {
			return false;
		}
	}

	public static Boolean isValidImageSize1MB(MultipartFile file) {
		if (file.getSize() < 1000000) {
			return true;
		} else {
			return false;
		}
	}

	public static Boolean isValidImageSize6MB(MultipartFile file) {
		if (file.getSize() < 6000000) {
			return true;
		} else {
			return false;
		}
	}

	public static Boolean isValidFormatJPG(MultipartFile file) {

		if (JPEG_MIME_TYPE.equalsIgnoreCase(file.getContentType())
				|| JPG_MIME_TYPE.equalsIgnoreCase(file.getContentType())) {
			return true;
		} else {
			return false;
		}
	}

	public static Boolean isValidFormat(MultipartFile file) {

		if (PNG_MIME_TYPE.equalsIgnoreCase(file.getContentType())
				|| JPEG_MIME_TYPE.equalsIgnoreCase(file.getContentType())
				|| JPG_MIME_TYPE.equalsIgnoreCase(file.getContentType())
				|| GIF_MIME_TYPE.equalsIgnoreCase(file.getContentType())) {

			return true;
		} else {
			return false;
		}
	}

	public static Boolean isValidImageFormat(MultipartFile file) {

		if (PNG_MIME_TYPE.equalsIgnoreCase(file.getContentType())
				|| JPEG_MIME_TYPE.equalsIgnoreCase(file.getContentType())
				|| JPG_MIME_TYPE.equalsIgnoreCase(file.getContentType())
				|| GIF_MIME_TYPE.equalsIgnoreCase(file.getContentType())) {

			return true;
		} else {
			return false;
		}
	}

	public static Boolean isValidPDFAndJPGFormat(MultipartFile file) {

		if (PNG_MIME_TYPE.equalsIgnoreCase(file.getContentType())
				|| JPEG_MIME_TYPE.equalsIgnoreCase(file.getContentType())
				|| JPG_MIME_TYPE.equalsIgnoreCase(file.getContentType())) {

			return true;
		} else {
			return false;
		}
	}

	public static Boolean isValidVideoFormat(MultipartFile file) {

		String name = file.getOriginalFilename().toLowerCase();

		if (name.contains("mp4") || name.contains("webm") || name.contains("mkv") || name.contains("3gp")) {
			return true;
		} else {
			return false;
		}
	}

	public static Boolean isValidImageFormat(File file) {

		String name = file.getName().toLowerCase();

		if (name.contains("png") || name.contains("jpeg") || name.contains("jpg") || name.contains("gif")) {
			return true;
		} else {
			return false;
		}
	}

	public static Boolean isValidPDFFormat(File file) {

		String name = file.getName().toLowerCase();

		if (name.contains("pdf")) {
			return true;
		} else {
			return false;
		}
	}

}
