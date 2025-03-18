package com.grepp.library.g_io.filter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

// "/Users/hyundo/Desktop/MyFile/Code/BackEnd/Java/d_library/text.txt";
public class A_bufferedIO {

  public static void main(String[] args) {
    copyFile();
  }

  private static void writeFile(){
    Scanner sc = new Scanner(System.in);
    System.out.print("파일명: ");
    String filename = sc.nextLine();
    System.out.print("내용: ");
    String content = sc.nextLine();

    try(BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filename, true))){
      fos.write(content.getBytes(StandardCharsets.UTF_8));
    } catch (IOException e){
      e.printStackTrace();
    }
  }

  private static void copyFile(){
    String sourcePath = "/Users/hyundo/Desktop/MyFile/Code/BackEnd/Java/d_library/text.txt";
    String outputPath = "./copy.zip";

    try(
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourcePath));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputPath));
    ){

      long start = System.currentTimeMillis();

      int data = 0;
      while((data = bis.read()) != -1) {
        bos.write(data);
      }

      long end = System.currentTimeMillis();
      System.out.println("no buffer : " + (end - start));

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
