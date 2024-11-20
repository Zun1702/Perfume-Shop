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
import java.util.List;
import model.Category;
import model.Discount;
import model.Gallery;
import model.Gender;
import model.Product;
import model.Size;
import model.SizeProduct;

/**
 *
 * @author hp
 */
public class CrudDAO extends DBContext {

    public boolean checkDiscountById(int id) {

        String sql = "SELECT discount_id\n"
                + "      \n"
                + "  FROM [SWP391_1].[dbo].[Products]\n"
                + "  group by discount_id";

        try {
            PreparedStatement st = connection.prepareStatement(sql);     
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                if (id == rs.getInt("discount_id")) {
                    return true;
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }

    public boolean checkSizeByValue(int value) {

        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[value]\n"
                + "  FROM [dbo].[Sizes]\n"
                + "  where value = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, value);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return true;

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }

    public boolean checkDiscountExist(int value) {

        String sql = "SELECT [id]\n"
                + "      ,[value]\n"
                + "  FROM [dbo].[Discounts]\n"
                + "  where value = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, value);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return true;

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }

    public boolean checkCategoryExist(String name) {

        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "  FROM [dbo].[Categories]\n"
                + "\n"
                + "  where name = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return true;

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }

    public void insertDiscount(int discount) {
        String sql = "INSERT INTO [dbo].[Discounts]\n"
                + "           ([value])\n"
                + "     VALUES\n"
                + "           (?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, discount);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insertSize(int size) {
        String sql = "INSERT INTO [dbo].[Sizes]\n"
                + "           ([name]\n"
                + "           ,[value])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            String size_raw = size + "ml";
            st.setString(1, size_raw);
            st.setInt(2, size);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insertGallery(int id, String thumbnail) {
        String sql = "INSERT INTO [dbo].[Galeries]\n"
                + "           ([product_id]\n"
                + "           ,[thumbnail])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.setString(2, thumbnail);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insertCategory(String name) {
        String sql = "INSERT INTO [dbo].[Categories]\n"
                + "           ([name])\n"
                + "     VALUES\n"
                + "           (?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteGallery(int id) {
        String sql = "DELETE FROM [dbo].[Galeries]\n"
                + "      WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteSize(int id) {
        String sql = "DELETE FROM [dbo].[Sizes]\n"
                + "      WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteDiscount(int id) {
        String sql = "DELETE FROM [dbo].[Discounts]\n"
                + "      WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteCategory(int id) {
        String sql = "DELETE FROM [dbo].[Categories]\n"
                + "      WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void editSize(int id, int size) {
        String sql = "UPDATE [dbo].[Sizes]\n"
                + "   SET [name] = ? \n"
                + "      ,[value] = ? \n"
                + " WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            String name = size + "ml";
            st.setString(1, name);
            st.setInt(2, size);
            st.setInt(3, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void editDiscount(int id, int discount) {
        String sql = "UPDATE [dbo].[Discounts]\n"
                + "   SET [value] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, discount);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void editGallery(int id, int pid, String thumbnail) {
        String sql = "UPDATE [dbo].[Galeries]\n"
                + "   SET [product_id] = ?\n"
                + "      ,[thumbnail] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pid);
            st.setString(2, thumbnail);
            st.setInt(3, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void editCategory(String name, int id) {
        String sql = "UPDATE [dbo].[Categories]\n"
                + "   SET [name] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public SizeProduct getSizeProduct(int sid, int pid) {
        String sql = "SELECT [pid]\n"
                + "      ,[sid]\n"
                + "      ,[quantity]\n"
                + "      ,[price_in]\n"
                + "      ,[price_out]\n"
                + "  FROM [dbo].[SizeProduct]\n"
                + "  where sid = ? and pid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, sid);
            st.setInt(2, pid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                SizeProduct c = new SizeProduct();
                c.setPid(rs.getInt("pid"));
                c.setSid(rs.getInt("sid"));
                c.setQuantity(rs.getInt("quantity"));
                c.setPrice_in(rs.getInt("price_in"));
                c.setPrice_out(rs.getInt("price_out"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void addQuantity(int sid, int pid, int quantity) {
        String sql = "UPDATE [dbo].[SizeProduct]\n"
                + "   SET \n"
                + "      [quantity] = ?\n"
                + "     \n"
                + " WHERE sid = ? and pid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, quantity);
            st.setInt(2, sid);
            st.setInt(3, pid);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public boolean checkCategoryExist(int cid) {

        String sql = "SELECT [category_id]\n"
                + "      \n"
                + "  FROM [SWP391_1].[dbo].[Products]\n"
                + "  group by [category_id]";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                if (cid == rs.getInt("category_id")) {
                    return true;
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }

    public boolean checkSizeExist(int sid) {

        String sql = "select sid from SizeProduct group by sid";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                if (sid == rs.getInt("sid")) {
                    return true;
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }

    public boolean checkSize(int sid, int pid) {

        String sql = "select sid from SizeProduct where pid = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                if (sid == rs.getInt("sid")) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }

    public boolean checkTitle(String title) {

        String sql = "select title from products";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                if (title.equals(rs.getString("title"))) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }

    public Product getProductByTitle(String title) {

        String sql = "select * from products where title = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, title);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product c = new Product();
                c.setId(rs.getInt("id"));
                c.setCategory(getCategoryByCid(rs.getInt("category_id")));
                c.setTitle(rs.getString("title"));
                c.setGender(getGenderByCid(rs.getInt("gender_id")));
                c.setDiscount(getDiscountByCid(rs.getInt("discount_id")));
                c.setThumbnail(rs.getString("thumbnail"));
                c.setDescription(rs.getString("description"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Product> getProductByDate(String date) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from products p join SizeProduct sp  \n"
                + "                 on p.id = sp.pid \n"
                + "                 where p.updated_at = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, date);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product c = new Product();
                c.setId(rs.getInt("id"));
                Category cate = getCategoryByCid(rs.getInt("category_id"));
                c.setCategory(cate);
                Gender g = getGenderByCid(rs.getInt("gender_id"));
                c.setGender(g);
                Discount d = getDiscountByCid(rs.getInt("discount_id"));
                c.setDiscount(d);
                c.setTitle(rs.getString("title"));
                c.setThumbnail(rs.getString("thumbnail"));
                c.setDescription(rs.getString("description"));
                SizeProduct ps = new SizeProduct();
                ps.setPid(rs.getInt("id"));
                ps.setQuantity(rs.getInt("quantity"));
                ps.setSid(rs.getInt("sid"));
                ps.setPrice_in(rs.getInt("price_in"));
                ps.setPrice_out(rs.getInt("price_out"));
                c.setSizeproduct(ps);
                Size s = getSizeByCid(rs.getInt("sid"));
                c.setSize(s);
                c.setUpdated_at(rs.getDate("updated_at"));
                c.setCreated_at(rs.getDate("created_at"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getProductByGid(int id) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from products p join SizeProduct sp \n"
                + "on p.id = sp.pid "
                + "where p.gender_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product c = new Product();
                c.setId(rs.getInt("id"));
                Category cate = getCategoryByCid(rs.getInt("category_id"));
                c.setCategory(cate);
                Gender g = getGenderByCid(rs.getInt("gender_id"));
                c.setGender(g);
                Discount d = getDiscountByCid(rs.getInt("discount_id"));
                c.setDiscount(d);
                c.setTitle(rs.getString("title"));
                c.setThumbnail(rs.getString("thumbnail"));
                c.setDescription(rs.getString("description"));
                SizeProduct ps = new SizeProduct();
                ps.setPid(rs.getInt("id"));
                ps.setQuantity(rs.getInt("quantity"));
                ps.setSid(rs.getInt("sid"));
                ps.setPrice_in(rs.getInt("price_in"));
                ps.setPrice_out(rs.getInt("price_out"));
                c.setSizeproduct(ps);
                Size s = getSizeByCid(rs.getInt("sid"));
                c.setSize(s);
                c.setUpdated_at(rs.getDate("updated_at"));
                c.setCreated_at(rs.getDate("created_at"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getProductByCid(int id) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from products p join SizeProduct sp \n"
                + "on p.id = sp.pid "
                + "where p.category_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product c = new Product();
                c.setId(rs.getInt("id"));
                Category cate = getCategoryByCid(rs.getInt("category_id"));
                c.setCategory(cate);
                Gender g = getGenderByCid(rs.getInt("gender_id"));
                c.setGender(g);
                Discount d = getDiscountByCid(rs.getInt("discount_id"));
                c.setDiscount(d);
                c.setTitle(rs.getString("title"));
                c.setThumbnail(rs.getString("thumbnail"));
                c.setDescription(rs.getString("description"));
                SizeProduct ps = new SizeProduct();
                ps.setPid(rs.getInt("id"));
                ps.setQuantity(rs.getInt("quantity"));
                ps.setSid(rs.getInt("sid"));
                ps.setPrice_in(rs.getInt("price_in"));
                ps.setPrice_out(rs.getInt("price_out"));
                c.setSizeproduct(ps);
                Size s = getSizeByCid(rs.getInt("sid"));
                c.setSize(s);
                c.setUpdated_at(rs.getDate("updated_at"));
                c.setCreated_at(rs.getDate("created_at"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Product getEditProduct(int pid, int sid) {

        String sql = "select * from products p join SizeProduct sp   \n"
                + "                   on p.id = sp.pid \n"
                + "                   where sid = ? and pid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, sid);
            st.setInt(2, pid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product c = new Product();
                c.setId(rs.getInt("id"));
                Category cate = getCategoryByCid(rs.getInt("category_id"));
                c.setCategory(cate);
                Gender g = getGenderByCid(rs.getInt("gender_id"));
                c.setGender(g);
                Discount d = getDiscountByCid(rs.getInt("discount_id"));
                c.setDiscount(d);
                c.setTitle(rs.getString("title"));
                c.setThumbnail(rs.getString("thumbnail"));
                c.setDescription(rs.getString("description"));
                SizeProduct ps = new SizeProduct();
                ps.setPid(rs.getInt("id"));
                ps.setQuantity(rs.getInt("quantity"));
                ps.setSid(rs.getInt("sid"));
                ps.setPrice_in(rs.getInt("price_in"));
                ps.setPrice_out(rs.getInt("price_out"));
                c.setSizeproduct(ps);
                Size s = getSizeByCid(rs.getInt("sid"));
                c.setSize(s);
                c.setUpdated_at(rs.getDate("updated_at"));
                c.setCreated_at(rs.getDate("created_at"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void updateProduct(int category_id, String title, int gender_id,
            int discount_id, String thumbnail, String description, int id) {
        String sql = "UPDATE [dbo].[Products]\n"
                + "   SET [category_id] = ?\n"
                + "      ,[title] = ?\n"
                + "      ,[gender_id] = ?\n"
                + "      ,[discount_id] = ?\n"
                + "      ,[thumbnail] = ?\n"
                + "      ,[updated_at] = getdate()"
                + "      ,[description] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, category_id);
            st.setString(2, title);
            st.setInt(3, gender_id);
            st.setInt(4, discount_id);
            st.setString(5, thumbnail);
            st.setString(6, description);
            st.setInt(7, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateSizeProduct(int pid, int sid_old, int sid_new, int quantity,
            int price_in, int price_out) {
        String sql = "UPDATE [dbo].[SizeProduct]\n"
                + "   SET [quantity] = ?\n"
                + "      ,[sid] = ?\n"
                + "      ,[price_in] = ?\n"
                + "      ,[price_out] = ?\n"
                + " WHERE pid = ? and sid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, quantity);
            st.setInt(2, sid_new);
            st.setInt(3, price_in);
            st.setInt(4, price_out);
            st.setInt(5, pid);
            st.setInt(6, sid_old);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteProduct(int pid) {
        String sql = "DELETE FROM [dbo].[Products]\n"
                + "      WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pid);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteSizeProduct(int pid, int sid) {
        String sql = "UPDATE [dbo].[SizeProduct]\n"
                + "   SET \n"
                + "      [quantity] = 0\n"
                + "     \n"
                + " WHERE pid = ? and sid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pid);
            st.setInt(2, sid);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insertSizeProduct(int pid, int sid, int quantity, int price_in, int price_out) {
        String sql = "INSERT INTO [dbo].[SizeProduct]\n"
                + "           ([pid]\n"
                + "           ,[sid]\n"
                + "           ,[quantity]\n"
                + "           ,[price_in]\n"
                + "           ,[price_out])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pid);
            st.setInt(2, sid);
            st.setInt(3, quantity);
            st.setInt(4, price_in);
            st.setInt(5, price_out);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Product getIdLastProduct() {

        String sql = "SELECT top 1 id\n"
                + "\n"
                + "  FROM [dbo].[Products]\n"
                + "\n"
                + "  order by id desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                Product c = new Product();
                c.setId(rs.getInt("id"));

                return c;
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
        return null;
    }

    public void insertProduct(int category_id, String title, int gender_id, int discount_id, String thumbnail, String description) {
        String sql = "INSERT INTO [dbo].[Products]\n"
                + "           ([category_id]\n"
                + "           ,[title]\n"
                + "           ,[gender_id]\n"
                + "           ,[discount_id]\n"
                + "           ,[thumbnail]\n"
                + "           ,[description]\n"
                + "           ,[created_at]\n"
                + "           ,[updated_at])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,getdate()\n"
                + "           ,getdate())";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, category_id);
            st.setString(2, title);
            st.setInt(3, gender_id);
            st.setInt(4, discount_id);
            st.setString(5, thumbnail);
            st.setString(6, description);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Gallery> getAllGalleryByPid(int id) {
        List<Gallery> list = new ArrayList<>();
        String sql = "select * from Galeries"
                + " where product_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Gallery c = new Gallery();
                c.setId(rs.getInt("id"));
                c.setProduct_id(rs.getInt("product_id"));
                c.setThumbnail(rs.getString("thumbnail"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public int countAllGallery() {
       
        String sql = "select count(*) from Galeries";
        try {
            PreparedStatement st = connection.prepareStatement(sql);    
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
    
    public List<Gallery> getAllGallery(int pageIndex, int pageSize) {
        List<Gallery> list = new ArrayList<>();
        String sql = "select * from Galeries"
                + " order by product_id asc "
+ "                OFFSET (?-1)*? rows   \n" +
"                FETCH NEXT ? rows only";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,pageIndex);
            st.setInt(2, pageSize);
            st.setInt(3, pageSize);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Gallery c = new Gallery();
                c.setId(rs.getInt("id"));
                c.setProduct_id(rs.getInt("product_id"));
                c.setThumbnail(rs.getString("thumbnail"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Size> getAllSize() {
        List<Size> list = new ArrayList<>();
        String sql = "select * from Sizes";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Size c = new Size();
                c.setId(rs.getInt("id"));
                c.setValue(rs.getInt("value"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Discount> getAllDiscount() {
        List<Discount> list = new ArrayList<>();
        String sql = "select * from Discounts";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Discount c = new Discount();
                c.setId(rs.getInt("id"));
                c.setValue(rs.getInt("value"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Gender> getAllGender() {
        List<Gender> list = new ArrayList<>();
        String sql = "select * from Genders";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Gender c = new Gender();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "select * from Categories";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getAllProductByTitle(String title) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from products p join SizeProduct sp \n"
                + "on p.id = sp.pid \n"
                + "where p.title like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setNString(1, "%" + title + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product c = new Product();
                c.setId(rs.getInt("id"));
                Category cate = getCategoryByCid(rs.getInt("category_id"));
                c.setCategory(cate);
                Gender g = getGenderByCid(rs.getInt("gender_id"));
                c.setGender(g);
                Discount d = getDiscountByCid(rs.getInt("discount_id"));
                c.setDiscount(d);
                c.setTitle(rs.getString("title"));
                c.setThumbnail(rs.getString("thumbnail"));
                c.setDescription(rs.getString("description"));
                SizeProduct ps = new SizeProduct();
                ps.setPid(rs.getInt("id"));
                ps.setQuantity(rs.getInt("quantity"));
                ps.setSid(rs.getInt("sid"));
                ps.setPrice_in(rs.getInt("price_in"));
                ps.setPrice_out(rs.getInt("price_out"));
                c.setSizeproduct(ps);
                Size s = getSizeByCid(rs.getInt("sid"));
                c.setSize(s);
                c.setUpdated_at(rs.getDate("updated_at"));
                c.setCreated_at(rs.getDate("created_at"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public int countAllProduct() {
        
        String sql = "select count(*) from products p join SizeProduct sp \n" +
                     "                on p.id = sp.pid where sp.quantity > 0";
               ;
        try {
            PreparedStatement st = connection.prepareStatement(sql);  
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<Product> getAllProduct(int pageIndex, int pageSize) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from products p join SizeProduct sp \n" +
"                on p.id = sp.pid \n"
                + " where sp.quantity > 0 \n" +
"				order by p.id asc\n" +
"                OFFSET (?-1)*? rows   \n" +
"                FETCH NEXT ? rows only";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,pageIndex);
            st.setInt(2, pageSize);
            st.setInt(3, pageSize);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product c = new Product();
                c.setId(rs.getInt("id"));
                Category cate = getCategoryByCid(rs.getInt("category_id"));
                c.setCategory(cate);
                Gender g = getGenderByCid(rs.getInt("gender_id"));
                c.setGender(g);
                Discount d = getDiscountByCid(rs.getInt("discount_id"));
                c.setDiscount(d);
                c.setTitle(rs.getString("title"));
                c.setThumbnail(rs.getString("thumbnail"));
                c.setDescription(rs.getString("description"));
                SizeProduct ps = new SizeProduct();
                ps.setPid(rs.getInt("id"));
                ps.setQuantity(rs.getInt("quantity"));
                ps.setSid(rs.getInt("sid"));
                ps.setPrice_in(rs.getInt("price_in"));
                ps.setPrice_out(rs.getInt("price_out"));
                c.setSizeproduct(ps);
                Size s = getSizeByCid(rs.getInt("sid"));
                c.setSize(s);
                c.setUpdated_at(rs.getDate("updated_at"));
                c.setCreated_at(rs.getDate("created_at"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getListByPage(List<Product> list, int start, int end) { // phan trang
        List<Product> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public Gallery getGalleryById(int id) { // lay cac loai san pham bang category_id

        String sql = "SELECT [id]\n"
                + "      ,[product_id]\n"
                + "      ,[thumbnail]\n"
                + "  FROM [dbo].[Galeries]\n"
                + "  where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Gallery c = new Gallery();
                c.setId(rs.getInt("id"));
                c.setProduct_id(rs.getInt("product_id"));
                c.setThumbnail(rs.getString("thumbnail"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Category getCategoryByCid(int cid) { // lay cac loai san pham bang category_id

        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "  FROM [dbo].[Categories]\n"
                + "  where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Gender getGenderByCid(int gid) { // lay gioi tinh bang gender_id

        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "  FROM [dbo].[Genders]\n"
                + "  where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, gid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Gender g = new Gender();
                g.setId(rs.getInt("id"));
                g.setName(rs.getString("name"));
                return g;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Discount getDiscountByCid(int did) { // lay gioi tinh bang gender_id

        String sql = "SELECT [id]\n"
                + "      ,[value]\n"
                + "  FROM [dbo].[Discounts]"
                + "  where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, did);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Discount d = new Discount();
                d.setId(rs.getInt("id"));
                d.setValue(rs.getInt("value"));
                return d;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Size getSizeByCid(int sid) { // lay gioi tinh bang size_id

        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[value]\n"
                + "  FROM [dbo].[Sizes]"
                + "  where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, sid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Size d = new Size();
                d.setId(rs.getInt("id"));
                d.setValue(rs.getInt("value"));
                return d;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

}
