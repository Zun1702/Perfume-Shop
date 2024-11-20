/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Discount;
import model.Product;
import model.Size;

/**
 *
 * @author ASUS
 */
public class CartDAO extends DBContext{
    public Product getProductsById(int id) {

        String sql = "select * from Products where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));// đọc từ bảng
                p.setCategory_id(rs.getInt("category_id"));
                p.setTitle(rs.getString("title"));
                p.setGender_id(rs.getInt("gender_id"));
      
                p.setDiscount_id(rs.getInt("discount_id"));
                p.setThumbnail(rs.getString("thumbnail"));
                p.setDescription(rs.getString("description"));
                p.setCreated_at(rs.getDate("created_at"));
                p.setCreated_at(rs.getDate("updated_at"));
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public Size getSizeByID(int id){
        String sql = "select * from Sizes where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Size(rs.getInt("id"), rs.getString("name"), rs.getInt("value"));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public List<Discount> getAllDiscount(){
        String sql="select * from Discounts";
        List<Discount> ld=new ArrayList<Discount>();
        try {
            
            PreparedStatement st=connection.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
               Discount d=new Discount(rs.getInt("id"), rs.getInt("value"));
               ld.add(d);
            }
            return ld;
        } catch (Exception e) {
        }
        return null;
    }
    public static void main(String[] args) {
        CartDAO dao=new CartDAO();
        System.out.println(dao.getAllDiscount());
    }
}
