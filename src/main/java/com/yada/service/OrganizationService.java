package com.yada.service;

import com.yada.commons.result.Tree;
import com.yada.model.Organization;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Organization 表数据服务层接口
 */
@Service
public interface OrganizationService extends BaseService<Organization,Long> {

    List<Tree> selectTree();

    List<Organization> selectTreeGrid();
}