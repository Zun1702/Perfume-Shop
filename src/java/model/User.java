/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class User {
    private int id,loginType,role_id;
    private String firstname,lastname,username,password,email,phone_number;
    private Date created_at,updated_at;
    private int deleted;
    private Role role;
    private Address_Detail address_detail;
    private String avatar;

    public User(int role_id, String firstname, String lastname, String username, String password, String email, String phone_number, Date created_at, Date updated_at, int deleted, String avatar) {
        this.role_id = role_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone_number = phone_number;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted = deleted;
        this.avatar = avatar;
    }

    public User(int role_id, String firstname, String lastname, String username, String password, String email, String phone_number, Date created_at, Date updated_at, int deleted) {
        this.role_id = role_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone_number = phone_number;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted = deleted;
    }

    
    public User(int id, int loginType, int role_id, String firstname, String lastname, String username, String password, String email, String phone_number, Date created_at, Date updated_at, int deleted, String avatar) {
        this.id = id;
        this.loginType = loginType;
        this.role_id = role_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone_number = phone_number;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted = deleted;
        this.avatar = avatar;
    }
    
    public User(int role_id, String firstname, String lastname, String username, String password, String email, String phone_number, Date created_at, Date updated_at, int deleted, Role role, Address_Detail address_detail) {
        this.role_id = role_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone_number = phone_number;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted = deleted;
        this.role = role;
        this.address_detail = address_detail;
    }
    
    public User(String firstname, String lastname, String username, String password, String email, String phone_number, Address_Detail address, Date created_at, Date updated_at, int deleted) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone_number = phone_number;
        this.address_detail = address;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted = deleted;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Address_Detail getAddress_detail() {
        return address_detail;
    }

    public void setAddress_detail(Address_Detail address_detail) {
        this.address_detail = address_detail;
    }

    public User(int id, int loginType, int role_id, String firstname, String lastname, String username, String password, String email, String phone_number, Date created_at, Date updated_at, int deleted, Role role, Address_Detail address_detail) {
        this.id = id;
        this.loginType = loginType;
        this.role_id = role_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone_number = phone_number;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted = deleted;
        this.role = role;
        this.address_detail = address_detail;
    }

    public User(int id, int loginType, int role_id, String firstname, String lastname, String username, String password, String email, String phone_number, Date created_at, Date updated_at, int deleted) {
        this.id = id;
        this.loginType = loginType;
        this.role_id = role_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone_number = phone_number;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted = deleted;
    }
    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    

    
  
}
