package com.grepp.coffeemanager.domain.order;

public class OrderStatus {

  private int code;
  private String message;

  public static final OrderStatus OK = new OrderStatus(0, "주문 완료");
  public static final OrderStatus FAIL_SOLDOUT = new OrderStatus(1, "재고 부족으로 주문 실패");
  public static final OrderStatus FAIL_SEASON = new OrderStatus(2, "현재는 판매하지 않는 시즌 상품입니다.");

  public OrderStatus(int code, String message){
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
