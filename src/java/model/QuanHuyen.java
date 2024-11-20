/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author asus
 */
public class QuanHuyen {
    private int id;
    private String name;
    private TinhThanhPho tinh;

    public QuanHuyen() {
    }

    public QuanHuyen(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public QuanHuyen(int id, String name, TinhThanhPho tinh) {
        this.id = id;
        this.name = name;
        this.tinh = tinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TinhThanhPho getTinh() {
        return tinh;
    }

    public void setTinh(TinhThanhPho tinh) {
        this.tinh = tinh;
    }
    
}
