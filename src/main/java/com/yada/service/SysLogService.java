package com.yada.service;

import com.yada.commons.base.BaseService;
import com.yada.commons.result.Data;
import com.yada.model.SysLog;
import com.yada.query.SysLogQuery;

/**
 * SysLog 表数据服务层接口
 */
public interface SysLogService extends BaseService<SysLog, Long> {

    Data selectDataGrid(SysLogQuery query);
}