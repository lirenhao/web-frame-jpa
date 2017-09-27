package com.yada.service.impl;

import com.yada.commons.result.Tree;
import com.yada.commons.shiro.ShiroUser;
import com.yada.dao.ResourceDao;
import com.yada.dao.RoleDao;
import com.yada.model.Resource;
import com.yada.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Resource 表数据服务层接口实现类
 */
@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {

    private static final int RESOURCE_MENU = 0; // 菜单

    @Autowired
    private ResourceDao resourceDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Resource> selectAll() {
        return resourceDao.findAll(new Sort(Sort.Direction.ASC, "seq"));
    }

    @Override
    public List<Tree> selectAllMenu() {
        List<Tree> trees = new ArrayList<Tree>();
        // 查询所有菜单
        List<Resource> resources = resourceDao.findByResourceTypeOrderBySeq(RESOURCE_MENU);
        if (resources == null) {
            return trees;
        }
        resourceToTree(trees, resources);
        return trees;
    }

    @Override
    public List<Tree> selectAllTree() {
        // 获取所有的资源 tree形式，展示
        List<Tree> trees = new ArrayList<Tree>();
        List<Resource> resources = this.selectAll();
        if (resources == null) {
            return trees;
        }
        resourceToTree(trees, resources);
        return trees;
    }

    @Override
    public List<Tree> selectTree(ShiroUser shiroUser) {
        List<Tree> trees = new ArrayList<Tree>();
        // shiro中缓存的用户角色
        Set<String> roles = shiroUser.getRoles();
        if (roles == null) {
            return trees;
        }
        // 如果有超级管理员权限
        if (roles.contains("admin")) {
            List<Resource> resources = resourceDao.findByResourceTypeOrderBySeq(RESOURCE_MENU);
            if (resources == null) {
                return trees;
            }
            resourceToTree(trees, resources);
            return trees;
        }
        // 普通用户
        List<Long> roleIdList = roleDao.findIdByUserId(shiroUser.getId());
        if (roleIdList == null) {
            return trees;
        }
        List<Resource> resourceLists = roleDao.findResourceById(roleIdList);
        if (resourceLists == null) {
            return trees;
        }

        return trees;
    }

    private void resourceToTree(List<Tree> trees, List<Resource> resources) {
        for (Resource resource : resources) {
            Tree tree = new Tree();
            tree.setId(resource.getId());
            tree.setPid(resource.getPid());
            tree.setText(resource.getName());
            tree.setIconCls(resource.getIcon());
            tree.setAttributes(resource.getUrl());
            tree.setOpenMode(resource.getOpenMode());
            tree.setState(resource.getOpened());
            trees.add(tree);
        }
    }

    @Override
    public Resource findById(Long aLong) {
        return resourceDao.findOne(aLong);
    }

    @Override
    public void save(Resource model) {
        resourceDao.save(model);
    }

    @Override
    public void update(Resource model) {
        resourceDao.saveAndFlush(model);
    }

    @Override
    public void delete(Long aLong) {
        resourceDao.delete(aLong);
    }
}