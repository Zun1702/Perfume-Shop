/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import model.Address_Detail;
import model.Cart;
import model.Category;
import model.Discount;
import model.Gender;
import model.Item;
import model.Order;
import model.OrderDetail;
import model.Product;
import model.Size;
import model.SizeProduct;
import model.Status;
import model.User;

/**
 *
 * @author ASUS
 */
public class OrderDAO extends DBContext {

    public void addOrder(User u, int address_id, Cart cart, String note, List<Discount> ld) {
        java.sql.Date curDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        try {
            String sql = "insert into [orders] values(?,?,?,?,?,?,?,?,1,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, u.getId());
            st.setString(2, u.getFirstname());
            st.setString(3, u.getLastname());
            st.setString(4, u.getEmail());
            st.setString(5, u.getPhone_number());
            st.setInt(6, address_id);
            st.setString(7, note);
            st.setDate(8, (Date) curDate);
            st.setDouble(9, cart.getTotalMoney(ld));
            st.executeUpdate();

            String sql2 = "select top 1 id from orders order by id  desc";
            st = connection.prepareStatement(sql2);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int order_id = rs.getInt("id");
                for (Item i : cart.getItems()) {
                    String sql3 = "insert into Order_Details values(?,?,?,?,?,?,?)";
                    st = connection.prepareStatement(sql3);
                    st.setInt(1, order_id);
                    st.setInt(2, i.getProduct().getId());
                    st.setInt(3, i.getSizeproduct().getSid());
                    st.setDouble(4, cart.getExactItemMoneyOut(i, ld));
                    st.setInt(5, i.getQuantity());
                    st.setDouble(6, i.getQuantity() * i.getSizeproduct().getPrice_in());
                    st.setDouble(7, cart.getExactItemMoneyOut(i, ld) * i.getQuantity());
                    st.executeUpdate();
                }
                String sql4 = "update SizeProduct set quantity=quantity-? where pid=? AND sid=?";
                st = connection.prepareStatement(sql4);
                for (Item i : cart.getItems()) {
                    st.setInt(1, i.getQuantity());
                    st.setInt(2, i.getProduct().getId());
                    st.setInt(3, i.getSizeproduct().getSid());
                    st.executeUpdate();
                }

            }
        } catch (Exception e) {
        }
    }

    public int getSumTotalMoney(int userid) {
        int sum = 0;
        String sql = "select sum(total_money) from Orders\n"
                + "where user_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                sum = rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return sum;
    }

    public List<Order> getOrderByUserId(int id) {
        List<Order> list = new ArrayList<>();
        String sql = "select o.id as oid, user_id, firstname, lastname, email, phone_number, address_id, note,"
                + "order_date, status_id, total_money, s.name as sname"
                + " from Orders o join Status s on o.status_id = s.id where user_id = ? order by o.id desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Status status = new Status(rs.getInt("status_id"), rs.getString("sname"));
                Order o = new Order(rs.getInt("oid"), rs.getInt("user_id"), rs.getString("firstname"), rs.getString("lastname"),
                        rs.getString("email"), rs.getString("phone_number"), rs.getInt("address_id"), rs.getString("note"),
                        rs.getDate("order_date"), rs.getInt("status_id"), rs.getInt("total_money"), status);
                list.add(o);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
   

    public List<Order> getOrderByUserIdOrderByDate(int id, int pageIndex, int pageSize) {
        List<Order> list = new ArrayList<>();
        String sql = "select o.id as oid, user_id, firstname, lastname, email, phone_number, address_id, note,"
                + "order_date, status_id, total_money, s.name as sname"
                + " from Orders o join Status s on o.status_id = s.id where user_id = ? order by o.id desc"
                +"                OFFSET (?-1)*? rows   \n" 
                +"                FETCH NEXT ? rows only";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.setInt(2,pageIndex);
            st.setInt(3, pageSize);
            st.setInt(4, pageSize);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Status status = new Status(rs.getInt("status_id"), rs.getString("sname"));
                Order o = new Order(rs.getInt("oid"), rs.getInt("user_id"), rs.getString("firstname"), rs.getString("lastname"),
                        rs.getString("email"), rs.getString("phone_number"), rs.getInt("address_id"), rs.getString("note"),
                        rs.getDate("order_date"), rs.getInt("status_id"), rs.getInt("total_money"), status);
                list.add(o);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<OrderDetail> getOrderDetailByOrderId(int id) {
        List<OrderDetail> list = new ArrayList<>();
        String sql = "select * from Order_Details where order_id = ?";
        ProductDAO dao = new ProductDAO();

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                OrderDetail o = new OrderDetail();
                o.setId(rs.getInt("id"));
                o.setOrder_id(rs.getInt("order_id"));
                o.setSize_id(rs.getInt("size_id"));
                o.setProduct_id(rs.getInt("product_id"));
                o.setPrice(rs.getInt("price"));
                o.setNum(rs.getInt("num"));
                o.setTotal_money_in(rs.getInt("total_money_in"));
                o.setTotal_money_out(rs.getInt("total_money_out"));
                Product product = dao.getProductByID(rs.getInt("product_id"));
                Size size = dao.getSizeById(rs.getInt("size_id"));
                o.setProduct(product);
                o.setSize(size);

                list.add(o);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Order getOrderById(int id) {

        String sql = "select * from Orders where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            AddressDAO dao = new AddressDAO();
            if (rs.next()) {
                Status status = getStatusById(rs.getInt("status_id"));
                Address_Detail address = dao.getAddressDetailByID(rs.getInt("address_id"));
                Order o = new Order(rs.getInt("id"), rs.getInt("user_id"), rs.getString("firstname"), rs.getString("lastname"),
                        rs.getString("email"), rs.getString("phone_number"), rs.getInt("address_id"), rs.getString("note"),
                        rs.getDate("order_date"), rs.getInt("status_id"), rs.getInt("total_money"), status, address);
                return o;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Status getStatusById(int id) {
        String sql = "select * from Status where id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Status s = new Status();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                return s;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public int getNumberOfOrder(int uid) {
        String sql = "select count(id) as number from Orders where user_id = ?";
        int n = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, uid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                n = rs.getInt(1);
                return n;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<Order> getAllOrderPresentationPaging(int id, int pageIndex, int pageSize) {

        List<Order> list = new ArrayList<>();
        String sql = "select * from Orders where user_id = ? order by id"
                + "OFFSET (?-1)*? rows"
                + "FETCH NEXT ? rows only";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.setInt(2, pageIndex);
            st.setInt(3, pageSize);
            st.setInt(4, pageSize);
            ResultSet rs = st.executeQuery();
            AddressDAO dao = new AddressDAO();
            while (rs.next()) {
                Status status = getStatusById(rs.getInt("status_id"));
                Address_Detail address = dao.getAddressDetailByID(rs.getInt("address_id"));
                Order o = new Order(rs.getInt("id"), rs.getInt("user_id"), rs.getString("firstname"), rs.getString("lastname"),
                        rs.getString("email"), rs.getString("phone_number"), rs.getInt("address_id"), rs.getString("note"),
                        rs.getDate("order_date"), rs.getInt("status_id"), rs.getInt("total_money"), status, address);
                list.add(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void updateStatusOrder(int orderId, int status) {
        String sql = "UPDATE [dbo].[Orders]\n"
                + "   SET \n"
                + "      [status_id] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, status);
            st.setInt(2, orderId);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        OrderDAO o = new OrderDAO();
        int cnt = o.getNumberOfOrder(11);
        System.out.println(cnt);
    }

    public Discount getDiscountById(int id) {
        String sql = "select * from Discounts where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Discount d = new Discount(id, rs.getInt("value"));
                return d;
            }
        } catch (Exception e) {
        }
        return null;
    }

    //tong tien don hang chua giam gia
    public int getSumMoney(List<OrderDetail> list) {
        int sum = 0;
        ProductDAO dao = new ProductDAO();

        for (OrderDetail o : list) {
            SizeProduct sp = dao.getSizeProductByPidSid(o.getProduct_id(), o.getSize_id());
            sum += sp.getPrice_out() * o.getNum();

        }
        return sum;
    }
   
}
