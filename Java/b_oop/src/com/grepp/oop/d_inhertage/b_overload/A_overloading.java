package com.grepp.oop.d_inhertage.b_overload;

// NOTE BA01: Overloading (과적재)
// 같은 이름을 가진 메소드가 여러개 존재
// 매개 변수의 목록이나, 타입이 달라야 한다.
// 반환타입은 오버로딩을 결정하는 요소가 아니다.
public class A_overloading {
  public int divide(int a, int b){
    return a/b;
  }

  public int divide(int a, int b , int c){
    return a/b;
  }

  public int divide(double a, int b){
    return (int) (a/b);
  }

  public double divide(int a, int b){ // 반환타입이 달라도 에러
    double c = a;
    return a/b;
  }

  // NOTE BA02 가변인자
  // 메소드가 호출될 때 갯수 제한없이 인자를 여러 개 받을 수 있도록 하는 기능
  // 전달된 인자는 배열에 저장
  // 가변인자는 매개변수 중 가장 마지막에 선언
  public double plus(double a, double b, int...c){
    double res = a + b;
    System.out.println(c);
    for(double num:c){
      res += num;
    }

    return res;
  }
}
