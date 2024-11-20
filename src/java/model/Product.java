/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;


public class Product {
    private int id;
    private int category_id;
    private String title;
    private int gender_id;
    private int discount_id;
    private String thumbnail;
    private String description;
    private Date created_at;
    private Date updated_at;
    private Gender gender;
    private Discount discount;
    private Gallery gallery;
    private Category category;
    private SizeProduct sizeproduct;
    private Size size;
    private OrderDetail orderdetail;
    

    public Product() {
    }

    public Product(int id, int category_id, String title, int gender_id, int discount_id, String thumbnail, String description, Date created_at, Date updated_at, Gender gender, Discount discount, Gallery gallery, Category category, SizeProduct sizeproduct, Size size, OrderDetail orderdetail) {
        this.id = id;
        this.category_id = category_id;
        this.title = title;
        this.gender_id = gender_id;
        this.discount_id = discount_id;
        this.thumbnail = thumbnail;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.gender = gender;
        this.discount = discount;
        this.gallery = gallery;
        this.category = category;
        this.sizeproduct = sizeproduct;
        this.size = size;
        this.orderdetail = orderdetail;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }



    public OrderDetail getOrderdetail() {
        return orderdetail;
    }

    public void setOrderdetail(OrderDetail orderdetail) {
        this.orderdetail = orderdetail;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gallery getGallery() {
        return gallery;
    }

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SizeProduct getSizeproduct() {
        return sizeproduct;
    }

    public void setSizeproduct(SizeProduct sizeproduct) {
        this.sizeproduct = sizeproduct;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getGender_id() {
        return gender_id;
    }

    public void setGender_id(int gender_id) {
        this.gender_id = gender_id;
    }

    public int getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(int discount_id) {
        this.discount_id = discount_id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    
    
}
