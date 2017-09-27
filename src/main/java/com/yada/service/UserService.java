package com.yada.service;

import com.yada.commons.base.BaseService;
import com.yada.commons.result.PageInfo;
import com.yada.model.User;

import java.util.List;

/**
 * User 表数据服务层接口
 */
public interface UserService extends BaseService<User, Long> {

    List<User> selectByLoginName(User user);

    void updatePwdByUserId(Long userId, String md5Hex);

    void selectDataGrid(PageInfo pageInfo);

}