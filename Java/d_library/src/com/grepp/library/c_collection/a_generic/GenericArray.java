package com.grepp.library.c_collection.a_generic;

import com.grepp.library.c_collection.a_generic.domain.Device;

// NOTE A01: Generic
// 클래스 외부에서 클래스 내부에서 사용할 타입을 결정하는 것
// 클래스 선언부나 메소드 선언부에 <Generic 매개변수> 선언해 사용 가능
// Generic은 여러개 사용할 수 있다.
public class GenericArray<E> {
  private Object[] elements;
  private int size;
  private int pointer;

  public GenericArray(int size) {
    this.size = size;
    elements = new Object[size];
  }

  // NOTE 02 제네릭 메소드
  public static <T> GenericArray<T> practiceGeneric(T a){
    GenericArray<T> instance = new GenericArray<>(10);
    instance.add(a);

    return instance;
  }

  // NOTE 03 타입 한정 키워드
  // T extend Device: Device 타입을 포함한 후손 타입
  public static <T extends Device> GenericArray<T> practiceExtends(T e){
    GenericArray<T> instance = new GenericArray<>(10);
    instance.add(e);

    return instance;
  }

  public int getSize(){
    return size;
  }

  public void add(E d){
    if(pointer == size){
      // throw new ArrayIndexOutOfBoundsException();

      System.out.println("용량이 부족");
      return;
    }

    elements[pointer++] = d;
  }

  public E get(int idx){
    if(idx < 0 || idx >= size) throw new IndexOutOfBoundsException();
    return (E) elements[idx];
  }
}
