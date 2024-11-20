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
import model.Address_Detail;
import model.Size;

/**
 *
 * @author ASUS
 */
public class AddressDAO extends DBContext {

    public List<Address_Detail> getAddressByUserID(int uid) {
        List<Address_Detail> list = new ArrayList<>();
        String sql = "select * from Address_Detail where uid=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, uid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Address_Detail a = new Address_Detail();
                a.setId(rs.getInt("id"));
                a.setUid(rs.getInt("uid"));
                a.setCity(rs.getString("city"));
                a.setDistrict(rs.getString("district"));
                a.setWard(rs.getString("ward"));
                a.setDetail(rs.getString("detail"));
                a.setIs_default(rs.getInt("is_default"));
                list.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Address_Detail getAddressDetailByID(int id) {
        String sql = "select * from Address_Detail where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Address_Detail(rs.getInt("id"), rs.getInt("uid"), rs.getString("city"),
                        rs.getString("district"), rs.getString("ward"), rs.getString("detail"),
                        rs.getInt("is_default"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Address_Detail getDefaultAddress(int uid) {
        String sql = "select * from Address_Detail where uid=? and is_default=1";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, uid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Address_Detail(rs.getInt("id"), rs.getInt("uid"), rs.getString("city"),
                        rs.getString("district"), rs.getString("ward"), rs.getString("detail"),
                        rs.getInt("is_default"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void addAddress(Address_Detail a) {
        String sql = "INSERT INTO [dbo].[Address_Detail]\n"
                + "           ([uid]\n"
                + "           ,[city]\n"
                + "           ,[district]\n"
                + "           ,[ward]\n"
                + "           ,[detail]\n"
                + "           ,[is_default])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, a.getUid());
            st.setString(2, a.getCity());
            st.setString(3, a.getDistrict());
            st.setString(4, a.getWard());
            st.setString(5, a.getDetail());
            st.setInt(6, a.getIs_default());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteAddress(int id) {
        String sql = "delete from address_detail where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateAddress(Address_Detail a) {
        String sql = "UPDATE [dbo].[Address_Detail]\n"
                + "   SET [city] = ?\n"
                + "      ,[district] = ?\n"
                + "      ,[ward] = ?\n"
                + "      ,[detail] = ?\n"
                + "      ,[is_default] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, a.getCity());
            st.setString(2, a.getDistrict());
            st.setString(3, a.getWard());
            st.setString(4, a.getDetail());
            st.setInt(5, a.getIs_default());
            st.setInt(6, a.getId());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateAddressDefault(int id, int df) {
        String sql = "UPDATE [dbo].[Address_Detail]\n"
                + "   SET [is_default] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, df);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int getTotalAddress(int uid) {
        String sql = "select count(id) from Address_Detail where uid = ?";
        int sum = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, uid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                sum = rs.getInt(1);
            }
            return sum;
        } catch (Exception e) {
        }
        return 0;
    }

    public Address_Detail getAddressDefault(int uid) {
        Address_Detail a = new Address_Detail();
        String sql = "select * from Address_Detail where uid = ? and is_default = 1";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, uid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                
                a.setId(rs.getInt("id"));
                a.setUid(rs.getInt("uid"));
                a.setCity(rs.getString("city"));
                a.setDistrict(rs.getString("district"));
                a.setWard(rs.getString("ward"));
                a.setDetail(rs.getString("detail"));
                a.setIs_default(rs.getInt("is_default")); 
            }
            return a;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        AddressDAO dao = new AddressDAO();
        Address_Detail list = dao.getAddressDetailByID(1);
        System.out.println(list);
    }
}
