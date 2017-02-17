package com.pony.domain;

import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/15
 */
@Accessors(chain = true)
public class User {
    private int id;
    private String phone;
    private String email;
    private String password;
    private int checker;
    private int credit;
    private String address;
    private Date register_time;
    private Date last_time;
    private String token;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getChecker() {
        return checker;
    }

    public void setChecker(int checker) {
        this.checker = checker;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegisterTime() {
        return register_time;
    }

    public void setRegisterTime(Date registerTime) {
        this.register_time = registerTime;
    }

    public Date getLastTime() {
        return last_time;
    }

    public void setLastTime(Date lastTime) {
        this.last_time = lastTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", checker=" + checker +
                ", credit=" + credit +
                ", address='" + address + '\'' +
                ", register_time=" + register_time +
                ", last_time=" + last_time +
                ", token='" + token + '\'' +
                '}';
    }
}
