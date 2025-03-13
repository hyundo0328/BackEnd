package com.grepp.library.c_collection.practice;

import java.util.Iterator;

public class HashSet_<E> extends LinkedList_<E> {
  private int pointer;

  protected int hash(E e){
    // hashCode: -21억 ~ 21억
    int hashCode = Math.abs(e.hashCode()); // 순서 보장 X

    return hashCode % pointer;
  }

  @Override
  public boolean add(E e) {
    if(contains(e)){
      return false;
    }

    pointer++;
    int index = hash(e);
    super.add(index, e);

    return true;
  }

  public boolean remove(E e) {
    if(contains(e)){
      return false;
    }

    int index = hash(e);
    remove(index);
    pointer--;

    return true;
  }

  @Override
  public boolean contains(E e) {
    return super.contains(e);
  }

  @Override
  public boolean isEmpty() {
    return super.isEmpty();
  }

  @Override
  public int size() {
    return super.size();
  }
}
