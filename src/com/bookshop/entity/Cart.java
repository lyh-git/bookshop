package com.bookshop.entity;

public class Cart {

    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Integer bookNum;
    private Double bookPrice;
    private String bookName;

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

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Cart(Integer id, Integer bookNum) {
        this.id = id;
        this.bookNum = bookNum;
    }

    public Cart(Integer id, Integer userId, Integer bookId, Integer bookNum, Double bookPrice, String bookName) {
        super();
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.bookNum = bookNum;
        this.bookPrice = bookPrice;
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Cart [id=" + id + ", userId=" + userId + ", bookId=" + bookId + ", bookNum=" + bookNum + ", bookPrice="
                + bookPrice + ", bookName=" + bookName + "]";
    }

    public Cart() {
        super();
    }

    public Cart(Integer userId, Integer bookId, Integer bookNum, Double bookPrice, String bookName) {
        super();
        this.userId = userId;
        this.bookId = bookId;
        this.bookNum = bookNum;
        this.bookPrice = bookPrice;
        this.bookName = bookName;
    }

}
