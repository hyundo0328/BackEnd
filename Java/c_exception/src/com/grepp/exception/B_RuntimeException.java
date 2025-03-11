package com.grepp.exception;

import java.util.Random;
import java.util.Scanner;

public class B_RuntimeException {

  static void multiEx(){
    try{
      // ClassCastException
      Object obj = new Object();
      // String str = (String) obj;

      // ArrayIndexOutOfBoundsException
      int[] arr = new int[2];
      // arr[2] = 10;

      // NullPointerException
      String nullStr = null;
      nullStr.equals("a"); // null이 담겨있는 참조 변수로 속성이나 메소드를 사용하려 할 경우 발생하는 예외

    } catch(ClassCastException e) {
      System.out.println(e.getMessage());
    } catch(ArrayIndexOutOfBoundsException e) {
      System.out.println(e.getMessage());
    } catch (NullPointerException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
//    catch (ClassCastException | ArrayIndexOutOfBoundsException | NullPointerException e){
//      System.out.println(e.getMessage()); // Java 1.7부터 지원
//    }
  }
}
