package com.yada.query;

import com.yada.model.Organization;
import com.yada.model.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.LinkedList;
import java.util.List;

public class UserQuery implements Specification<User> {

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

        if (organizationId != null && !"".equals(organizationId.trim())) {
            Join<User, Organization> join = root.join("organization", JoinType.LEFT);
            list.add(cb.equal(join.get("id").as(String.class), organizationId.trim()));
        }
        if (name != null && !"".equals(name.trim())) {
            list.add(cb.equal(root.get("name").as(String.class), name.trim()));
        }

        if (list.size() > 0) {
            query.where(list.toArray(new Predicate[list.size()]));
        }

        return query.getRestriction();
    }
}
