package com.store.store.controller;

import com.store.store.entity.User;
import com.store.store.sevice.IUserService;
import com.store.store.sevice.ex.InsertException;
import com.store.store.sevice.ex.UsernameDuplicatedException;
import com.store.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController  // @Controller + ResponseBody
@RequestMapping("users")
public class UserController extends BaseController {
  @Autowired
  private IUserService userService;

  //@ResponseBody  // 表示此方法的响应结果以json 格式进行数据响应给到前端
  //public JsonResult<Void> reg(User user) {
  //    JsonResult<Void> result = new JsonResult<>();
  //    try {
  //        userService.reg(user);
  //        result.setState(200);
  //        result.setMessage("注册成功");
  //    } catch (UsernameDuplicatedException e){
  //        result.setState(4000);
  //        result.setMessage("用户名被占用");
  //    } catch (InsertException e) {
  //        result.setState(5000);
  //        result.setMessage("注册时产生未知的异常");
  //    }
  //    return result;
  //}

  /**
   *  注册接口
   * @param user
   * @returnhttp://localhost:8080/users/reg?username=111&password=111
   */
  @RequestMapping("reg")
  public JsonResult<Void> reg(User user) {
    userService.reg(user);
    return new JsonResult<>(OK);
  }

  /**
   * 登录接口
   //* @param username
   * @param user
   * @return http://localhost:8080/users/login
   */
  //@RequestMapping(value = "login",method = RequestMethod.POST)
  @RequestMapping("login")
  public JsonResult<User> login(@RequestBody User user) {
    String username = user.getUsername();
    String password = user.getPassword();
    User data = userService.login(username, password);
    return new JsonResult<User>(OK, data);
  }
}
