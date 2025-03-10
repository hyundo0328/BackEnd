package com.grepp.coffeemanager.domain.order;

// NOTE ENUM: 연관된 상수들의 집합
public enum OrderStatus {

  OK(0, "주문 완료"),
  FAIL_SOLDOUT(1, "재고 부족으로 주문 실패"),
  FAIL_SEASON(2, "현재는 판매하지 않는 시즌 상품입니다.");

  private int code;
  private String message;

  private OrderStatus(int code, String message){
    this.code = code;
    this.message = message;
  }

  public boolean isOK(){
    return code == 0;
  }
  public String getMessage(){
    return message;
  }
}
