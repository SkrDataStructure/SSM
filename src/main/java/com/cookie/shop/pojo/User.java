package com.cookie.shop.pojo;


import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    final long serialVersionUID = 1L;
    private Integer id;

    private String username;

    private String email;
    private String password;

    private String name;

    private String phone;

    private String address;

    private Boolean isadmin;

    private Boolean isvalidate;

    private List<Cart> shopCartList;

    public long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<Cart> getShopCartList() {
        return shopCartList;
    }

    public void setShopCartList(List<Cart> shopCartList) {
        this.shopCartList = shopCartList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Boolean getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Boolean isadmin) {
        this.isadmin = isadmin;
    }

    public Boolean getIsvalidate() {
        return isvalidate;
    }

    public void setIsvalidate(Boolean isvalidate) {
        this.isvalidate = isvalidate;
    }

    @Override
    public String toString() {
        return "User{" +
                "serialVersionUID=" + serialVersionUID +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", isadmin=" + isadmin +
                ", isvalidate=" + isvalidate +
                ", shopCartList=" + shopCartList +
                '}';
    }
}