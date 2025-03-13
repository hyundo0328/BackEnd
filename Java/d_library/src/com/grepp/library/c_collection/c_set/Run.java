package com.grepp.library.c_collection.c_set;

import com.grepp.library.c_collection.z_domain.School;
import com.grepp.library.c_collection.z_domain.SchoolFactory;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Run {

  public static void main(String[] args) {
//    pracAdd();
    pracRemove();

    List<String> firstList = List.of("김가희","김예원","박현도","안재호","안세희");
    List<String> secondList = List.of("전정원","정서윤","채철민","최대열","안세희");
    Set<String> firstSet = new HashSet<>(firstList);
    Set<String> secondSet = new HashSet<>(secondList);
//    pracSetOperation(firstSet, secondSet);
  }

  private static void pracAdd() {
    Set<School> set = new HashSet<>();
    List<School> list = SchoolFactory.createSchools();

//    for(School school:list){
//      set.add(school);
//    }
    set.addAll(list);

    System.out.println(set);
  }

  private static void pracRemove() {
    List<School> list = SchoolFactory.createSchools();
    Set<School> set = new HashSet<>(list);
    System.out.println(set);

    // set.remove(list.get(2));
    set.remove(new School("민사고", "대전광역시", 3));

    System.out.println(set);
  }

  private static void pracSetOperation(Set<String> firstSet, Set<String> secondSet) {
    // NOTE C01 합집합
    Set<String> setAll = new HashSet<>();
    setAll.addAll(firstSet);
    setAll.addAll(secondSet);
    System.out.println("=== 합집합 ===");
    System.out.println(setAll);

    // NOTE C02 차집합
    System.out.println("=== 차집합 ===");
    setAll.removeAll(secondSet);
    System.out.println(setAll);

    // NOTE C03 교집합
    System.out.println("=== 교집합 ===");
    firstSet.retainAll(secondSet);
    System.out.println(firstSet);

    // NOTE C04 부분집합 여부
    System.out.println("=== 부분집합 여부 ===");
    System.out.println(secondSet.containsAll(firstSet));
  }
}
