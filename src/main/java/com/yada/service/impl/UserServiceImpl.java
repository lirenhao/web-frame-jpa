package com.yada.service.impl;

import com.yada.commons.result.PageInfo;
import com.yada.commons.utils.StringUtils;
import com.yada.dao.UserDao;
import com.yada.model.User;
import com.yada.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        if (StringUtils.isBlank(user.getPassword())) {
            user.setPassword(null);
        }
        userDao.saveAndFlush(user);
    }

    @Override
    public void updatePwdByUserId(Long userId, String md5Hex) {
        User user = new User();
        user.setId(userId);
        user.setPassword(md5Hex);
        userDao.saveAndFlush(user);
    }

    @Override
    public void selectDataGrid(PageInfo pageInfo) {
        Pageable page = new PageRequest(pageInfo.getNowpage() - 1, pageInfo.getSize(),
                "asc".equals(pageInfo.getOrder()) ? Sort.Direction.ASC : Sort.Direction.DESC, pageInfo.getSort());
        Page<User> users = userDao.findAll(page);

        // TODO 查询条件
        pageInfo.setRows(users.getContent());
        pageInfo.setTotal((int) users.getTotalElements());
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