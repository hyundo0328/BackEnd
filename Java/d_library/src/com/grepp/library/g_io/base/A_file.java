package com.grepp.library.g_io.base;

import java.io.File;
import java.io.IOException;

public class A_file {

  public static void main(String[] args) {

    try{
      File file = new File("/Users/hyundo/Desktop/MyFile/Code/BackEnd/Java/d_library/text.txt");
      file.createNewFile();

      // NOTE GA01 경로
      String path = "/Users/hyundo/Desktop/MyFile/Code/BackEnd/Java/d_library/study/";
      File dirs = new File(path);
      System.out.println(dirs.mkdirs());

      File pathfile = new File(path + "c/");
      if(!pathfile.exists()){
        pathfile.mkdirs();
      }

      File dirs2 = new File("./상대경로.txt");
      dirs2.createNewFile();
    } catch (IOException e){
      System.out.println(e.getMessage());
    }
  }
}
