package com.yada.dao;

import com.yada.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Organization 表数据库控制层接口
 */

public interface OrganizationDao extends JpaRepository<Organization, Long> {

}