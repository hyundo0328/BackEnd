package com.grepp.coffeemanager.domain.order;

import com.grepp.coffeemanager.domain.coffee.Coffee;
import com.grepp.coffeemanager.domain.coffee.SeasonCoffee;
import java.time.LocalDateTime;

public class Order {
  private String name;
  private Coffee coffee;
  private int orderCnt;
  private int orderPrice;
  private LocalDateTime orderTime = LocalDateTime.now();
  private OrderStatus status;

  public static Order createOrder(Coffee drink, int orderCnt) {
    Order order = new Order(drink, orderCnt);

    if(drink.getStock() < orderCnt){
      order.status = OrderStatus.FAIL_SOLDOUT;
    } else if (drink instanceof SeasonCoffee seasonCoffee) {
      if(seasonCoffee.notSeason()){
        order.status = OrderStatus.FAIL_SEASON;
      }
    } else {
      order.status = OrderStatus.OK;
    }

    return order;
  }

  private Order(Coffee coffee, int orderCnt) {
    this.coffee = coffee;
    this.name = coffee.getName() + "[" + orderCnt + "]";
    this.orderCnt = orderCnt;
    this.orderPrice = coffee.getPrice() * orderCnt;
  }

  public String getName() {
    return name;
  }

  public int getOrderPrice() {
    return orderPrice;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void proceed() {
    coffee.provide(this.orderCnt);
  }
}
