package com.yada.dao;

import com.yada.model.Resource;
import com.yada.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Role 表数据库控制层接口
 */
public interface RoleDao extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {

    List<Role> findByResources_Id(Long id);

    @Query("SELECT resource FROM Role as role JOIN role.resources resource WHERE resource.resourceType = 0 AND role.id in :ids")
    List<Resource> findResourceById(@Param("ids") List<Long> ids);
}