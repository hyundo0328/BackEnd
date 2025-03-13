package com.grepp.library.c_collection.practice;

public class EntrySet_<E> extends HashSet_<E> {

  public EntrySet_() {
  }

  @Override
  public boolean add(E e) {
    if(super.contains(e)){
      int index = super.hash(e);
      super.set(index, e);

      return true;
    }

    return super.add(e);
  }

  public E get(E e) {
    int index = super.hash(e);

    E data = super.get(index);

    return data;
  }
}
