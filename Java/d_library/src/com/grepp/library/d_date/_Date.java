package com.grepp.library.d_date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Calendar;
import java.util.Date;

public class _Date {

  public static void main(String[] args) {
//    studyDate();
    studyLocalDateTime();
    studyOffsetDateTime();
  }

  // NOTE DA1: 자바 1버전 때 제공되던 날짜 제공 클래스
  private static void studyDate(){
//    Date now = new Date();
    Calendar now = Calendar.getInstance();

//    System.out.println(now.getYear());
//    System.out.println(now.getMonth());
//    System.out.println(now.getDay());
//    System.out.println(now.getHours());
//    System.out.println(now.getMinutes());
//    System.out.println(now.getSeconds());
    System.out.println(now.get(1));
  }

  private static void studyLocalDateTime(){
    LocalDateTime now = LocalDateTime.now();

    System.out.println(now);

    System.out.println(now.getYear());
    System.out.println(now.getMonth());
    System.out.println(now.getDayOfMonth());
    System.out.println(now.getDayOfWeek());
    System.out.println(now.getHour());
    System.out.println(now.getMinute());
    System.out.println(now.getSecond());

    now = now.plusYears(1);
    System.out.println(now);

    LocalDate programmers = LocalDate.of(2025,8,15);
    System.out.println(programmers);
  }

  private static void studyOffsetDateTime() {
    OffsetDateTime now = OffsetDateTime.now();

    System.out.println(now);
  }
}
