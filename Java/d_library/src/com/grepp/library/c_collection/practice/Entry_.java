package com.grepp.library.c_collection.practice;

import java.util.Objects;

public class Entry_<K, V> {
  private K key;
  private V value;

  public Entry_(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey(){
    return key;
  }

  public V getValue(){
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Entry_<?, ?> entry)) {
      return false;
    }
    return Objects.equals(key, entry.key);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(key);
  }

  @Override
  public String toString() {
    return "Entry_{" +
        "key=" + key +
        ", value=" + value +
        '}';
  }
}
