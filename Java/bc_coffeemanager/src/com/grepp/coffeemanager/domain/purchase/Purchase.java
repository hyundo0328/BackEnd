package com.grepp.coffeemanager.domain.purchase;

import com.grepp.coffeemanager.domain.account.Account;
import com.grepp.coffeemanager.domain.coffee.Coffee;

public class Purchase {
  private Coffee coffee;
  private int purchaseCnt;

  public Purchase(Coffee coffee, int purchaseCnt) {
    this.coffee = coffee;
    this.purchaseCnt = purchaseCnt;
  }

  public void proceed() {
    Account account = Account.getInstance();
    int purchasePrice = this.coffee.getPrice() * this.purchaseCnt;

    if(account.registExpenses(purchasePrice)){ // 매입 가격이 있을 시 매입
      System.out.println("System: " + coffee.getName() + "[" + purchaseCnt + "잔] 매입");
      coffee.addStock(this.purchaseCnt);
    } else {
      System.out.println("System: 매입에 실패하였습니다.");
    }
  }
}
