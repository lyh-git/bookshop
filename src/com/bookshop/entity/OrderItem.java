package com.bookshop.entity;

public class OrderItem {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Integer orderId;
    private Double priceSum;

    public OrderItem(Integer userId, Integer bookId, Integer orderId, Double priceSum) {
        this.userId = userId;
        this.bookId = bookId;
        this.orderId = orderId;
        this.priceSum = priceSum;
    }

    public OrderItem() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Double getPriceSum() {
        return priceSum;
    }

    public void setPriceSum(Double priceSum) {
        this.priceSum = priceSum;
    }

    @Override
    public String toString() {
        return "OrderItem [id=" + id + ", userId=" + userId + ", bookId=" + bookId + ", orderId=" + orderId
                + ", priceSum=" + priceSum + "]";
    }

}
