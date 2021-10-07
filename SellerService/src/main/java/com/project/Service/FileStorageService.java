package com.project.Service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.project.Response.FileResponse;

public interface FileStorageService {

	String storeFile(MultipartFile file);

	Resource loadFileAsResource(String fileName);

	FileResponse getStoreFile(MultipartFile file);

	Resource loadFileAsRequestSize(String fileName, String imageRequest);
}
