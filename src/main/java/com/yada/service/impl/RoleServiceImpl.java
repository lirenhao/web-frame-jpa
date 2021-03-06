package com.yada.service.impl;

import com.yada.commons.result.Data;
import com.yada.commons.result.Tree;
import com.yada.commons.utils.StringUtils;
import com.yada.dao.ResourceDao;
import com.yada.dao.RoleDao;
import com.yada.dao.UserDao;
import com.yada.model.Resource;
import com.yada.model.Role;
import com.yada.model.User;
import com.yada.query.RoleQuery;
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
    @Autowired
    private ResourceDao resourceDao;


    @Override
    public Data selectDataGrid(RoleQuery query) {
        Pageable page = new PageRequest(query.getPage(), query.getRows(), query.getOrder(), query.getSort());
        Page<Role> roles = roleDao.findAll(page);
        return new Data(roles.getTotalElements(), roles.getContent());
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
        Role role = roleDao.findOne(roleId);
        role.getResources().clear();

        String[] resourceIdArray = resourceIds.split(",");
        for (String resourceId : resourceIdArray) {
            Resource resource = resourceDao.findOne(Long.parseLong(resourceId));
            role.getResources().add(resource);
        }
        roleDao.saveAndFlush(role);
    }

    @Override
    public List<Long> selectResourceIdListByRoleId(Long id) {
        Role role = roleDao.findOne(id);
        List<Long> resourceIds = new ArrayList<Long>();
        for (Resource r : role.getResources()) {
            resourceIds.add(r.getId());
        }
        return resourceIds;
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
        Role role = roleDao.findOne(model.getId());
        model.setResources(role.getResources());
        roleDao.saveAndFlush(model);
    }

    @Override
    public void delete(Long aLong) {
        Role role = roleDao.findOne(aLong);
        role.getResources().clear();
        List<User> users = userDao.findByRoles_Id(aLong);
        for (User user : users) {
            user.getRoles().remove(role);
        }
        roleDao.delete(aLong);
    }
}