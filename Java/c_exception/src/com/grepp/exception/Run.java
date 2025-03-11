package com.grepp.exception;

import com.grepp.exception.coffee.Coffee;
import com.grepp.exception.custom.TimeOutException;
import java.net.MalformedURLException;

public class Run {

  // main 메소드에서 마저 throws를 하면 JVM이 예외처리를 해준다.
  // 단, 이 경우는 개발자가 예외처리를 하는 것이 아니기 때문에 권장하지 않는다.
  public static void main(String[] args) {
    A_Exception ex = new A_Exception();

    try {
      ex.throwTimeOutEx();
    } catch (TimeOutException e) {
      e.printStackTrace();
    }

    // ex.arithEx();
    // ex.malformedURLEx();
    // ex.throwsMalformedURLEx(); // 상위 클래스 (여기는 main)에서 동일한 예외 throws 해줘야함
    ex.throwNotValidEx(-1);

    Coffee coffee = new Coffee();
    coffee.provide();
  }
}
