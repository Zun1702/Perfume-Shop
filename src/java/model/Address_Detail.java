/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Address_Detail {
    int id,uid;
    String city,district,ward,detail;
    int is_default;

    public Address_Detail(int uid, String city, String district, String ward, String detail, int is_default) {
        this.uid = uid;
        this.city = city;
        this.district = district;
        this.ward = ward;
        this.detail = detail;
        this.is_default = is_default;
    }

    public Address_Detail(int id, int uid, String city, String district, String ward, String detail, int is_default) {
        this.id = id;
        this.uid = uid;
        this.city = city;
        this.district = district;
        this.ward = ward;
        this.detail = detail;
        this.is_default = is_default;
    }

    public Address_Detail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getIs_default() {
        return is_default;
    }

    public void setIs_default(int is_default) {
        this.is_default = is_default;
    }
    
            
}
