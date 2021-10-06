package com.project.Specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.project.Model.Catagory;

public class CatagorySpecification implements Specification<Catagory> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Catagory criteria;

	public CatagorySpecification(Catagory criteria) {
		this.criteria = criteria;

	}

	@Override
	public Predicate toPredicate(Root<Catagory> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		if (criteria.getId() == null && criteria.getCatagoryName() == null && criteria.getActive() == null) {
			return null;
		}

		Integer count = 0;
		Predicate[] listData;

		Predicate idPredicate = null;
		if (criteria.getId() != null) {
			idPredicate = criteriaBuilder.like(root.get("id").as(String.class), "%" + criteria.getId() + "%");
			count++;
		}

		Predicate catagoryNamePredicate = null;
		if (criteria.getCatagoryName() != null && criteria.getCatagoryName().length() > 0) {
			catagoryNamePredicate = criteriaBuilder.like(root.get("catagoryName"),
					"%" + criteria.getCatagoryName() + "%");
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
		if (catagoryNamePredicate != null) {
			listData[inserCount] = catagoryNamePredicate;
			inserCount++;
		}
		if (activePredicate != null) {
			listData[inserCount] = activePredicate;
			inserCount++;
		}

		return criteriaBuilder.and(listData);
	}

}