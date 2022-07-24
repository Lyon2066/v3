package com.store.store.mapper;

import com.store.store.entity.User;
import com.store.store.sevice.IUserService;
import com.store.store.sevice.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest // 表示当前类是测试类  不会随项目一块打包

public class UserMapperTests {

    //@Autowired
    @Resource
    private UserMapper userMapper;
    @Autowired
    private IUserService userService;

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("lyon222");
        user.setPassword("2222");
        Integer rows = userMapper.insert(user);
        System.out.println("插入数据：" + rows);
    }

    @Test
    public void findByUsername() {
        User user = userMapper.findByUsername("lyon");
        System.out.println(user.getPassword());
    }

    @Test
    void reg() {
        try {
            User user = new User();
            user.setUsername("lyon5556");
            user.setPassword("6666");
            userService.reg(user);
            System.out.println("插入数据：OK");
        } catch (ServiceException e) {
            // 获取异常类的对象  再获取异常类的名称
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }

    }
    @Test
    public void login() {
        User user = userService.login("Lyon008","000");
        System.out.println(user);
    }
}
