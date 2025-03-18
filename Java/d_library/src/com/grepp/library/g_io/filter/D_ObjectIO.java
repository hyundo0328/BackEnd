package com.grepp.library.g_io.filter;

import com.grepp.library.g_io.dto.Music;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

// Object를 직렬화할 때 사용 (하지만, 현재는 거의 사용하지 않음)
public class D_ObjectIO {

  public static void main(String[] args) {
    writeObject();
    readObject();
  }

  // NOTE GD2: 객체직렬화
  // 직렬화: 통신이 가능한 형태로 변경
  public static void writeObject(){
    Music music1 = new Music("BTS", "다이너마이트");
    Music music2 = new Music("아이유", "신호등");
    Music music3 = new Music("아이유", "금요일에 만나요");

    try(ObjectOutput oos = new ObjectOutputStream(new FileOutputStream("music.dat"))){
      oos.writeObject(music1);
      oos.writeObject(music2);
      oos.writeObject(music3);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void readObject(){
    try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("music.dat"))){
      // 나중에 thread에서 사용하는 방법
      while(true){
        Object res = ois.readObject();
        System.out.println(res);
      }

//      Object res = ois.readObject();
//      System.out.println(res);
    } catch (IOException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
