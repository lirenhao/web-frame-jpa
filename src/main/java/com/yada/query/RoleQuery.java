package com.yada.query;

import com.yada.commons.base.BaseQuery;
import com.yada.model.Role;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class RoleQuery extends BaseQuery<Role> {

    @Override
    public Predicate toPredicate(Root<Role> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return null;
    }
}
