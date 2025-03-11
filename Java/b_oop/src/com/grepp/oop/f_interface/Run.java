package com.grepp.oop.f_interface;

public class Run {

  public static void main(String[] args) {
    StarLink smartPhone = new SmartPhone("애플", "아이폰", 2000000,"M2", "KT");

    smartPhone.connect();
    smartPhone.disconnect();
    StarLink.callAgency();

    Https phone = (Https) smartPhone;
    phone.send();
    phone.receive();
    phone.encrypt();
  }
}
