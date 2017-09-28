package com.yada.query;

import com.yada.commons.base.BaseQuery;
import com.yada.model.Organization;
import com.yada.model.User;

import javax.persistence.criteria.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class UserQuery extends BaseQuery<User> {

    private String organizationId;

    private String name;

    private String startTime;

    private String endTime;

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

        List<Predicate> list = new LinkedList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if (organizationId != null && !"".equals(organizationId.trim())) {
            Join<User, Organization> join = root.join("organization", JoinType.LEFT);
            list.add(cb.equal(join.get("id").as(String.class), organizationId.trim()));
        }
        if (name != null && !"".equals(name.trim())) {
            list.add(cb.equal(root.get("name").as(String.class), name.trim()));
        }
        if (startTime != null && !"".equals(startTime.trim())) {
            try {
                Date startDate = sdf.parse(startTime.trim());
                list.add(cb.greaterThanOrEqualTo(root.get("createTime").as(Date.class), startDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (endTime != null && !"".equals(endTime.trim())) {
            try {
                Date endDate = sdf.parse(endTime.trim());
                list.add(cb.lessThanOrEqualTo(root.get("createTime").as(Date.class), endDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (list.size() > 0) {
            query.where(list.toArray(new Predicate[list.size()]));
        }

        return query.getRestriction();
    }
}
