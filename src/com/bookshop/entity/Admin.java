package com.bookshop.entity;

/**
 * @author HUA
 */ //管理员类
public class Admin {
    // id主键
    private Integer id;
    private String name;
    private String password;
    private String createTime;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Admin [id=" + id + ", name=" + name + ", password=" + password + ", createTime=" + createTime + "]";
    }

    public Admin(String name, String password, String createTime) {
        super();
        this.name = name;
        this.password = password;
        this.createTime = createTime;
    }

    public Admin(Integer id, String name, String password, String createTime) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
        this.createTime = createTime;
    }

    public Admin(String name, String password) {
        super();
        this.name = name;
        this.password = password;
    }

    public Admin() {
        super();
    }

}
