/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author canduykhanh
 */
public class Order {

    /*
    [id] int PRIMARY KEY IDENTITY(1, 1),
  [user_id] int,
  [firstname] nvarchar(30),
  [lastname] nvarchar(30),
  [email] nvarchar(150),
  [phone_number] nvarchar(20),
  [address] nvarchar(200),
  [note] nvarchar(1000),
  [order_date] datetime,
  [status_id] int,
  [total_money] int
     */
    private int id;
    private int user_id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone_number;
    private int address_id;
    private String note;
    private Date order_date;
    private int status_id;
    private int total_money;
    private Status status;
    private Address_Detail address;

    public Order() {
    }

    public Order(int id, int user_id, String firstname, String lastname, String email, String phone_number, int address_id, String note, Date order_date, int status_id, int total_money, Status status) {
        this.id = id;
        this.user_id = user_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone_number = phone_number;
        this.address_id = address_id;
        this.note = note;
        this.order_date = order_date;
        this.status_id = status_id;
        this.total_money = total_money;
        this.status = status;
    }

    public Order(int id, int user_id, String firstname, String lastname, String email, String phone_number, int address_id, String note, Date order_date, int status_id, int total_money, Status status, Address_Detail address) {
        this.id = id;
        this.user_id = user_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone_number = phone_number;
        this.address_id = address_id;
        this.note = note;
        this.order_date = order_date;
        this.status_id = status_id;
        this.total_money = total_money;
        this.status = status;
        this.address = address;
    }

    public Order(int id, int user_id, String firstname, String lastname, String email, String phone_number, int address_id, String note, Date order_date, int status_id, int total_money) {
        this.id = id;
        this.user_id = user_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone_number = phone_number;
        this.address_id = address_id;
        this.note = note;
        this.order_date = order_date;
        this.status_id = status_id;
        this.total_money = total_money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getTotal_money() {
        return total_money;
    }

    public void setTotal_money(int total_money) {
        this.total_money = total_money;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Address_Detail getAddress() {
        return address;
    }

    public void setAddress(Address_Detail address) {
        this.address = address;
    }
}
