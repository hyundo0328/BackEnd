package com.grepp.library.g_io.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class _Properties {

  // NOTE XML (extensible markup language)
  public static void main(String[] args) {
//    studyProperties();
    loadXML();
  }

  private static void studyProperties() {
    Properties props = new Properties();

    // C, U
    props.setProperty("DATE", "2025-03-18");
    props.setProperty("PORT", "8080");
    props.setProperty("HOST", "localhost");

    // R
    for(Object key:props.keySet()){
      System.out.println(props.getProperty(key.toString()));
    }

    // D
    props.remove("DATE");
    System.out.println(props);

    // xml 파일로 만들기
    try(FileOutputStream fos = new FileOutputStream("web.xml")){
      props.storeToXML(fos, "Web Server Properties");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static void loadXML(){
    Properties prop = new Properties();

    try(FileInputStream fis = new FileInputStream("web.xml")){
      prop.loadFromXML(fis);

      System.out.println("=== loadFromXML");
      System.out.println(prop);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
