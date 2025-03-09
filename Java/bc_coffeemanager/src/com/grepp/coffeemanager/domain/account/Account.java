package com.grepp.coffeemanager.domain.account;

public class Account {
  private int balance;
  private int sales;
  private int expenses;
  private static Account instance;

  public static Account getInstance(int balance) {
    if(instance == null){
      instance = new Account(balance);
    }

    return instance;
  }

  public static Account getInstance() {
    if(instance == null){
      instance = new Account(0);
    }

    return instance;
  }

  public Account(int balance) {
    this.balance = balance;
  }

  public int getBalance() {
    return balance;
  }

  public int getSales() {
    return sales;
  }

  public int getExpenses() {
    return expenses;
  }

  public boolean registExpenses(int expenses){ // 안전재고 부족 시 지출 비용
    if(this.balance < expenses) {
      return false;
    } else {
      this.balance -= expenses;
      this.expenses += expenses;

      return true;
    }
  }

  public void registSales(int paymentPrice){ // 커피 판매 비용
    this.balance += paymentPrice;
    this.sales += paymentPrice;
  }
}
