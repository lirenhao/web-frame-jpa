package com.yada.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseService<T, ID> {

    // 根据ID查询
    T findById(ID id);

    // 新增
    void save(T model);

    // 更新
    void update(T model);

    // 删除
    void delete(ID id);
}