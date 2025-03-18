package com.grepp.library.g_io.base;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class B_FileIO {
  // NOTE GB01
  public static void main(String[] args) {
    writeFile();
    readFile();
    copyFile();
  }

  private static void readFile() {
    Scanner sc = new Scanner(System.in);
    System.out.println("읽어올 파일명을 작성: ");
    String fileName = sc.nextLine();

    try(FileInputStream fis = new FileInputStream(fileName)){
      byte[] bytes = fis.readAllBytes();
      System.out.println(new String(bytes, StandardCharsets.UTF_8));
    } catch (IOException e){
      throw new RuntimeException(e);
    }
  }

  private static void writeFile() {
    Scanner sc = new Scanner(System.in);
    System.out.print("파일명: ");
    String filename = sc.nextLine();
    System.out.print("내용: ");
    String content = sc.nextLine();

    // 레거시 코드
    try(FileOutputStream fos = new FileOutputStream(filename, true)){
      fos.write(content.getBytes(StandardCharsets.UTF_8));
    } catch (IOException e){
      e.printStackTrace();
    }

//    FileOutputStream fos = null;
//    try{
//      fos = new FileOutputStream(filename);
//      fos.write(content.getBytes(StandardCharsets.UTF_8));
//    } catch (IOException e){
//      e.printStackTrace();
//    } finally {
//      try {
//        fos.close();
//      } catch (IOException e) {
//        e.printStackTrace();
//      }
//    }
  }

  private static void copyFile(){
    String sourcePath = "/Users/hyundo/Desktop/MyFile/Code/BackEnd/Java/d_library/text.txt";
    String outputPath = "./copy.zip";

    try(
        FileInputStream fis = new FileInputStream(sourcePath);
        FileOutputStream fos = new FileOutputStream(outputPath);
        ){
      long start = System.currentTimeMillis();

      int data = 0;
      while((data = fis.read()) != -1){ // 레거시 코드
        fos.write(data);
      }

      long end = System.currentTimeMillis();
      System.out.println("no buffer: "+ (end-start));

    } catch (IOException e){
      e.printStackTrace();
    }
  }
}
