package com.yada.service.impl;

import com.yada.commons.result.Data;
import com.yada.dao.SysLogDao;
import com.yada.model.SysLog;
import com.yada.query.SysLogQuery;
import com.yada.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * SysLog 表数据服务层接口实现类
 */
@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public Data selectDataGrid(SysLogQuery query) {
        Pageable page = new PageRequest(query.getPage(), query.getRows(), query.getOrder(), query.getSort());
        Page<SysLog> sysLogs = sysLogDao.findAll(page);
        return new Data(sysLogs.getTotalElements(), sysLogs.getContent());
    }


    @Override
    public SysLog findById(Long aLong) {
        return sysLogDao.findOne(aLong);
    }

    @Override
    public void save(SysLog model) {
        sysLogDao.save(model);
    }

    @Override
    public void update(SysLog model) {
        sysLogDao.saveAndFlush(model);
    }

    @Override
    public void delete(Long aLong) {
        sysLogDao.delete(aLong);
    }
}