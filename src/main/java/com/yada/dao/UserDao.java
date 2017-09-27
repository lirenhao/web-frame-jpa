package com.yada.dao;

import com.yada.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * User 表数据库控制层接口
 */
public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    List<User> findByLoginName(String loginName);

    List<User> findByLoginNameAndIdNot(String loginName, Long id);
}