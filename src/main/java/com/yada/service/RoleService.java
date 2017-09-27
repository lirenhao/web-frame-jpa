package com.yada.service;

import com.yada.commons.base.BaseService;
import com.yada.commons.result.Data;
import com.yada.model.Role;
import com.yada.query.RoleQuery;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Role 表数据服务层接口
 */
public interface RoleService extends BaseService<Role, Long> {

    Data selectDataGrid(RoleQuery query);

    Object selectTree();

    List<Long> selectResourceIdListByRoleId(Long id);

    void updateRoleResource(Long id, String resourceIds);

    Map<String, Set<String>> selectResourceMapByUserId(Long userId);

}