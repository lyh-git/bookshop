package com.bookshop.entity;

public class User {
    private Integer id;
    private String loginName;
    private String password;
    private String name;
    private String sex;
    private String email;
    private String tel;
    private Integer level;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public User() {
        super();
    }

    public User(String loginName, String password) {
        super();
        this.loginName = loginName;
        this.password = password;
    }

    public User(int id,String loginName, String password, String name, String sex, String email, String tel,String address,int level) {
        super();
        this.id=id;
        this.loginName = loginName;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.tel = tel;
        this.address=address;
        this.level=level;
    }
    public User(String loginName, String password, String name, String sex, String email, String tel,String address) {
        super();

        this.loginName = loginName;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.tel = tel;
        this.address=address;

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", level=" + level +
                ", address='" + address + '\'' +
                '}';
    }
}
