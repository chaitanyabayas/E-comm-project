package com.project.Specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.project.Model.SubCatagory;

public class SubCatagorySpecification implements Specification<SubCatagory> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final SubCatagory criteria;

	public SubCatagorySpecification(SubCatagory criteria) {
		this.criteria = criteria;

	}

	@Override
	public Predicate toPredicate(Root<SubCatagory> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		if (criteria.getId() == null && criteria.getSubCatagoryName() == null && criteria.getActive() == null) {
			return null;
		}

		Integer count = 0;
		Predicate[] listData;

		Predicate idPredicate = null;
		if (criteria.getId() != null) {
			idPredicate = criteriaBuilder.like(root.get("id").as(String.class), "%" + criteria.getId() + "%");
			count++;
		}

		Predicate subCatagoryNamePredicate = null;
		if (criteria.getSubCatagoryName() != null && criteria.getSubCatagoryName().length() > 0) {
			subCatagoryNamePredicate = criteriaBuilder.like(root.get("subCatagoryName"),
					"%" + criteria.getSubCatagoryName() + "%");
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
		if (subCatagoryNamePredicate != null) {
			listData[inserCount] = subCatagoryNamePredicate;
			inserCount++;
		}
		if (activePredicate != null) {
			listData[inserCount] = activePredicate;
			inserCount++;
		}

		return criteriaBuilder.and(listData);
	}

}