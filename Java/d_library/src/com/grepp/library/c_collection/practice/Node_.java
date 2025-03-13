package com.grepp.library.c_collection.practice;

public class Node_<E> {
  private Node_<E> next;
  private E data;

  public Node_(E data) {
    this.data = data;
  }

  public E data() {
    return data;
  }

  public void setData(E data) {
    this.data = data;
  }

  public Node_<E> next() {
    return next;
  }

  public void setNext(Node_<E> next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return "_Node{" +
        "data=" + data +
        '}';
  }
}
