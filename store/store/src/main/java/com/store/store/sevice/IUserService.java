package com.store.store.sevice;

import com.store.store.entity.User;

public interface IUserService {
  /**
   * 用户注册方法
   *
   * @param user 用户的数据对象
   */
  void reg(User user);

  /**
   * @param username
   * @param password
   * @return 返回匹配用户的数据，如果没有就返回null
   */
  User login(String username, String password);
  //User login(String username, String password);

}
