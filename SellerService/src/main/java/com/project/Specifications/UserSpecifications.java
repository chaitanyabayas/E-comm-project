package com.project.Specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.project.Model.User;

public class UserSpecifications implements Specification<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final User criteria;

	public UserSpecifications(User criteria) {
		this.criteria = criteria;

	}

	@Override
	public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		if (criteria.getId() == null && criteria.getFirstName() == null && criteria.getLastName() == null
				&& criteria.getMobileNo() == null && criteria.getContactNo() == null && criteria.getEmail() == null
				&& criteria.getUserImage() == null && criteria.getActive() == null) {
			return null;
		}

		Integer count = 0;
		Predicate[] listData;

		Predicate idPredicate = null;
		if (criteria.getId() != null) {
			idPredicate = criteriaBuilder.like(root.get("id").as(String.class), "%" + criteria.getId() + "%");
			count++;
		}

		Predicate firstNamePredicate = null;
		if (criteria.getFirstName() != null && criteria.getFirstName().length() > 0) {
			firstNamePredicate = criteriaBuilder.like(root.get("firstName"), "%" + criteria.getFirstName() + "%");
			count++;
		}

		Predicate lastNamePredicate = null;
		if (criteria.getLastName() != null && criteria.getLastName().length() > 0) {
			lastNamePredicate = criteriaBuilder.like(root.get("lastName"), "%" + criteria.getLastName() + "%");
			count++;
		}

		Predicate mobilePredicate = null;
		if (criteria.getMobileNo() != null && criteria.getMobileNo().length() > 0) {
			mobilePredicate = criteriaBuilder.like(root.get("mobileNo"), "%" + criteria.getMobileNo() + "%");
			count++;
		}

		Predicate contactNoPredicate = null;
		if (criteria.getContactNo() != null && criteria.getContactNo().length() > 0) {
			contactNoPredicate = criteriaBuilder.like(root.get("contactNo"), "%" + criteria.getContactNo() + "%");
			count++;
		}

		Predicate emailPredicate = null;
		if (criteria.getEmail() != null && criteria.getEmail().length() > 0) {
			emailPredicate = criteriaBuilder.like(root.get("email"), "%" + criteria.getEmail() + "%");
			count++;
		}

		Predicate imagePredicate = null;
		if (criteria.getUserImage() != null && criteria.getUserImage().length() > 0) {
			imagePredicate = criteriaBuilder.like(root.get("userImage"), "%" + criteria.getUserImage() + "%");
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
		if (firstNamePredicate != null) {
			listData[inserCount] = firstNamePredicate;
			inserCount++;
		}
		if (lastNamePredicate != null) {
			listData[inserCount] = lastNamePredicate;
			inserCount++;
		}
		if (mobilePredicate != null) {
			listData[inserCount] = mobilePredicate;
			inserCount++;
		}
		if (contactNoPredicate != null) {
			listData[inserCount] = contactNoPredicate;
			inserCount++;
		}
		if (emailPredicate != null) {
			listData[inserCount] = emailPredicate;
			inserCount++;
		}
		if (imagePredicate != null) {
			listData[inserCount] = imagePredicate;
			inserCount++;
		}
		if (activePredicate != null) {
			listData[inserCount] = activePredicate;
			inserCount++;
		}

		return criteriaBuilder.and(listData);
	}

}
