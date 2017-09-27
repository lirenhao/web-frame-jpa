package com.yada.dao;

import com.yada.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Resource 表数据库控制层接口
 */
public interface ResourceDao extends JpaRepository<Resource, Long>, JpaSpecificationExecutor<Resource> {

    List<Resource> findByResourceTypeOrderBySeq(Integer type);
}