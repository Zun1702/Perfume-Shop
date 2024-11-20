/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Discount;
import model.OrderDetail;
import model.Product;
import model.SizeProduct;

/**
 *
 * @author hp
 */
public class HomeDAO extends DBContext {

    public List<Product> getProductNew() { // lay 12 san pham khac nhau cua moi loai
        List<Product> list = new ArrayList<>();
        String sql = "select top 12 p.gender_id, p.title, p.id, p.thumbnail, p.updated_at, p.discount_id, d.value, min(sp.price_out) as price, min(sp.sid) as sid from Products p\n"
                + "join SizeProduct sp on p.id = sp.pid\n"
                + "join Sizes s on s.id = sp.sid\n"
                + "join Discounts d on d.id = p.discount_id\n"
                + "group by p.title, p.id, p.thumbnail, p.updated_at, p.gender_id, p.discount_id, d.value\n"
                + "order by p.updated_at desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product c = new Product();
                c.setGender_id(rs.getInt("gender_id"));
                c.setTitle(rs.getString("title"));
                c.setThumbnail(rs.getString("thumbnail"));
                c.setUpdated_at(rs.getDate("updated_at"));
                c.setId(rs.getInt("id"));
                SizeProduct sp = new SizeProduct();
                sp.setPid(rs.getInt("id"));
                sp.setSid(rs.getInt("sid"));
                sp.setPrice_out(rs.getInt("price"));
                c.setSizeproduct(sp);
                Discount d = new Discount();
                d.setId(rs.getInt("discount_id"));
                d.setValue(rs.getInt("value"));
                c.setDiscount(d);
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getProductDiscount() { // lay san pham giam gia
        List<Product> list = new ArrayList<>();
        String sql = "select top 4 p.gender_id, p.title, p.id, p.thumbnail, min(sp.price_out) as price, p.discount_id, d.value , min(sp.sid) as sid from Products p\n"
                + "join SizeProduct sp on p.id = sp.pid\n"
                + "join Sizes s on s.id = sp.sid\n"
                + "join Discounts d on p.discount_id = d.id\n"
                + "where p.discount_id != 0\n"
                + "group by p.title, p.id, p.thumbnail, d.value, p.gender_id, p.discount_id\n"
                + "order by p.discount_id desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product c = new Product();
                c.setGender_id(rs.getInt("gender_id"));
                c.setTitle(rs.getString("title"));
                c.setThumbnail(rs.getString("thumbnail"));
                c.setId(rs.getInt("id"));
                SizeProduct sp = new SizeProduct();
                sp.setPid(rs.getInt("id"));
                sp.setSid(rs.getInt("sid"));
                sp.setPrice_out(rs.getInt("price"));
                c.setSizeproduct(sp);
                Discount d = new Discount();
                d.setId(rs.getInt("discount_id"));
                d.setValue(rs.getInt("value"));
                c.setDiscount(d);
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getProductBestSeller() { // lay 6 san pham ban chay nhat
    List<Product> list = new ArrayList<>();
    String sql = "WITH RankedProducts AS (\n" +
            "    SELECT \n" +
            "        p.gender_id, \n" +
            "        p.title, \n" +
            "        p.id, \n" +
            "        p.thumbnail, \n" +
            "        od.num, \n" +
            "        p.discount_id, \n" +
            "        d.value, \n" +
            "        MIN(sp.price_out) AS price, \n" +
            "        MIN(sp.sid) AS sid,\n" +
            "        ROW_NUMBER() OVER (PARTITION BY p.title ORDER BY od.num DESC) AS row_num\n" +
            "    FROM \n" +
            "        Products p\n" +
            "    JOIN \n" +
            "        SizeProduct sp ON p.id = sp.pid\n" +
            "    JOIN \n" +
            "        Sizes s ON s.id = sp.sid\n" +
            "    JOIN \n" +
            "        Order_Details od ON od.product_id = p.id\n" +
            "    JOIN \n" +
            "        Discounts d ON d.id = p.discount_id\n" +
            "    GROUP BY \n" +
            "        p.gender_id, \n" +
            "        p.title, \n" +
            "        p.id, \n" +
            "        p.thumbnail, \n" +
            "        od.num, \n" +
            "        p.discount_id, \n" +
            "        d.value\n" +
            ")\n" +
            "SELECT \n" +
            "    gender_id, \n" +
            "    title, \n" +
            "    id, \n" +
            "    thumbnail, \n" +
            "    num, \n" +
            "    discount_id, \n" +
            "    value, \n" +
            "    price, \n" +
            "    sid\n" +
            "FROM \n" +
            "    RankedProducts\n" +
            "WHERE \n" +
            "    row_num = 1\n" +
            "ORDER BY \n" +
            "    num DESC\n" +
            "OFFSET 0 ROWS FETCH NEXT 6 ROWS ONLY;";

    try {
        PreparedStatement st = connection.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Product c = new Product();
            c.setGender_id(rs.getInt("gender_id"));
            c.setTitle(rs.getString("title"));
            c.setThumbnail(rs.getString("thumbnail"));
            c.setId(rs.getInt("id"));
            SizeProduct sp = new SizeProduct();
            sp.setPid(rs.getInt("id"));
            sp.setSid(rs.getInt("sid"));
            sp.setPrice_out(rs.getInt("price"));
            c.setSizeproduct(sp);
            OrderDetail od = new OrderDetail();
            od.setNum(rs.getInt("num"));
            c.setOrderdetail(od);
            Discount d = new Discount();
            d.setId(rs.getInt("discount_id"));
            d.setValue(rs.getInt("value"));
            c.setDiscount(d);
            list.add(c);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}



}
