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

    @Query("SELECT role.id FROM Role as role JOIN role.users user WHERE user.id = :id")
    List<Long> findIdByUserId(@Param("id") Long userId);

    List<Long> findResourceIdById(Long id);

    @Query("SELECT role.resources FROM Role as role WHERE role.id in :ids")
    List<Resource> findResourceById(@Param("ids") List<Long> ids);
}