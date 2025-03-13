package com.grepp.library.c_collection.b_list.grepp;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class _ArrayList<E> implements _List<E>{
  // List 패키지와 유사하게 작성

  private Object[] elementData;
  private static final int DEFAULT_CAPACITY = 10;
  private int pointer;
  private int arraySize;

  public _ArrayList(){
    elementData = new Object[DEFAULT_CAPACITY];
    arraySize = DEFAULT_CAPACITY;
  }

  @Override
  public int size(){
    return pointer;
  }

  @Override
  public boolean add(E e){
    // false로 반환되는 경우는 없음 (List 참고)

    if(pointer < arraySize){
      elementData[pointer] = e;
      pointer++;
      return true;
    }

    arraySize *= 2;
    Object[] temp = new Object[arraySize];

    for(int i=0; i< pointer; i++){
      temp[i] = elementData[i];
    }
    temp[pointer] = e;
    elementData = temp;
    pointer++;

    return true;
  }

  @Override
  public void add(int index, E e){
    if(index < 0 || index > pointer) throw new IndexOutOfBoundsException("벗어난 범위 인덱스");

    if(elementData[index] == null){
      elementData[index] = e;
    } else {
      if(pointer >= arraySize){
        arraySize *= 2;
      }

      System.arraycopy(elementData, index, elementData,
          index + 1,
          pointer - index);

      elementData[index] = e;
    }

    pointer++;
  }

  @Override
  public E set(int index, E e) {
    if(index < 0 || index >= pointer) throw new IndexOutOfBoundsException("벗어난 범위 인덱스");

    elementData[index] = e;

    return (E) elementData[index];
  }

  @Override
  public E remove(int index) {
    if(index < 0 || index >= pointer) throw new IndexOutOfBoundsException("벗어난 범위 인덱스");

    E removeE = (E) elementData[index];

    System.arraycopy(elementData, index + 1, elementData,
        index,
        pointer - index - 1);

    elementData[pointer - 1] = null; // 마지막 요소 제거 (null 처리)

    pointer--;

    return removeE;
  }

  @Override
  public E get(int index){
    if(index < 0 || index >= pointer) throw new IndexOutOfBoundsException("벗어난 범위 인덱스");

    return (E) elementData[index];
  }

  @Override
  public Iterator<E> iterator(){
    return new Iterator<E>() {

      private int pointer;

      @Override
      public boolean hasNext() {
        System.out.println("hasNext 실행");
        return pointer < size();
      }

      @Override
      public E next() {
        System.out.println("next 실행");
        if(pointer >= size()) throw new NoSuchElementException();

        E e = get(pointer++);

        return e;
      }
    };
  }
}
