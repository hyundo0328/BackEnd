package com.grepp.oop.g_inner.builder;

public class Run {

  public static void main(String[] args) {
    // 1. 점층적 생성자 패턴
//    Book book = new Book("차차차","차은우", 500, false);

    // 2. 자바 Bean 패턴
//    Book book2 = new Book();
//    book2.setTitle("해리포터");
//    book2.setAuthor("조앤롤링");
//    book2.setPrice(500);
//    book2.setActivated(true);

    // NOTE G6 메소드 체인 방식
    // 3. Builder 패턴
    Book book = new Book.Builder()
        .title("해리포터")
        .author("조앤롤링")
        .price(500)
        .activated(false)
        .build();

    System.out.println(book);
  }
}
