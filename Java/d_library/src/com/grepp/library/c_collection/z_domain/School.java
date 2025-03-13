package com.grepp.library.c_collection.z_domain;

import java.util.Objects;

public class School implements Comparable<School> {
  private String name;
  private String address;
  private Integer level;

  public School(String name, String address, Integer level) {
    this.name = name;
    this.address = address;
    this.level = level;
  }

  @Override
  public String toString() {
    return "School{" +
        "name='" + name + '\'' +
        ", address='" + address + '\'' +
        ", level=" + level +
        '}';
  }

  // compareTo 메소드의 Override를 강제 (interface에 메소드가 정의되어있기 때문)
  // 우리가 정한 정렬기준은 Comparable 인터페이스의 compareTo 메소드를 통해 전달
  @Override
  public int compareTo(School o) {
    // System.out.println("compare to");
    // return this.level - o.level; // level 기준 오름차순
    // return o.level - this.level; // level 기준 내림차순
    // return this.name.compareTo(o.name); // name 기준 오름차순
    // return this.level ==  o.level ? o.name.compareTo(this.name) : this.level - o.level;

    if(this.level != o.level){
      return this.level - o.level;
    }

    return o.name.compareTo(this.name);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof School school)) {
      return false;
    }
    return Objects.equals(name, school.name) && Objects.equals(address,
        school.address) && Objects.equals(level, school.level);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, address, level);
  }
}
