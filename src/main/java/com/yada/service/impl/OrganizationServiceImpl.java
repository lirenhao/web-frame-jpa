package com.yada.service.impl;

import com.yada.commons.result.Tree;
import com.yada.dao.OrganizationDao;
import com.yada.dao.UserDao;
import com.yada.model.Organization;
import com.yada.model.User;
import com.yada.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Organization 表数据服务层接口实现类
 */
@Repository
@Transactional
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationDao organizationDao;
    @Autowired
    private UserDao userDao;

    @Override
    public Organization findById(Long id) {
        return organizationDao.findOne(id);
    }

    @Override
    public void save(Organization model) {
        organizationDao.save(model);
    }

    @Override
    public void update(Organization model) {
        Organization orgInfo = organizationDao.findOne(model.getId());
        model.setCreateTime(orgInfo.getCreateTime());
        organizationDao.saveAndFlush(model);
    }

    @Override
    public void delete(Long id) {
        List<User> users = userDao.findByOrganization_Id(id);
        // 删除机构时删除对应的用户
        for (User user : users) {
            user.getRoles().clear();
            userDao.delete(user.getId());
        }
        organizationDao.delete(id);
    }

    @Override
    public List<Organization> selectTreeGrid() {
        return organizationDao.findAll(new Sort(Sort.Direction.ASC, "seq"));
    }

    @Override
    public List<Tree> selectTree() {
        List<Organization> organizationList = selectTreeGrid();

        List<Tree> trees = new ArrayList<Tree>();
        if (organizationList != null) {
            for (Organization organization : organizationList) {
                Tree tree = new Tree();
                tree.setId(organization.getId());
                tree.setText(organization.getName());
                tree.setIconCls(organization.getIcon());
                tree.setPid(organization.getPid());
                trees.add(tree);
            }
        }
        return trees;
    }
}