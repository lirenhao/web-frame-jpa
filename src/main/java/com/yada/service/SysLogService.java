package com.yada.service;

import com.yada.commons.result.PageInfo;
import com.yada.model.SysLog;

/**
 * SysLog 表数据服务层接口
 */
public interface SysLogService extends BaseService<SysLog, Long> {

    void selectDataGrid(PageInfo pageInfo);

}