/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Feedback;
import model.Product;
import model.User;
import model.Order;

/**
 *
 * @author canduykhanh
 */
public class FeedBackDAO extends DBContext {

    //getUserById
    public User getUserById(int id) {
        String sql = "select * from Users u where u.id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10), rs.getDate(11), rs.getInt(12), rs.getString(13));
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    //get all feedback by pid
    public List<Feedback> getFeedbackByPid(int pid) {
        List<Feedback> listF = new ArrayList<>();
        String sql = "select f.id,f.user_id,f.product_id,f.note,f.rating,f.created_at from FeedBacks f \n"
                + "join Users u on f.user_id = u.id\n"
                + "join Products p on f.product_id = p.id\n"
                + "where p.id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Feedback f = new Feedback();
                f.setId(rs.getInt("id"));
                User u = getUserById(rs.getInt("user_id"));
                f.setUser(u);
                ProductDAO pd = new ProductDAO();
                Product p = pd.getProductByID(rs.getInt("product_id"));
                f.setNote(rs.getString("note"));
                f.setRating(rs.getInt("rating"));
                f.setCreated_at(rs.getDate("created_at"));
                listF.add(f);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listF;
    }

    //get top  3 new feedback 
    public List<Feedback> getTop3NewFeedbackByPid(int pid) {
        List<Feedback> listF = new ArrayList<>();
        String sql = "select top 3 f.id,f.user_id,f.product_id,f.note,f.rating,f.created_at from FeedBacks f \n"
                + "                join Users u on f.user_id = u.id\n"
                + "                join Products p on f.product_id = p.id\n"
                + "                where p.id = ?\n"
                + "				order by f.id desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Feedback f = new Feedback();
                f.setId(rs.getInt("id"));
                User u = getUserById(rs.getInt("user_id"));
                f.setUser(u);
                ProductDAO pd = new ProductDAO();
                Product p = pd.getProductByID(rs.getInt("product_id"));
                f.setNote(rs.getString("note"));
                f.setRating(rs.getInt("rating"));
                f.setCreated_at(rs.getDate("created_at"));
                listF.add(f);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listF;
    }

    //get top  3 new feedback 
    public List<Feedback> getNext3Feedback(int pid, int amount) {
        List<Feedback> listF = new ArrayList<>();
        String sql = "select f.id,f.user_id,f.product_id,f.note,f.rating,f.created_at from FeedBacks f \n"
                + "                join Users u on f.user_id = u.id\n"
                + "                join Products p on f.product_id = p.id\n"
                + "                where p.id = ?\n"
                + "				order by f.id desc\n"
                + "				offset ? rows \n"
                + "				fetch next 3 row only";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pid);
            st.setInt(2, amount);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Feedback f = new Feedback();
                f.setId(rs.getInt("id"));
                User u = getUserById(rs.getInt("user_id"));
                f.setUser(u);
                ProductDAO pd = new ProductDAO();
                Product p = pd.getProductByID(rs.getInt("product_id"));
                f.setNote(rs.getString("note"));
                f.setRating(rs.getInt("rating"));
                f.setCreated_at(rs.getDate("created_at"));
                listF.add(f);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listF;
    }

    //insert feedback 
    public void insertFeedback(User u, Product p, String note, int rating) {
        Date currentDate = Date.valueOf(LocalDate.now());
        String sql = "INSERT INTO [FeedBacks]\n"
                + "           ([user_id]\n"
                + "           ,[product_id]\n"
                + "           ,[note]\n"
                + "           ,[rating]\n"
                + "           ,[created_at]) values(?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, u.getId());
            st.setInt(2, p.getId());
            st.setString(3, note);
            st.setInt(4, rating);
            st.setDate(5, currentDate);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //check feedback of each user of each product of each order is exist or no
//    public Feedback getFeedBackByUserOrderProduct(User u, Order o, Product p) {
//        String sql = "select f.* from Users u\n"
//                + "inner join FeedBacks f on u.id = f.user_id\n"
//                + "join Products p on p.id = f.product_id\n"
//                + "join Orders o on u.id= o.user_id\n"
//                + "where u.id= ? and o.id= ? and p.id =?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, u.getId());
//            st.setInt(2, o.getId());
//            st.setInt(3, p.getId());
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                Feedback f = new Feedback();
//                f.setId(rs.getInt("id"));
//                f.setNote(rs.getString("note"));
//                f.setRating(rs.getInt("rating"));
//                return f;
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//        return null;
//    }
//
//    public User getAccountById(int id) {
//        String sql = "Select * from Users where [id] = ?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, id);
//            ResultSet rs = st.executeQuery();
//            if (rs.next()) {
//                User c = new User(rs.getInt("id"), rs.getInt("loginType"), rs.getInt("role_id"),
//                        rs.getString("firstname"),
//                        rs.getString("lastname"), rs.getString("username"), rs.getString("password"),
//                        rs.getString("email"), rs.getString("phone_number"),
//                        rs.getDate("created_at"), rs.getDate("updated_at"), rs.getInt("deleted"), rs.getString("avatar")
//                );
//                return c;
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return null;
//    }
//
//    public Product getProductByID(int id) {
//        String sql = "select * from Products where id=?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, id);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                Product p = new Product();
//                p.setId(rs.getInt("id"));
//                p.setCategory_id(rs.getInt("category_id"));
//                p.setTitle(rs.getString("title"));
//                p.setGender_id(rs.getInt("gender_id"));
//                p.setDiscount_id(rs.getInt("discount_id"));
//                p.setThumbnail(rs.getString("thumbnail"));
//                p.setDescription(rs.getString("description"));
//                p.setCreated_at(rs.getDate("created_at"));
//                p.setUpdated_at(rs.getDate("updated_at"));
//                return p;
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return null;
//    }
//
//    public Order getOrderByID(int id) {
//        String sql = "select * from Orders where id =?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, id);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                Order o = new Order();
//                o.setId(rs.getInt("id"));
//                return o;
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return null;
//    }
    //tra ve 1 danh sach dat hanh thanh cong cua moi user
    public List<Order> checkOrder(int u, int i) {
        List<Order> list = new ArrayList<>();
        String sql = "select  o1.status_id from Orders o1 \n"
                + "join Order_Details o2 on o1.id = o2.order_id\n"
                + "where o1.user_id = " + u + " and o2.product_id = " + i + " and o1.status_id = 3";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setStatus_id(rs.getInt("status_id"));
                list.add(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // tra ve 1 danh sach comment cua ngwuoi dung doi voi moi san pham
    public List<Feedback> checkF(int u, int i) {
        List<Feedback> list = new ArrayList<>();
        String sql = "select id from FeedBacks \n"
                + "where user_id = " + u + " and product_id = " + i;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Feedback f = new Feedback();
                f.setId(rs.getInt("id"));
                list.add(f);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
//        FeedBackDAO fd = new FeedBackDAO();
//        int p_id = 17;
//        Product p = fd.getProductByID(p_id);
//        int o_id = 7;
//        int u_id = 11;  
//        User u = fd.getUserById(u_id);
//        Order o = fd.getOrderByID(o_id);
//        Feedback f = fd.getFeedBackByUserOrderProduct(u, o, p);
//        System.out.println(f.getId()+f.getNote());
        FeedBackDAO f = new FeedBackDAO();
        System.out.println(f.checkOrder(11, 7).size());
    }

}
