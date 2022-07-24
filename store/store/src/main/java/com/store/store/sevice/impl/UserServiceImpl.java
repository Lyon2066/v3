package com.store.store.sevice.impl;

import com.store.store.entity.User;
import com.store.store.mapper.UserMapper;
import com.store.store.sevice.IUserService;
import com.store.store.sevice.ex.InsertException;
import com.store.store.sevice.ex.PasswordNotMatchException;
import com.store.store.sevice.ex.UsernameDuplicatedException;
import com.store.store.sevice.ex.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {
  //@Autowired // 自动装载
  @Resource
  private UserMapper userMapper;

  @Override
  public void reg(User user) {
    // 首先调用 findByUsername() 判断用户是否注册过
    String username = user.getUsername();
    User result = userMapper.findByUsername(username);
    if (result != null) {
      throw new UsernameDuplicatedException("用户名被占用,请更改用户名");
    }

    String oldPassword = user.getPassword();
    String phone = user.getPhone();
    String salt = UUID.randomUUID().toString().toUpperCase();
    user.setSalt(salt); // 保存生成的 salt
    String md5Password = getMD5Password(oldPassword, salt);
    user.setPassword(md5Password);
    String getUsername = user.getUsername();
    Date d = new Date();
    System.out.println(phone);
    user.setPhone(phone);
    user.setIsDelete(0);
    user.setCreateUser(getUsername);
    user.setCreateTime(d);
    user.setModifiedUser(getUsername);
    user.setModifiedTime(d);
    Integer rows = userMapper.insert(user);
    if (rows != 1) {
      throw new InsertException("注册失败!!");
    }
    // 定义一个 md5 算法的加密处理
  }

  @Override
  public User login(String username,String password) {
    // 根据用户名称查询是否存在 不存在抛出异常
    User result = userMapper.findByUsername(username);
    if(result == null){
      throw new UsernameNotFoundException("用户名不存在");
    }
    String oldPassword = result.getPassword();
    String salt = result.getSalt();
    String newPassword = getMD5Password(password,salt);
    if(!newPassword.equals(oldPassword)){
      throw new PasswordNotMatchException("用户密码错误");
    }
    if( result.getIsDelete() == 1){
      throw new UsernameNotFoundException("用户数据不存在");
    }
    User user1 = new User();
    user1.setUid(result.getUid());
    user1.setUsername(result.getUsername());
    user1.setAvatar(result.getAvatar());
    return user1;
  }

  private String getMD5Password(String password, String salt) {
    // 加密三次
    for (int i = 0; i < 3; i++) {
      password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
    }
    return password;
  }
}
