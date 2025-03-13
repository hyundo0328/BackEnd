package com.grepp.library.c_collection.practice;

import com.grepp.library.c_collection.b_list.grepp._LinkedList;
import com.grepp.library.c_collection.b_list.grepp._List;

public class Run {

  public static void main(String[] args) {
    List_<Integer> list = new LinkedList_<>();

    list.add(0, 5);
    list.add(1, 2);
    list.add(1,1);
    list.add(0,10);
    list.add(2,30);

    list.set(2, 99);
    for(Integer i:list){
      System.out.print(i+" ");
    }

    System.out.println("\n"+list.remove(0));
    for(Integer i:list){
      System.out.print(i+" ");
    }
  }
}
