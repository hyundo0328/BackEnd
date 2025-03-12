package com.grepp.library.c_collection.a_generic;

import com.grepp.library.c_collection.a_generic.domain.Book;
import com.grepp.library.c_collection.a_generic.domain.Computer;
import com.grepp.library.c_collection.a_generic.domain.Device;
import com.grepp.library.c_collection.a_generic.domain.SmartPhone;
import com.grepp.library.c_collection.a_generic.domain.TV;

public class Run {

  public static void main(String[] args) {

    Computer mac = new Computer("mac","apple");
    Computer galaxyBook = new Computer("galaxyBook", "intel-i9");
    SmartPhone iphone = new SmartPhone("iphone", "M3", "KT");
    SmartPhone galaxy = new SmartPhone("galaxy", "스냅드래곤", "KT");

    Book book = new Book("해리포터", "조앤롤링");
    TV tv = new TV("LG 스탠바이", 50);

    GenericArray<Device> genericArray = new GenericArray<>(2);
    genericArray.add(tv);
    genericArray.add(galaxyBook);

    GenericArray<Book> books = new GenericArray<>(2);
    books.add(book);

    GenericArray<Device> g1 = GenericArray.<Device>practiceGeneric(mac);

    // T extends Device: Device 타입을 가지고 있지 않은 Book은 올 수 없다.
    // GenericArray<Book> g2 = GenericArray.<Book>practiceExtends(book);
    GenericArray<Device> g2 = GenericArray.<Device>practiceExtends(mac);

    // NOTE 04 generic은 무공변성 (= Casting이 안 됨)
    // GenericArray<Device> g3 = GenericArray.<Computer>practiceExtends(mac);

    // NOTE 05 와일드카드: ?
    // NOTE 06-1 상한 경계: <? extends T>
    GenericArray<? extends Device> g4 = GenericArray.<Computer>practiceExtends(mac);

    // NOTE 06-2 하한 경계 <? super T>
    GenericArray<? super Computer> g5 = GenericArray.<Object>practiceGeneric(mac);
  }
}
