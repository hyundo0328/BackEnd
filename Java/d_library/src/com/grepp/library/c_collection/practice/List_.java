package com.grepp.library.c_collection.practice;

public interface List_<E> extends Iterable<E>{
  void add(int index, E e);
  boolean add(E e);
  E get(int index);
  E set(int index, E e);
  E remove(int index);
  int size();
}
