/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Item {
    private SizeProduct sizeproduct;
    private Product product;
    private Size size;
    private int quantity;
    private double price;

    public Item() {
    }

    public Item(SizeProduct sizeproduct, Product product, Size size, int quantity, double price) {
        this.sizeproduct = sizeproduct;
        this.product = product;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }

    public SizeProduct getSizeproduct() {
        return sizeproduct;
    }

    public void setSizeproduct(SizeProduct sizeproduct) {
        this.sizeproduct = sizeproduct;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
