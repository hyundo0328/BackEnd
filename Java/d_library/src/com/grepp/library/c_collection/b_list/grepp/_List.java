package com.grepp.library.c_collection.b_list.grepp;

public interface _List<E> {
  boolean add(E e);
  void add(int index, E e);
  E set(int index, E e);
  E get(int index);
  E remove(int index);
  int size();
}
