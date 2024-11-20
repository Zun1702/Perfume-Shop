/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author asus
 */
public class XaPhuong {
    private int id;
    private String name;
    private QuanHuyen huyen;

    public XaPhuong() {
    }

    public XaPhuong(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public XaPhuong(int id, String name, QuanHuyen huyen) {
        this.id = id;
        this.name = name;
        this.huyen = huyen;
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

    public QuanHuyen getHuyen() {
        return huyen;
    }

    public void setHuyen(QuanHuyen huyen) {
        this.huyen = huyen;
    }
    
}
