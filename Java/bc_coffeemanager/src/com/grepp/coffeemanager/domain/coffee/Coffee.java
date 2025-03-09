package com.grepp.coffeemanager.domain.coffee;

import com.grepp.coffeemanager.domain.purchase.Purchase;

public class Coffee {
  private String name;
  private int price;
  private int purchasePrice;
  private int stock;
  private int safetyStock;
  private int salesCnt;

  public Coffee(String name, int price, int purchasePrice, int stock, int safetyStock) {
    this.name = name;
    this.price = price;
    this.purchasePrice = purchasePrice;
    this.stock = stock;
    this.safetyStock = safetyStock;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  public int getStock() {
    return stock;
  }

  public int getSalesCnt() {
    return salesCnt;
  }

  public void provide(int orderCnt) {
    this.salesCnt += orderCnt; // 판매 추가
    this.stock -= orderCnt; // 재고 차감
    checkSafetyStocks();
  }

  private void checkSafetyStocks() {
    if(this.stock < this.safetyStock){
      int purchaseCnt = safetyStock * 2;

      Purchase purchase = new Purchase(this, purchaseCnt);
      purchase.proceed();
    }
  }

  public void addStock(int purchaseCnt) {
    this.stock += purchaseCnt;
  }
}

