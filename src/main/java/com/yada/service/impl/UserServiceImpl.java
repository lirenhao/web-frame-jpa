package com.yada.service.impl;

import com.yada.commons.result.Data;
import com.yada.commons.utils.StringUtils;
import com.yada.dao.UserDao;
import com.yada.model.User;
import com.yada.query.UserQuery;
import com.yada.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * User 表数据服务层接口实现类
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> selectByLoginName(User user) {
        if (null != user.getId()) {
            return userDao.findByLoginNameAndIdNot(user.getLoginName(), user.getId());
        }
        return userDao.findByLoginName(user.getLoginName());
    }

    @Override
    public void update(User user) {
        User userInfo = userDao.findOne(user.getId());
        if (StringUtils.isBlank(user.getPassword())) {
            user.setPassword(userInfo.getPassword());
        }
        user.setSalt(userInfo.getSalt());
        user.setCreateTime(userInfo.getCreateTime());
        userDao.saveAndFlush(user);
    }

    @Override
    public void updatePwdByUserId(Long userId, String md5Hex) {
        User user = userDao.findOne(userId);
        user.setId(userId);
        user.setPassword(md5Hex);
        userDao.saveAndFlush(user);
    }

    @Override
    public Data selectDataGrid(UserQuery query) {
        Pageable page = new PageRequest(query.getPage(), query.getRows(), query.getOrder(), query.getSort());
        Page<User> users = userDao.findAll(query, page);
        return new Data(users.getTotalElements(), users.getContent());
    }


    @Override
    public void save(User user) {
        user.setCreateTime(new Date());
        userDao.save(user);
    }

    @Override
    public void delete(Long aLong) {
        userDao.delete(aLong);
    }

    @Override
    public User findById(Long aLong) {
        return userDao.findOne(aLong);
    }
}