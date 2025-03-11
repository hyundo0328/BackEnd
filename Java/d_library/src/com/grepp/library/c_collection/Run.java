package com.grepp.library.c_collection;

import com.grepp.library.c_collection.domain.Book;
import com.grepp.library.c_collection.domain.Computer;
import com.grepp.library.c_collection.domain.Device;
import com.grepp.library.c_collection.domain.TV;

public class Run {

  public static void main(String[] args) {
    Book book = new Book("해리포터", "조앤롤링");
    Device computer = new Computer("갤럭시북", "intel-i7");
    Device tv = new TV("LG 스탠바이", 50);

    GenericArray<Device> genericArray = new GenericArray<>(2);
    genericArray.add(tv);
    genericArray.add(computer);

    GenericArray<Book> books = new GenericArray<>(2);
    books.add(book);

    for(int i=0; i< genericArray.getSize(); i++){
      System.out.println(genericArray.get(i));
    }
  }
}
