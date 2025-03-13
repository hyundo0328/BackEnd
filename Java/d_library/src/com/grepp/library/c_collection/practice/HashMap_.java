package com.grepp.library.c_collection.practice;

public class HashMap_<K, V> {
  private final EntrySet_<Entry_<K, V>> entrySet = new EntrySet_<>();

  public V put(K key, V value){
    Entry_<K, V> entry = new Entry_<>(key, value);

    if(entrySet.add(entry)){
      return value;
    }

    return null;
  }

  public V get(K key){
    Entry_<K, V> entry = entrySet.get(new Entry_<>(key, null));

    if(entry == null) return null;

    return entry.getValue();
  }

  public V remove(K key){
    Entry_<K, V> entry = entrySet.get(new Entry_<>(key, null));
    System.out.println(entry);

    if(entry == null) return null;

    V value = entry.getValue();

    entrySet.remove(entry);

    return value;
  }

  public HashSet_<Entry_<K, V>> entrySet(){
    return entrySet;
  }

  public boolean containsKey(K key){
    return get(key) != null;
  }
}
