package com.bookshop.entity;

public class BookList {
    private Integer id;
    private String name;
    private String link;
    private String publicer;
    private String grade;
    private String num;
    private String content;

    public BookList() {
    }

    public BookList(Integer id, String name, String link, String publicer, String grade, String num, String content) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.publicer = publicer;
        this.grade = grade;
        this.num = num;
        this.content = content;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPublicer() {
        return publicer;
    }

    public void setPublicer(String publicer) {
        this.publicer = publicer;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BookList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", publicer='" + publicer + '\'' +
                ", grade='" + grade + '\'' +
                ", num='" + num + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
