package com.project.Specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.project.Model.Product;

public class ProductSpecification implements Specification<Product> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Product criteria;

	public ProductSpecification(Product criteria) {
		this.criteria = criteria;

	}

	@Override
	public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		if (criteria.getId() == null && criteria.getProductName() == null && criteria.getSellerId() == null
				&& criteria.getSubCatagoryId() == null && criteria.getProdectModel() == null
				&& criteria.getProductPrice() == null && criteria.getProductQuantity() == null
				&& criteria.getActive() == null) {
			return null;
		}

		Integer count = 0;
		Predicate[] listData;

		Predicate idPredicate = null;
		if (criteria.getId() != null) {
			idPredicate = criteriaBuilder.like(root.get("id").as(String.class), "%" + criteria.getId() + "%");
			count++;
		}

		Predicate productNamePredicate = null;
		if (criteria.getProductName() != null && criteria.getProductName().length() > 0) {
			productNamePredicate = criteriaBuilder.like(root.get("productName"), "%" + criteria.getProductName() + "%");
			count++;
		}

		Predicate sellerIdPredicate = null;
		if (criteria.getSellerId() != null) {
			sellerIdPredicate = criteriaBuilder.like(root.get("sellerId").as(String.class),
					"%" + criteria.getSellerId() + "%");
			count++;
		}

		Predicate subCatagorydPredicate = null;
		if (criteria.getSubCatagoryId() != null) {
			subCatagorydPredicate = criteriaBuilder.like(root.get("subCatagoryId").as(String.class),
					"%" + criteria.getSubCatagoryId() + "%");
			count++;
		}

		Predicate prodectModelPredicate = null;
		if (criteria.getProdectModel() != null && criteria.getProdectModel().length() > 0) {
			prodectModelPredicate = criteriaBuilder.like(root.get("prodectModel"),
					"%" + criteria.getProdectModel() + "%");
			count++;
		}

		Predicate productPricePredicate = null;
		if (criteria.getProductPrice() != null && criteria.getProductPrice().length() > 0) {
			productPricePredicate = criteriaBuilder.like(root.get("productPrice"),
					"%" + criteria.getProductPrice() + "%");
			count++;
		}

		Predicate productQuantityPredicate = null;
		if (criteria.getProductQuantity() != null && criteria.getProductQuantity().length() > 0) {
			productQuantityPredicate = criteriaBuilder.like(root.get("productQuantity"),
					"%" + criteria.getProductQuantity() + "%");
			count++;
		}

		Predicate activePredicate = null;
		activePredicate = criteriaBuilder.like(root.get("active").as(String.class), "1");
		count++;

		listData = new Predicate[count];
		Integer inserCount = 0;
		if (idPredicate != null) {
			listData[inserCount] = idPredicate;
			inserCount++;
		}
		if (productNamePredicate != null) {
			listData[inserCount] = productNamePredicate;
			inserCount++;
		}
		if (sellerIdPredicate != null) {
			listData[inserCount] = sellerIdPredicate;
			inserCount++;
		}
		if (subCatagorydPredicate != null) {
			listData[inserCount] = subCatagorydPredicate;
			inserCount++;
		}
		if (prodectModelPredicate != null) {
			listData[inserCount] = prodectModelPredicate;
			inserCount++;
		}
		if (productPricePredicate != null) {
			listData[inserCount] = productPricePredicate;
			inserCount++;
		}
		if (productQuantityPredicate != null) {
			listData[inserCount] = productQuantityPredicate;
			inserCount++;
		}
		if (activePredicate != null) {
			listData[inserCount] = activePredicate;
			inserCount++;
		}

		return criteriaBuilder.and(listData);
	}

}