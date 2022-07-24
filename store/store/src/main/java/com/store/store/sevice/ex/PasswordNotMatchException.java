package com.store.store.sevice.ex;

public class PasswordNotMatchException extends ServiceException{
  public PasswordNotMatchException() {
    super(); //默认继承父类的构造方法，可以省略
  }

  public PasswordNotMatchException(String message) {
    super(message);
  }

  public PasswordNotMatchException(String message, Throwable cause) {
    super(message, cause);
  }

  public PasswordNotMatchException(Throwable cause) {
    super(cause);
  }

  public PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
