package com.grepp.oop.b_init;

public class A_init {

  // NOTE BB01 초기화 순서
  // 초기화 순서
  // 인스턴스 변수: JVM의 기본 값 -> 직접 대입한 값 -> 초기화 블록 -> 생성자
  // 클래스 변수: JVM의 기본 값 -> 직접 대입한 값 -> 초기화 블록
  private String name = "하명도";
  private static int classCode = 777;

  // NOTE BB02 초기화 블록 (인스턴스 초기화)
  {
    System.out.println("초기화 블록 호출");
    System.out.println("1. 직접 대입한 값 " + name);
    name = "PHD";
  }

  // NOTE BB03 static 초기화 블록
  static{
    System.out.println("static 초기화 블록 호출");
    System.out.println("1. static 직접 대입한 값: " + classCode);
    classCode = 888;
  }

  public A_init(String name){
    System.out.println("2. static 초기화블록에서 넣은 값: " + classCode);
    System.out.println("2. 초기화블록에서 넣은 값: " + this.name);
    System.out.println("생성자 호출");

    this.name = name;
    System.out.println("3. 생성자 넣은 값: " + this.name);
  }

  public static void loadClass(){

  }
}
