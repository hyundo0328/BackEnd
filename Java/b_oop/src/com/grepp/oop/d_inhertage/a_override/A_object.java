package com.grepp.oop.d_inhertage.a_override;

import java.util.Objects;

// NOTE DA01 Object: 자바 클래스 상속 계층의 root 클래스
public class A_object {
  private String name;
  private String desc;

  public A_object(String name, String desc) {
    this.name = name;
    this.desc = desc;
  }

  // NOTE DA02: Override
  @Override
  public boolean equals(Object o) {
    // NOTE DA03: 동일성과 동등성
    if(!(o instanceof A_object aObject)){ // instanceof: 특정 클래스의 인스턴스인지 판단
      return false;
    }
    return Objects.equals(name, aObject.name) && Objects.equals(desc, aObject.desc);
  }

  // NOTE DA04: Hash
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  // NOTE DA05: annotation (주석)
  // annotation: 주석 (코드에 대한 정보), 메타데이터 (데이터에 대한 데이터)
  // 컴파일되거나 실행되는 시점에 컴파일러 및 외부 모듈에게 필요한 정보를 전달
  // @Override: 이 메소드는 부모클래스로부터 상속받은 메소드를 override한 메소드임을 컴파일러에게 전달
  //            컴파일러는 부모클래스에 이 메소드와 반환타입, 매개변수, 이름이 일치하는 메소드가 있는 지 확인 후 없으면 에러
  @Override
  public String toString(){
    return "A_object{" +
        "name= '" + name + '\'' +
        "desc= '" + desc + "\'}";
  }
}
