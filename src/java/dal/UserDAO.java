/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import model.User;

/**
 *
 * @author ASUS
 */
public class UserDAO extends DBContext{

public User checkAccount(String username, String password){
        String sql="select * from Users where username=? and password=?";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            st.setString(1,username);
            st.setString(2,password);
            ResultSet rs=st.executeQuery();
                       
            if(rs.next()){
                return new User(rs.getInt("id"),rs.getInt("loginType"),rs.getInt("role_id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),username,password,
                        rs.getString("email"),rs.getString("phone_number"),
                        rs.getDate("created_at"),rs.getDate("updated_at"),rs.getInt("deleted"),rs.getString("avatar")
                        );
            }
        } catch (SQLException e) {
        }
        return null;
    }
    
    public void addUser(String username,String password, String email) {
        java.sql.Date curDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String sql ="insert into Users values(1, 2, null, null, ?, ?, ?, null,? , null, 0, ?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            st.setString(3, email);
            st.setDate(4, curDate);
            st.setString(5, "avatar/defaultavatar.jpg");

            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void updateUser(int id, String firstname,String lastname,String phonenumber) {
        String sql = "UPDATE [dbo].[Users]\n"
                + "   SET [firstname] = ?\n"
                + "      ,[lastname] = ?\n"
                + "      ,[phone_number] = ?\n"
                + " WHERE id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, firstname);
            st.setString(2, lastname);
            st.setString(3, phonenumber);
            st.setInt(4, id);
            st.executeUpdate();
        } catch (Exception e) {

        }
    }
    
    public void updateAvatar(int id, String avatar) {
        String sql = "UPDATE [dbo].[Users]\n"
                + "   SET [avatar] = ?\n"
                + " WHERE id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, avatar);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (Exception e) {

        }
    }
    
    public User getUserById(int id) {
        String sql = "Select * from Users where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User c = new User(id, rs.getInt("loginType"), rs.getInt("role_id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"), rs.getString("username"), rs.getString("password"),
                        rs.getString("email"), rs.getString("phone_number"),
                        rs.getDate("created_at"), rs.getDate("updated_at"), rs.getInt("deleted"), rs.getString("avatar")
                );
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    
    public void addUserGoogle(String email,Date created_time) {
        String sql = "INSERT INTO [dbo].[Users]\n"
                + "           ([loginType]\n"
                + "           ,[role_id]\n"
                + "           ,[firstname]\n"
                + "           ,[lastname]\n"
                + "           ,[username]\n"
                + "           ,[password]\n"
                + "           ,[email]\n"
                + "           ,[phone_number]\n"
                + "           ,[created_at]\n"
                + "           ,[updated_at]\n"
                + "           ,[deleted])\n"
                + "     VALUES\n"
                + "           (2, 1, null, null, null, null, ?, null, ?, null, null)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            st.setDate(2, created_time);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public User getAccountByLoginName(String name) {
        String sql = "Select * from Users where username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User c = new User(rs.getInt("id"), rs.getInt("loginType"), rs.getInt("role_id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"), name, rs.getString("password"),
                        rs.getString("email"), rs.getString("phone_number"),
                        rs.getDate("created_at"), rs.getDate("updated_at"), rs.getInt("deleted"),rs.getString("avatar")
                );
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    
    public User getAccountByEmail(String email) {
        String sql = "Select * from Users where [email] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User c = new User(rs.getInt("id"), rs.getInt("loginType"), rs.getInt("role_id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"), rs.getString("username"), rs.getString("password"),
                        email, rs.getString("phone_number"), 
                        rs.getDate("created_at"), rs.getDate("updated_at"), rs.getInt("deleted"),rs.getString("avatar")
                );
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    //check cai username day da ton tai chua????
    // neu ton tai roi tra ve true
    //chua ton tai tra ve false
    
     public boolean existedUser(String username) {
        String sql = "SELECT [Username]\n"
                + "      ,[Password]\n"
                + "      ,[email]\n"
                + "  FROM [dbo].[Users]\n"
                + "  where Username=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
     
     //check xem tài khoan co ton tai chua dua vao email
     //
     public boolean existedEmailUser(String email) {
        String sql = "SELECT [Username]\n"
                + "      ,[Password]\n"
                + "      ,[email]\n"
                + "  FROM [dbo].[Users]\n"
                + "  where email=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
     
     
      public void changePassUserByEmail(String newpass, String email) {
        String sql = "update [Users] set \n"
                + "password = ?\n"
                + "where email = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, newpass);
            st.setString(2, email);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
     
      public void updatePass(String password, int id) {
        String sql = "UPDATE [dbo].[Users]\n"
                + "   SET [password] = ?\n"
                + " WHERE id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, password);
            st.setInt(2, id);

            st.executeUpdate();
        } catch (Exception e) {

        }
    }
    
    
    public static void main(String[] args) {
        UserDAO d=new UserDAO();
        
        User u=d.checkAccount("maigiang", "123");
         System.out.println(u);
    }
}