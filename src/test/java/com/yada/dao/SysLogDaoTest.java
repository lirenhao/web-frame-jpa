package com.yada.dao;

import com.yada.model.SysLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
@Transactional
public class SysLogDaoTest {

    @Autowired
    private SysLogDao sysLogDao;

    @Test
    public void findOne() {
        Pageable page = new PageRequest(0, 10, Sort.Direction.ASC, "id");
        Page<SysLog> list = sysLogDao.findAll(page);
        for(SysLog r: list.getContent()){
            System.out.println(r.toString());
        }
    }
}
