package com.grepp.coffeemanager.domain.sale;

import com.grepp.coffeemanager.domain.order.Order;
import com.grepp.coffeemanager.domain.payment.Payment;

public class Sale {
  public void takeOrder(Order order){
    Payment payment = new Payment(order);

    payment.proceed();
    order.proceed();
  }
}