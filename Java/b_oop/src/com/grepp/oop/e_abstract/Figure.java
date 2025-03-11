package com.grepp.oop.e_abstract;

// NOTE E01 추상클래스
// 추상 클래스는 미완성의 클래스, 인스턴스화가 불가능하다.
// 추상 클래스를 상속받은 자식클래스는 추상메소드를 강제로 Override 해야한다.
public abstract class Figure {
  protected int area;

  public abstract double calcArea();
}
