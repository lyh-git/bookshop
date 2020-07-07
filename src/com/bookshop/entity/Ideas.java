package com.bookshop.entity;

public class Ideas {
    private Integer id;
    private String title;
    private String content;
    private String sendTime;
    private String sender;

    public Ideas(String title, String content, String sendTime, String sender) {
        this.title = title;
        this.content = content;
        this.sendTime = sendTime;
        this.sender = sender;
    }

    public Ideas() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "News [id=" + id + ", title=" + title + ", content=" + content + ", sendTime=" + sendTime + ", sender="
                + sender + "]";
    }

}
