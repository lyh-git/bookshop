package com.bookshop.entity;

public class Book {
    private Integer id;
    private String name;
    private String author;
    private String publisher;
    private Double price;
    private String type;
    private String disc;
    private Double discount;
    private Integer store;
    private Integer flag;
    private String createTime;

    public Book(Integer id, String name, String author, String publisher, Double price, String type, String disc, Double discount, Integer store, Integer flag, String createTime) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.type = type;
        this.disc = disc;
        this.discount = discount;
        this.store = store;
        this.flag = flag;
        this.createTime = createTime;
    }
    public Book( String name, String author, String publisher, Double price, String type, String disc, Double discount, Integer store, Integer flag, String createTime) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.type = type;
        this.disc = disc;
        this.discount = discount;
        this.store = store;
        this.flag = flag;
        this.createTime = createTime;
    }

    public Book() {

    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", author=" + author + ", publisher=" + publisher + ", price="
                + price + ", type=" + type + ", disc=" + disc + ", discount=" + discount + ", store=" + store
                + ", flag=" + flag + "]";
    }

}
