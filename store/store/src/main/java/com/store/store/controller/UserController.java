package com.store.store.controller;

import com.store.store.entity.User;
import com.store.store.sevice.IUserService;
import com.store.store.sevice.ex.InsertException;
import com.store.store.sevice.ex.UsernameDuplicatedException;
import com.store.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController  // @Controller + ResponseBody
@RequestMapping("users")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;
    @RequestMapping("reg")
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
    public JsonResult<Void> reg(User user) {
        userService.reg(user);
        return new JsonResult<>(OK);
    }
}
