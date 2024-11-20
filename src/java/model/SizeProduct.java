/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class SizeProduct {
    int pid;
    int sid;
    int quantity;
    int price_in;
    int price_out;
   
    public SizeProduct(int pid, int sid, int quantity, int price_in, int price_out) {
        this.pid = pid;
        this.sid = sid;
        this.quantity = quantity;
        this.price_in = price_in;
        this.price_out = price_out;
        
    }


    public SizeProduct() {
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice_in() {
        return price_in;
    }

    public void setPrice_in(int price_in) {
        this.price_in = price_in;
    }

    public int getPrice_out() {
        return price_out;
    }

    public void setPrice_out(int price_out) {
        this.price_out = price_out;
    }
    
    
}
