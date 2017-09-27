package com.yada.service.impl;

import com.yada.commons.result.Tree;
import com.yada.dao.OrganizationDao;
import com.yada.model.Organization;
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

    @Override
    public Organization findById(Long id) {
        return organizationDao.getOne(id);
    }

    @Override
    public void save(Organization model) {
        organizationDao.save(model);
    }

    @Override
    public void update(Organization model) {
        organizationDao.saveAndFlush(model);
    }

    @Override
    public void delete(Long id) {
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