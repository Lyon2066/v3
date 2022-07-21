package com.store.store.mapper;

import com.store.store.entity.User;

public interface UserMapper {
    /**
     * 插入用户数据
     * @param user 用户数据
     * @return 受影响的行数
     */
    Integer insert(User user);

    /**
     *  根据用户名查询用户名是否使用过
     * @param username
     * @return
     */
    User findByUsername (String username);
}
