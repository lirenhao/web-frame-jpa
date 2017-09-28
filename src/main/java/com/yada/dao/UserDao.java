package com.yada.dao;

import com.yada.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * User 表数据库控制层接口
 */
public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    List<User> findByLoginName(String loginName);

    List<User> findByLoginNameAndIdNot(String loginName, Long id);

    @Query("SELECT role.id FROM User as user JOIN user.roles role WHERE user.id = :id")
    List<Long> findRoleIdById(@Param("id") Long id);

    List<User> findByRoles_Id(Long id);
}