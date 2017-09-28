package com.yada.controller;

import com.yada.commons.result.Data;
import com.yada.query.SysLogQuery;
import com.yada.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 日志管理
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @GetMapping("/manager")
    public String manager() {
        return "admin/syslog";
    }

    @PostMapping("/dataGrid")
    @ResponseBody
    public Data dataGrid(SysLogQuery query) {
        return sysLogService.selectDataGrid(query);
    }
}
