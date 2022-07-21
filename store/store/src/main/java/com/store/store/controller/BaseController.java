package com.store.store.controller;

import com.store.store.sevice.ex.InsertException;
import com.store.store.sevice.ex.ServiceException;
import com.store.store.sevice.ex.UsernameDuplicatedException;
import com.store.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 控制层类的基类
public class BaseController {
    // 操作成功
    public static final int OK = 200;

    // 请求处理的方法 这个方法的返回值就是需求传递给前端的数据
    // 自动将异常对象传递给此方法的参数列表上
    @ExceptionHandler(ServiceException.class) // 用于🙆‍统一处理抛出的异常
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameDuplicatedException) {
            result.setState(4000);
            result.setMessage("用户名已占用");
        } else if (e instanceof InsertException) {
            result.setState(5000);
            result.setMessage("注册产生未知的异常");
        }
        return result;
    }

}
