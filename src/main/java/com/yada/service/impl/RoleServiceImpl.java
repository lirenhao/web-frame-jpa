package com.yada.service.impl;

import com.yada.commons.result.PageInfo;
import com.yada.commons.result.Tree;
import com.yada.commons.utils.StringUtils;
import com.yada.dao.RoleDao;
import com.yada.dao.UserDao;
import com.yada.model.Resource;
import com.yada.model.Role;
import com.yada.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Role 表数据服务层接口实现类
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserDao userDao;

    @Override
    public void selectDataGrid(PageInfo pageInfo) {
        // TODO 修改数据传输
        Pageable page = new PageRequest(pageInfo.getNowpage() - 1, pageInfo.getSize(),
                "asc".equals(pageInfo.getOrder()) ? Sort.Direction.ASC : Sort.Direction.DESC, pageInfo.getSort());
        Page<Role> roles = roleDao.findAll(page);

        pageInfo.setRows(roles.getContent());
        pageInfo.setTotal((int) roles.getTotalElements());
    }

    @Override
    public Object selectTree() {
        List<Tree> trees = new ArrayList<Tree>();
        List<Role> roles = roleDao.findAll(new Sort(Sort.Direction.ASC, "seq"));
        for (Role role : roles) {
            Tree tree = new Tree();
            tree.setId(role.getId());
            tree.setText(role.getName());

            trees.add(tree);
        }
        return trees;
    }

    @Override
    public void updateRoleResource(Long roleId, String resourceIds) {
        // 先删除后添加,有点爆力
        roleDao.delete(roleId);

        Role role = new Role();
        Set<Resource> resources = new HashSet<Resource>();

        String[] resourceIdArray = resourceIds.split(",");
        for (String resourceId : resourceIdArray) {
            Resource resource = new Resource();
            resource.setId(Long.parseLong(resourceId));
        }
        role.setResources(resources);
        roleDao.save(role);
    }

    @Override
    public List<Long> selectResourceIdListByRoleId(Long id) {
        return roleDao.findResourceIdById(id);
    }

    @Override
    public Map<String, Set<String>> selectResourceMapByUserId(Long userId) {
        Map<String, Set<String>> resourceMap = new HashMap<String, Set<String>>();
        Set<String> urlSet = new HashSet<String>();
        Set<String> roles = new HashSet<String>();

        List<Long> roleIdList = userDao.findRoleIdById(userId);
        for (Long roleId : roleIdList) {
            Role role = roleDao.findOne(roleId);
            if (role != null) {
                roles.add(role.getName());
                if (role.getResources() != null) {
                    for (Resource resource : role.getResources()) {
                        if (StringUtils.isNotBlank(resource.getUrl())) {
                            urlSet.add(resource.getUrl());
                        }
                    }
                }
            }
        }
        resourceMap.put("urls", urlSet);
        resourceMap.put("roles", roles);
        return resourceMap;
    }

    @Override
    public Role findById(Long aLong) {
        return roleDao.findOne(aLong);
    }

    @Override
    public void save(Role model) {
        roleDao.save(model);
    }

    @Override
    public void update(Role model) {
        roleDao.saveAndFlush(model);
    }

    @Override
    public void delete(Long aLong) {
        roleDao.delete(aLong);
    }
}