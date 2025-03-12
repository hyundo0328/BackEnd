package com.grepp.library.c_collection.b_list.grepp;

import com.grepp.library.c_collection.z_domain.Node;
import java.util.NoSuchElementException;

public class _LinkedList<E> implements _List<E>, _Iterable<E> {
  private Node<E> head;
  private int pointer;

  @Override
  public int size(){
    return pointer;
  }

  public boolean isEmpty(){
    return pointer == 0;
  }

  @Override
  public boolean add(E e){
    Node<E> current = new Node<>(e);

    if(isEmpty()){
      head = current;
      pointer++;

      return true;
    }

    // link.next가 null인 곳을 찾아서 연결
    Node<E> link = head;
    while(link.next() != null){
      link = link.next();
    }

    link.setNext(current);
    pointer++;

    return true;
  }

  @Override
  public void add(int index, E e){
    if(index < 0 || index > pointer) throw new IndexOutOfBoundsException("인덱스 벗어남 " + index + e.toString());

    Node<E> current = new Node<>(e);
    Node<E> link = head;

    if(index == 0){
      // 추가할 Node를 head로 변경하고 현재 Node.next에 현재 head를 연결
      current.setNext(head);
      head = current;
    } else {
      // index-1까지 이동한 후 link.next를 current.next로 옮긴 후
      // link.next를 current로 변경
      for(int i=0; i<index-1; i++){
        link = link.next();
      }

      current.setNext(link.next());
      link.setNext(current);
    }

    pointer++;
  }

  @Override
  public E get(int index){
    if(index < 0 || index >= pointer) throw new IndexOutOfBoundsException();

    Node<E> link = head;

    for(int i=0; i<index; i++){
      link = link.next();
    }

    return link.data();
  }

  @Override
  public E set(int index, E e){
    if(index < 0 || index >= pointer) throw new IndexOutOfBoundsException();

    Node<E> link = head;

    for(int i=0; i<index; i++){
       link = link.next();
    }

    E modified = link.data();
    link.setData(e);

    return modified;
  }

  @Override
  public E remove(int index){
    if(index < 0 || index >= pointer) throw new IndexOutOfBoundsException();

    Node<E> prevNode = head;
    Node<E> link = head;

    if(index == 0){
      head = head.next();
      pointer--;

      return prevNode.data();
    }

    for(int i=0; i<index; i++){
      prevNode = link;
      link = link.next();
    }

    prevNode.setNext(link.next());
    pointer--;

    return link.data();
  }

  @Override
  public _Iterator<E> iterator() {
    return new _Iterator<E>() {
      private Node<E> current = head;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public E next() {
        if(pointer >= size()) throw new NoSuchElementException("Element");

        E e = get(pointer);
        pointer++;

        return e;
      }
    };
  }
}
