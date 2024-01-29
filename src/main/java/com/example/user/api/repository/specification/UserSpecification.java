package com.example.user.api.repository.specification;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.example.user.api.entity.User;

import jakarta.persistence.criteria.Predicate;

@Component
public class UserSpecification {
	
	public Specification<User> createUserSpecification(String firstName, String lastName){
		return (root, query, criteriaBuilder) -> {
			final List<Predicate> andPredicateList = new ArrayList<>();
			
			if(StringUtils.isNotBlank(firstName)) {
				andPredicateList.add(criteriaBuilder.equal(root.get("firstName"), firstName));
			}			
			if(StringUtils.isNotBlank(lastName)) {
				andPredicateList.add(criteriaBuilder.equal(root.get("lastName"), lastName));
			}
			
			return CollectionUtils.isNotEmpty(andPredicateList)
	                ? criteriaBuilder.and(andPredicateList.toArray(Predicate[]::new))
	                : null;
		};
	}

}