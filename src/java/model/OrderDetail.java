/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author canduykhanh
 */
public class OrderDetail {

    private int id;
    private int order_id;
    private int size_id;
    private int product_id;
    private int price;
    private int num;
    private int total_money_in;
    private int total_money_out;
    private Order order;
    private User user;
    private Product product;
    private SizeProduct sizeproduct;
    private Size size;
    private Address_Detail address_detail;

    public OrderDetail(int id, int order_id, int size_id, int product_id, int price, int num, int total_money_in, int total_money_out, Order order, User user, Product product, SizeProduct sizeproduct, Size size, Address_Detail address_detail) {
        this.id = id;
        this.order_id = order_id;
        this.size_id = size_id;
        this.product_id = product_id;
        this.price = price;
        this.num = num;
        this.total_money_in = total_money_in;
        this.total_money_out = total_money_out;
        this.order = order;
        this.user = user;
        this.product = product;
        this.sizeproduct = sizeproduct;
        this.size = size;
        this.address_detail = address_detail;
    }

    public OrderDetail() {
    }

    public OrderDetail(int id, int order_id, int size_id, int product_id, int price, int num, int total_money_in, int total_money_out, Product product, Size size) {
        this.id = id;
        this.order_id = order_id;
        this.size_id = size_id;
        this.product_id = product_id;
        this.price = price;
        this.num = num;
        this.total_money_in = total_money_in;
        this.total_money_out = total_money_out;
        this.product = product;
        this.size = size;
    }

    public OrderDetail(int id, int order_id, int product_id, int price, int num, int total_money_in, int total_money_out) {
        this.id = id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.price = price;
        this.num = num;
        this.total_money_in = total_money_in;
        this.total_money_out = total_money_out;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SizeProduct getSizeproduct() {
        return sizeproduct;
    }

    public void setSizeproduct(SizeProduct sizeproduct) {
        this.sizeproduct = sizeproduct;
    }

    public Address_Detail getAddress_detail() {
        return address_detail;
    }

    public void setAddress_detail(Address_Detail address_detail) {
        this.address_detail = address_detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getSize_id() {
        return size_id;
    }

    public void setSize_id(int size_id) {
        this.size_id = size_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getTotal_money_in() {
        return total_money_in;
    }

    public void setTotal_money_in(int total_money_in) {
        this.total_money_in = total_money_in;
    }

    public int getTotal_money_out() {
        return total_money_out;
    }

    public void setTotal_money_out(int total_money_out) {
        this.total_money_out = total_money_out;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
     public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

}
