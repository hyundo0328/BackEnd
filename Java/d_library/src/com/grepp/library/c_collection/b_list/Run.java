package com.grepp.library.c_collection.b_list;

import com.grepp.library.c_collection.b_list.grepp._ArrayList;
import com.grepp.library.c_collection.b_list.grepp._LinkedList;
import com.grepp.library.c_collection.b_list.grepp._List;
import com.grepp.library.c_collection.z_domain.School;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Run {

  public static void main(String[] args) {
    // NOTE B01: CRUD
    pracAdd();
//    pracGet();
//    pracSet();
//    pracRemove();
//    pracSort();
//    pracIterable();
  }

  private static void pracAdd() {
    // _ArrayList<Integer> list = new _ArrayList<>();
    _LinkedList<Integer> list = new _LinkedList<>();
//    for(int i=1; i<=10; i++){
//      list.add(i);
//    }
    list.add(0, 5);
    list.add(1, 2);
    list.add(1,1);
    list.add(0,10);
    list.add(2,30);

//    list.set(2, 99);
//    System.out.println("\n"+list.remove(3));

    for(int i=0; i<list.size(); i++){
      System.out.print(list.get(i)+" ");
    }
  }

  private static void pracGet() {
    List<String> list = new ArrayList<>();
    list.add("A");
    list.add("B");
    list.add("C");

    for(int i=0; i<list.size(); i++){
      System.out.println(list.get(i));
    }
  }

  private static void pracSet() {
    School seoul = new School("서울대", "관악구", 4);
    School yeonsae = new School("연세대", "서대문구", 4);
    School minsa = new School("민사고", "대전광역시", 3);
    School grepp = new School("그랩", "삼성", 2);
    School semyoung = new School("세명초", "속초", 1);

    _LinkedList<School> list = new _LinkedList<>();

    list.add(seoul);
    list.add(yeonsae);

    System.out.println(list);

    list.set(0, grepp);
    System.out.println(list.get(0));
  }

  private static void pracRemove() {
    _LinkedList<Integer> list = new _LinkedList<>();

    for(int i=1; i<=10; i++){
      list.add(i);
    }
    System.out.println(list);

    list.remove(2);

    for(int i=0; i<9; i++){
      System.out.print(list.get(i) + " ");
    }

//     List<Integer> subList = list.subList(0,4);
//    System.out.println(list);
//    list.removeAll(subList);
//    System.out.println(list);
//    System.out.println(subList);
  }

  private static void pracSort(){
    School seoul = new School("서울대", "관악구", 4);
    School yeonsae = new School("연세대", "서대문구", 4);
    School minsa = new School("민사고", "대전광역시", 3);
    School grepp = new School("그랩", "삼성", 2);
    School semyoung = new School("세명초", "속초", 1);

    // List.of: 불변 리스트
//    List<School> schools = List.of(seoul, yeonsae, minsa, grepp, semyoung);
//    List<Integer> nums = List.of(1,8,4,2,7,5,10,3,9,6);
    List<School> schools = new ArrayList<>(List.of(seoul, yeonsae, minsa, grepp, semyoung));
    List<Integer> nums = new ArrayList<>(List.of(1,8,4,2,7,5,10,3,9,6));

//    Collections.sort(nums);
//    System.out.println(nums);
    Collections.sort(schools);
    System.out.println(schools);
  }

  private static void pracIterable(){
    // _ArrayList<Integer> list = new _ArrayList<>();
    // _LinkedList<Integer> list = new _LinkedList<>();
    _List<Integer> list = new _LinkedList<>();

    for(int i=0; i<10; i++){
      list.add(i);
    }
    System.out.println(list);

    for(int i=0; i<10; i++){
      System.out.println(list.get(i));
    }

//    for(Integer i:list){
//      System.out.println(i);
//    }
  }
}
