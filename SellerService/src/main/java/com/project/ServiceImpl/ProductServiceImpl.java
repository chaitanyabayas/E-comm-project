package com.project.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Dao.ProductDAO;
import com.project.Dto.ProductDTO;
import com.project.Exception.SellerServiceExpection;
import com.project.Model.Product;
import com.project.Request.ModifyRequest;
import com.project.Request.ProductRequest;
import com.project.Response.ProductResponse;
import com.project.Response.Response;
import com.project.SellerService.ResponseStatus;
import com.project.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	public ProductResponse getProducts() {
		ProductResponse response = new ProductResponse();

		List<Product> products = productDAO.findAllProduct();
		List<ProductDTO> productDTO = new ArrayList<ProductDTO>();

		for (Product product : products) {
			ProductDTO dto = new ProductDTO(product);
			dto.setId(product.getId());
			dto.setProductName(product.getProductName());
			productDTO.add(dto);
		}

		response.setStatus(ResponseStatus.OK);
		response.setMessage("Product Fetched!");
		response.setProductDTO(productDTO);
		return response;
	}

	@Override
	public Response addProduct(ProductRequest request) throws SellerServiceExpection {

		Response response = new Response();

		if (request.getProductName() == null) {
			throw new SellerServiceExpection(ResponseStatus.ERROR, "Product Name is Required");
		} else if (request.getSellerId() == null) {
			throw new SellerServiceExpection(ResponseStatus.ERROR, "Seller ID is Required");
		} else if (request.getProductPrice() == null) {
			throw new SellerServiceExpection(ResponseStatus.ERROR, "Product Price is Required");
		} else if (request.getProductQuantity() == null) {
			throw new SellerServiceExpection(ResponseStatus.ERROR, "Product Quantity is Required");
		} else if (request.getSubCatagoryId() == null) {
			throw new SellerServiceExpection(ResponseStatus.ERROR, "Product Catagory is Required");
		} else if (request.getManufacturingDate() == null) {
			throw new SellerServiceExpection(ResponseStatus.ERROR, "Product Manufacturing Date is Required");
		}

		Product productDetails = null;

		if (request.getId() != null) {
			productDetails = productDAO.findProductById(request.getId());
		}

		if (productDetails == null) {
			productDetails = new Product();
			productDetails.setManufacturedAt(request.getManufacturedAt());
			productDetails.setManufacturingDate(request.getManufacturingDate());
			productDetails.setProductName(request.getProductName());
			productDetails.setProdectManufacturer(request.getProdectManufacturer());
			productDetails.setProdectModel(request.getProdectModel());
			productDetails.setProductPrice(request.getProductPrice());
			productDetails.setProductQuantity(request.getProductQuantity());
			if (request.getProductImage() != null)
				productDetails.setProductImage(request.getProductImage().getName());
			productDetails.setSellerId(request.getUserId());
			productDetails.setCatagoryId(request.getCatagoryId());
			productDetails.setSubCatagoryId(request.getSubCatagoryId());
			productDetails.setExpiryDate(request.getExpiryDate());

			productDetails.setCreatedBy(request.getUserId());
			productDetails.setCreatedDate(LocalDateTime.now());
			productDetails.setUpdatedBy(request.getUserId());
			productDetails.setUpdatedDate(LocalDateTime.now());
			productDetails.setActive(true);

		} else {
			productDetails.setManufacturedAt(request.getManufacturedAt());
			productDetails.setManufacturingDate(request.getManufacturingDate());
			productDetails.setProductName(request.getProductName());
			productDetails.setProdectManufacturer(request.getProdectManufacturer());
			productDetails.setProdectModel(request.getProdectModel());
			productDetails.setProductPrice(request.getProductPrice());
			productDetails.setProductQuantity(request.getProductQuantity());
			if (request.getProductImage() != null)
				productDetails.setProductImage(request.getProductImage().getName());
			productDetails.setSellerId(request.getUserId());
			productDetails.setCatagoryId(request.getCatagoryId());
			productDetails.setSubCatagoryId(request.getSubCatagoryId());
			productDetails.setExpiryDate(request.getExpiryDate());

			productDetails.setUpdatedBy(request.getUserId());
			productDetails.setUpdatedDate(LocalDateTime.now());
			productDetails.setActive(true);
		}

		productDAO.save(productDetails);

		response.setStatus(ResponseStatus.OK);
		if (request.getId() == null) {
			response.setMessage("Product Saved Successfully.");
		} else {
			response.setMessage("Product Updated Successfully.");
		}
		return response;
	}

	@Override
	public Response deleteProduct(ModifyRequest request) throws SellerServiceExpection {
		Response response = new Response();

		Product productDetails = productDAO.findProductById(request.getId());

		if (productDetails == null) {
			throw new SellerServiceExpection(ResponseStatus.ERROR, "Data Not Present with given Details!");
		}

		productDetails.setActive(false);
		productDetails.setUpdatedBy(request.getUserId());
		productDetails.setUpdatedDate(LocalDateTime.now());

		productDAO.save(productDetails);

		response.setStatus(ResponseStatus.OK);
		response.setMessage("Product Deleted Successfully!");

		return response;
	}

}
