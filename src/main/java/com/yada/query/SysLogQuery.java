package com.yada.query;

import com.yada.commons.base.BaseQuery;
import com.yada.model.SysLog;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class SysLogQuery extends BaseQuery<SysLog> {

    @Override
    public Predicate toPredicate(Root<SysLog> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return null;
    }
}
