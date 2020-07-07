package com.bookshop.entity;

import java.util.List;

public class Order {
    private Integer id;
    private Integer orderItemId;
    private Integer userId;
    private List<OrderItem> orderItems;
    private Double priceSum;
    private Integer status;

    public Order(Integer id, Integer userId, Double priceSum, Integer status) {
        this.id = id;
        this.userId = userId;
        this.priceSum = priceSum;
        this.status = status;
    }

    public Order(Integer userId, Double priceSum, Integer status) {
        this.userId = userId;
        this.priceSum = priceSum;
        this.status = status;
    }

    public Order(Integer id, Integer orderItemId, Integer userId, Integer status) {
        this.id = id;
        this.orderItemId = orderItemId;
        this.userId = userId;
        this.status = status;
    }

    public Order() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", orderItemId=" + orderItemId + ", userId=" + userId + ", orderItems=" + orderItems
                + ", priceSum=" + priceSum + ", status=" + status + "]";
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Double getPriceSum() {
        return priceSum;
    }

    public void setPriceSum(Double priceSum) {
        this.priceSum = priceSum;
    }

}
