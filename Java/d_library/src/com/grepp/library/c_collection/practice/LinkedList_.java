package com.grepp.library.c_collection.practice;

import com.grepp.library.c_collection.z_domain.Node;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList_<E> implements List_<E> {
  private Node_<E> head;
  private int pointer;

  @Override
  public boolean add(E e) {
    Node_<E> newNode = new Node_<>(e);

    if(isEmpty()){
      head = newNode;
      pointer++;

      return true;
    }

    Node_<E> link = head;
    while (link.next() != null) {
      link = link.next();
    }

    link.setNext(newNode);
    pointer++;

    return true;
  }

  @Override
  public void add(int index, E e) {
    if(index < 0 || index > pointer) throw new IndexOutOfBoundsException("벗어난 Index: "+index);

    Node_<E> newNode = new Node_<>(e);
    Node_<E> link = head;

    if(isEmpty()){
      head = newNode;
      pointer++;

      return;
    }

    if(index == 0){
      newNode.setNext(head);
      head = newNode;
    } else {
      for(int i=0; i<index-1; i++){
        link = link.next();
      }

      newNode.setNext(link.next());
      link.setNext(newNode);
    }

    pointer++;
  }

  @Override
  public E get(int index) {
    if(index < 0 || index >= pointer) throw new IndexOutOfBoundsException("벗어난 Index: "+index);

    Node_<E> link = head;

    for(int i=0; i<index; i++){
      link = link.next();
    }

    return link.data();
  }

  @Override
  public E set(int index, E e) {
    if(index < 0 || index >= pointer) throw new IndexOutOfBoundsException("벗어난 Index: "+index);

    Node_<E> link = head;

    for(int i=0; i<index; i++){
      link = link.next();
    }

    E modifiedData = link.data();
    link.setData(e);

    return modifiedData;
  }

  @Override
  public E remove(int index) {
    if(index < 0 || index >= pointer) throw new IndexOutOfBoundsException("벗어난 Index: "+index);

    Node_<E> link = head;
    Node_<E> prevNode = head;

    if(index == 0){
      head = head.next();
      pointer--;

      return link.data();
    }

    for(int i=0; i<index; i++){
      prevNode = link;
      link = link.next();
    }

    E removeNode = link.data();
    prevNode.setNext(link.next());
    pointer--;

    return removeNode;
  }

  // contains 메소드 구현
  public boolean contains(E e){
    Node_<E> link = head;

    while(link != null){
      if(link.data().equals(e)) return true;

      link = link.next();
    }

    return false;
  }

  @Override
  public int size() {
    return pointer;
  }

  public boolean isEmpty(){
    return pointer == 0;
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterator<E>() {
      private int pointer;

      @Override
      public boolean hasNext() {
//        System.out.println("hasNext 실행");
        return pointer < size();
      }

      @Override
      public E next() {
//        System.out.println("next 실행");
        if(pointer >= size()) throw new NoSuchElementException();

        return get(pointer++);
      }
    };
  }
}
