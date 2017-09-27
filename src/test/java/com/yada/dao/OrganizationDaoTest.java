package com.yada.dao;

import com.yada.model.Organization;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
@Transactional
public class OrganizationDaoTest {

    @Autowired
    private OrganizationDao organizationDao;

    @Test
    public void findOne() {
        List<Organization> list = organizationDao.findAll();
    }

}
