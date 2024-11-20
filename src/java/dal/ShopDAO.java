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
import model.Gender;
import model.Product;
import model.Size;
import model.SizeProduct;

/**
 *
 * @author canduykhanh
 */
public class ShopDAO extends DBContext {

//lay discount by id
    public Discount getDisCountById(int id) {
        String sql = "select * from Discounts where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
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

// lay gender by id
    public Gender getGenderById(int id) {
        String sql = "select * from Genders where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
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

    //lây ra tat ca cac category 
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "  FROM [dbo].[Categories]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("id"), rs.getString("name"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //get category by id
    public Category getCategoryById(int id) {
        String sql = "select * from Categories where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
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

    public SizeProduct getSizeProduct(int pid, int sid) {
        String sql = "SELECT [pid]\n"
                + "      ,[sid]\n"
                + "      ,[quantity]\n"
                + "      ,[price_in]\n"
                + "      ,[price_out]\n"
                + "  FROM [dbo].[SizeProduct]\n"
                + "  where pid = ? and sid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pid);
            st.setInt(2, sid);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                SizeProduct sp = new SizeProduct();
                sp.setPid(rs.getInt("pid"));
                sp.setSid(rs.getInt("sid"));
                sp.setQuantity(rs.getInt("quantity"));
                sp.setPrice_in(rs.getInt("price_in"));
                sp.setPrice_out(rs.getInt("price_out"));
                return sp;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;

    }

//
    //Searh các san pham dai dien theo title
    public List<Product> searchProductByTitle(String txtTitle) {
        List<Product> list = new ArrayList<>();
        String sql = "select p.id,p.title, p.thumbnail, p.discount_id,p.gender_id,p.category_id, d.value ,min(sp.price_out-sp.price_out*d.value/100) as price, min(sp.sid) as sid \n"
                + "                   from Products p  \n"
                + "                   join SizeProduct sp on p.id = sp.pid  \n"
                + "                   join Sizes s on s.id = sp.sid  \n"
                + "                   join Discounts d on d.id = p.discount_id  \n"
                + "                   group by p.id,p.title, p.thumbnail , p.discount_id, d.value,p.gender_id,p.category_id\n"
                + "				   having p.title like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + txtTitle + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setThumbnail(rs.getString("thumbnail"));
                Discount d = getDisCountById(rs.getInt("discount_id"));
                Gender g = getGenderById(rs.getInt("gender_id"));
                Category c = getCategoryById(rs.getInt("category_id"));
                SizeProduct sp = getSizeProduct(rs.getInt("id"), rs.getInt("sid"));
                p.setCategory(c);
                p.setDiscount(d);
                p.setSizeproduct(sp);
                p.setGender(g);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //Sap xep cac san pham tieu bieu theo gia tieu de tu A-Z
    public List<Product> sortProductByAZ() {
        List<Product> list = new ArrayList<>();
        String sql = "select p.id,p.title, p.thumbnail, p.discount_id,p.gender_id,p.category_id, d.value ,min(sp.price_out-sp.price_out*d.value/100) as price, min(sp.sid) as sid \n"
                + "                   from Products p  \n"
                + "                   join SizeProduct sp on p.id = sp.pid  \n"
                + "                   join Sizes s on s.id = sp.sid  \n"
                + "                   join Discounts d on d.id = p.discount_id  \n"
                + "                   group by p.id,p.title, p.thumbnail , p.discount_id, d.value,p.gender_id,p.category_id\n"
                + "				   order by p.title asc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setThumbnail(rs.getString("thumbnail"));
                Discount d = getDisCountById(rs.getInt("discount_id"));
                Gender g = getGenderById(rs.getInt("gender_id"));
                Category c = getCategoryById(rs.getInt("category_id"));
                SizeProduct sp = getSizeProduct(rs.getInt("id"), rs.getInt("sid"));
                p.setCategory(c);
                p.setDiscount(d);
                p.setSizeproduct(sp);
                p.setGender(g);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //Sap xep cac san pham tieu bieu theo gia tieu de tu Z-A
    public List<Product> sortProductByZA() {
        List<Product> list = new ArrayList<>();
        String sql = "select p.id,p.title, p.thumbnail, p.discount_id,p.gender_id,p.category_id, d.value ,min(sp.price_out-sp.price_out*d.value/100) as price, min(sp.sid) as sid \n"
                + "                   from Products p  \n"
                + "                   join SizeProduct sp on p.id = sp.pid  \n"
                + "                   join Sizes s on s.id = sp.sid  \n"
                + "                   join Discounts d on d.id = p.discount_id  \n"
                + "                   group by p.id,p.title, p.thumbnail , p.discount_id, d.value,p.gender_id,p.category_id\n"
                + "				   order by p.title desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setThumbnail(rs.getString("thumbnail"));
                Discount d = getDisCountById(rs.getInt("discount_id"));
                Gender g = getGenderById(rs.getInt("gender_id"));
                Category c = getCategoryById(rs.getInt("category_id"));
                SizeProduct sp = getSizeProduct(rs.getInt("id"), rs.getInt("sid"));
                p.setCategory(c);
                p.setDiscount(d);
                p.setSizeproduct(sp);
                p.setGender(g);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //Sap xep cac san pham tieu bieu theo gia tang dan
    public List<Product> sortProductByPriceAsc() {
        List<Product> list = new ArrayList<>();
        String sql = "select p.id,p.title, p.thumbnail, p.discount_id,p.gender_id,p.category_id, d.value ,min(sp.price_out-sp.price_out*d.value/100) as price, min(sp.sid) as sid \n"
                + "                   from Products p  \n"
                + "                   join SizeProduct sp on p.id = sp.pid  \n"
                + "                   join Sizes s on s.id = sp.sid  \n"
                + "                   join Discounts d on d.id = p.discount_id  \n"
                + "                   group by p.id,p.title, p.thumbnail , p.discount_id, d.value,p.gender_id,p.category_id\n"
                + "				   order by price asc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setThumbnail(rs.getString("thumbnail"));
                Discount d = getDisCountById(rs.getInt("discount_id"));
                Gender g = getGenderById(rs.getInt("gender_id"));
                Category c = getCategoryById(rs.getInt("category_id"));
                SizeProduct sp = getSizeProduct(rs.getInt("id"), rs.getInt("sid"));
                p.setCategory(c);
                p.setDiscount(d);
                p.setSizeproduct(sp);
                p.setGender(g);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    //Sap xep cac san pham tieu bieu theo gia giam dan

    public List<Product> sortProductByPriceDesc() {
        List<Product> list = new ArrayList<>();
        String sql = "select p.id,p.title, p.thumbnail, p.discount_id,p.gender_id,p.category_id, d.value ,min(sp.price_out-sp.price_out*d.value/100) as price, min(sp.sid) as sid \n"
                + "                   from Products p  \n"
                + "                   join SizeProduct sp on p.id = sp.pid  \n"
                + "                   join Sizes s on s.id = sp.sid  \n"
                + "                   join Discounts d on d.id = p.discount_id  \n"
                + "                   group by p.id,p.title, p.thumbnail , p.discount_id, d.value,p.gender_id,p.category_id\n"
                + "				   order by price desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setThumbnail(rs.getString("thumbnail"));
                Discount d = getDisCountById(rs.getInt("discount_id"));
                Gender g = getGenderById(rs.getInt("gender_id"));
                Category c = getCategoryById(rs.getInt("category_id"));
                SizeProduct sp = getSizeProduct(rs.getInt("id"), rs.getInt("sid"));
                p.setCategory(c);
                p.setDiscount(d);
                p.setSizeproduct(sp);
                p.setGender(g);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> searchProductByPrice(int a, int b) {
        List<Product> list = new ArrayList<>();
        String sql = "select p.id,p.title, p.thumbnail, p.discount_id,p.gender_id,p.category_id, d.value ,min(sp.price_out-sp.price_out*d.value/100) as price, min(sp.sid) as sid \n"
                + "                   from Products p  \n"
                + "                   join SizeProduct sp on p.id = sp.pid  \n"
                + "                   join Sizes s on s.id = sp.sid  \n"
                + "                   join Discounts d on d.id = p.discount_id  \n"
                + "				   where (sp.price_out-sp.price_out*d.value) between ? and ?\n"
                + "                   group by p.id,p.title, p.thumbnail , p.discount_id, d.value,p.gender_id,p.category_id";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, a);
            st.setInt(2, b);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setThumbnail(rs.getString("thumbnail"));
                Discount d = getDisCountById(rs.getInt("discount_id"));
                Gender g = getGenderById(rs.getInt("gender_id"));
                Category c = getCategoryById(rs.getInt("category_id"));
                SizeProduct sp = getSizeProduct(rs.getInt("id"), rs.getInt("sid"));
                p.setCategory(c);
                p.setDiscount(d);
                p.setSizeproduct(sp);
                p.setGender(g);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // dem tat ca cac san pham tieu bieu 
    public int countAllProduct() {
        String sql = "select count(*)from (select p.id,p.title, p.thumbnail, p.discount_id,p.gender_id,p.category_id, d.value ,min(sp.price_out-sp.price_out*d.value/100) as price, min(sp.sid) as sid \n"
                + "                   from Products p  \n"
                + "                   join SizeProduct sp on p.id = sp.pid  \n"
                + "                   join Sizes s on s.id = sp.sid  \n"
                + "                   join Discounts d on d.id = p.discount_id  \n"
                + "                   group by p.id,p.title, p.thumbnail , p.discount_id, d.value,p.gender_id,p.category_id) as P";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {

        }
        return 0;
    }

    //-----------------------------------------------------------------------------------------------------------------------------------
    //phan trang cua tat ca cac san pham tieu bieu - moi trang lay ra 4 san pham
    public List<Product> getAllProductPresentationPaging(int pageIndex, int pageSize) {

        List<Product> list = new ArrayList<>();
        String sql = "select p.id,p.title, p.thumbnail, p.discount_id,p.gender_id,p.category_id, d.value ,min(sp.price_out-sp.price_out*d.value/100) as price, min(sp.sid) as sid \n"
                + "                   from Products p  \n"
                + "                   join SizeProduct sp on p.id = sp.pid  \n"
                + "                   join Sizes s on s.id = sp.sid  \n"
                + "                   join Discounts d on d.id = p.discount_id  \n"
                + "                   group by p.id,p.title, p.thumbnail , p.discount_id, d.value,p.gender_id,p.category_id\n"
                + "				   order by p.id\n"
                + "				   OFFSET (?-1)*? rows					\n"
                + "				   FETCH NEXT ? rows only ";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pageIndex);
            st.setInt(2, pageSize);
            st.setInt(3, pageSize);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setThumbnail(rs.getString("thumbnail"));
                Discount d = getDisCountById(rs.getInt("discount_id"));
                Gender g = getGenderById(rs.getInt("gender_id"));
                Category c = getCategoryById(rs.getInt("category_id"));
                SizeProduct sp = getSizeProduct(rs.getInt("id"), rs.getInt("sid"));
                p.setCategory(c);
                p.setDiscount(d);
                p.setSizeproduct(sp);
                p.setGender(g);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getAllProductPresentationPagingByCid(int cid, int pageIndex, int pageSize) { // lay tat ca san pham dai dien cho tung category
        List<Product> list = new ArrayList<>();
        String sql = "select p.id,p.title, p.thumbnail, p.discount_id,p.gender_id,p.category_id, d.value ,min(sp.price_out-sp.price_out*d.value/100) as price, min(sp.sid) as sid \n"
                + "                   from Products p  \n"
                + "                   join SizeProduct sp on p.id = sp.pid  \n"
                + "                   join Sizes s on s.id = sp.sid  \n"
                + "                   join Discounts d on d.id = p.discount_id  \n"
                + "                   group by p.id,p.title, p.thumbnail , p.discount_id, d.value,p.gender_id,p.category_id\n"
                + "				   having p.category_id= ?\n"
                + "				   order by p.id\n"
                + "				   OFFSET (?-1)*? rows					\n"
                + "				   FETCH NEXT ? rows only  ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cid);
            st.setInt(2, pageIndex);
            st.setInt(3, pageSize);
            st.setInt(4, pageSize);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setThumbnail(rs.getString("thumbnail"));
                Discount d = getDisCountById(rs.getInt("discount_id"));
                Gender g = getGenderById(rs.getInt("gender_id"));
                Category c = getCategoryById(rs.getInt("category_id"));
                SizeProduct sp = getSizeProduct(rs.getInt("id"), rs.getInt("sid"));
                p.setCategory(c);
                p.setDiscount(d);
                p.setSizeproduct(sp);
                p.setGender(g);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public int countAllProductByCid(int cid) { // lay tat ca san pham dai dien cho tung category

        String sql = "select count(*) from (select p.id,p.title, p.thumbnail, p.discount_id,p.gender_id,p.category_id, d.value ,min(sp.price_out-sp.price_out*d.value/100) as price, min(sp.sid) as sid \n"
                + "                   from Products p  \n"
                + "                   join SizeProduct sp on p.id = sp.pid  \n"
                + "                   join Sizes s on s.id = sp.sid  \n"
                + "                   join Discounts d on d.id = p.discount_id  \n"
                + "                   group by p.id,p.title, p.thumbnail , p.discount_id, d.value,p.gender_id,p.category_id\n"
                + "				   having p.category_id= ?\n"
                + " ) as p ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    // lay tat ca san pham dai dien cho tung gender
    public List<Product> getAllProductPresentationPagingByGenderId(int gid, int pageIndex, int pageSize) { // lay tat ca san pham dai dien cho tung category
        List<Product> list = new ArrayList<>();
        String sql = "select p.id,p.title, p.thumbnail, p.discount_id,p.gender_id,p.category_id, d.value ,min(sp.price_out-sp.price_out*d.value/100) as price, min(sp.sid) as sid \n"
                + "                   from Products p  \n"
                + "                   join SizeProduct sp on p.id = sp.pid  \n"
                + "                   join Sizes s on s.id = sp.sid  \n"
                + "                   join Discounts d on d.id = p.discount_id  \n"
                + "                   group by p.id,p.title, p.thumbnail , p.discount_id, d.value,p.gender_id,p.category_id\n"
                + "				   having p.gender_id= ?\n"
                + "				   order by p.id\n"
                + "				   OFFSET (?-1)*? rows					\n"
                + "				   FETCH NEXT ? rows only";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, gid);
            st.setInt(2, pageIndex);
            st.setInt(3, pageSize);
            st.setInt(4, pageSize);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setThumbnail(rs.getString("thumbnail"));
                Discount d = getDisCountById(rs.getInt("discount_id"));
                Gender g = getGenderById(rs.getInt("gender_id"));
                Category c = getCategoryById(rs.getInt("category_id"));
                SizeProduct sp = getSizeProduct(rs.getInt("id"), rs.getInt("sid"));
                p.setCategory(c);
                p.setDiscount(d);
                p.setSizeproduct(sp);
                p.setGender(g);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    // dem tat ca san pham dai dien cho tung gender

    public int countAllProductByGenderId(int gid) {
        String sql = "select count(*) from (select p.id,p.title, p.thumbnail, p.discount_id,p.gender_id,p.category_id, d.value ,min(sp.price_out-sp.price_out*d.value/100) as price, min(sp.sid) as sid \n"
                + "                   from Products p  \n"
                + "                   join SizeProduct sp on p.id = sp.pid  \n"
                + "                   join Sizes s on s.id = sp.sid  \n"
                + "                   join Discounts d on d.id = p.discount_id  \n"
                + "                   group by p.id,p.title, p.thumbnail , p.discount_id, d.value,p.gender_id,p.category_id\n"
                + "				   having p.gender_id= ?\n"
                + " ) as p ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, gid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    //dem tat ca cac san pham tim kiem dc
    public int countAllProductBySearchTitle(String txt) {
        String sql = "select count(*) from (select p.id,p.title, p.thumbnail, p.discount_id,p.gender_id,p.category_id, d.value ,min(sp.price_out-sp.price_out*d.value/100) as price, min(sp.sid) as sid \n"
                + "                   from Products p  \n"
                + "                   join SizeProduct sp on p.id = sp.pid  \n"
                + "                   join Sizes s on s.id = sp.sid  \n"
                + "                   join Discounts d on d.id = p.discount_id  \n"
                + "                   group by p.id,p.title, p.thumbnail , p.discount_id, d.value,p.gender_id,p.category_id\n"
                + "				   having p.title like ?\n"
                + " ) as p ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + txt + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    // lay tat ca san pham dai dien cho tung gender
    public List<Product> getAllProductPresentationPagingBySeachTitle(String txt, int pageIndex, int pageSize) { // lay tat ca san pham dai dien cho tung category
        List<Product> list = new ArrayList<>();
        String sql = "select p.id,p.title, p.thumbnail, p.discount_id,p.gender_id,p.category_id, d.value ,min(sp.price_out-sp.price_out*d.value/100) as price, min(sp.sid) as sid \n"
                + "                   from Products p  \n"
                + "                   join SizeProduct sp on p.id = sp.pid  \n"
                + "                   join Sizes s on s.id = sp.sid  \n"
                + "                   join Discounts d on d.id = p.discount_id  \n"
                + "                   group by p.id,p.title, p.thumbnail , p.discount_id, d.value,p.gender_id,p.category_id\n"
                + "				   having p.title like ?\n"
                + "				   order by p.id\n"
                + "				   OFFSET (?-1)*? rows					\n"
                + "				   FETCH NEXT ? rows only ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + txt + "%");
            st.setInt(2, pageIndex);
            st.setInt(3, pageSize);
            st.setInt(4, pageSize);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setThumbnail(rs.getString("thumbnail"));
                Discount d = getDisCountById(rs.getInt("discount_id"));
                Gender g = getGenderById(rs.getInt("gender_id"));
                Category c = getCategoryById(rs.getInt("category_id"));
                SizeProduct sp = getSizeProduct(rs.getInt("id"), rs.getInt("sid"));
                p.setCategory(c);
                p.setDiscount(d);
                p.setSizeproduct(sp);
                p.setGender(g);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //phan trang cac san pham theo sap xep tang dan theo gia
    public List<Product> getAllProductPresentationPagingBySortAscPrice(int pageIndex, int pageSize) {
        List<Product> list = new ArrayList<>();
        String sql = "select p.id,p.title, p.thumbnail, p.discount_id,p.gender_id,p.category_id, d.value ,min(sp.price_out-sp.price_out*d.value/100) as price, min(sp.sid) as sid \n"
                + "                   from Products p  \n"
                + "                   join SizeProduct sp on p.id = sp.pid  \n"
                + "                   join Sizes s on s.id = sp.sid  \n"
                + "                   join Discounts d on d.id = p.discount_id  \n"
                + "                   group by p.id,p.title, p.thumbnail , p.discount_id, d.value,p.gender_id,p.category_id\n"
                + "				   order by price asc\n"
                + "				   OFFSET (?-1)*? rows					\n"
                + "				   FETCH NEXT ? rows only ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pageIndex);
            st.setInt(2, pageSize);
            st.setInt(3, pageSize);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setThumbnail(rs.getString("thumbnail"));
                Discount d = getDisCountById(rs.getInt("discount_id"));
                Gender g = getGenderById(rs.getInt("gender_id"));
                Category c = getCategoryById(rs.getInt("category_id"));
                SizeProduct sp = getSizeProduct(rs.getInt("id"), rs.getInt("sid"));
                p.setCategory(c);
                p.setDiscount(d);
                p.setSizeproduct(sp);
                p.setGender(g);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //phan trang cac san pham theo sap xep giam dan theo gia
    public List<Product> getAllProductPresentationPagingBySortDescPrice(int pageIndex, int pageSize) { // lay tat ca san pham dai dien cho tung category
        List<Product> list = new ArrayList<>();
        String sql = "select p.id,p.title, p.thumbnail, p.discount_id,p.gender_id,p.category_id, d.value ,min(sp.price_out-sp.price_out*d.value/100) as price, min(sp.sid) as sid \n"
                + "                   from Products p  \n"
                + "                   join SizeProduct sp on p.id = sp.pid  \n"
                + "                   join Sizes s on s.id = sp.sid  \n"
                + "                   join Discounts d on d.id = p.discount_id  \n"
                + "                   group by p.id,p.title, p.thumbnail , p.discount_id, d.value,p.gender_id,p.category_id\n"
                + "				   order by price desc\n"
                + "				   OFFSET (?-1)*? rows					\n"
                + "				   FETCH NEXT ? rows only ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pageIndex);
            st.setInt(2, pageSize);
            st.setInt(3, pageSize);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setThumbnail(rs.getString("thumbnail"));
                Discount d = getDisCountById(rs.getInt("discount_id"));
                Gender g = getGenderById(rs.getInt("gender_id"));
                Category c = getCategoryById(rs.getInt("category_id"));
                SizeProduct sp = getSizeProduct(rs.getInt("id"), rs.getInt("sid"));
                p.setCategory(c);
                p.setDiscount(d);
                p.setSizeproduct(sp);
                p.setGender(g);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    //phan trang cac san pham theo sap xep giam dan theo gia
    public List<Product> getAllProductPresentationPagingByNewID(int pageIndex, int pageSize) { 
        List<Product> list = new ArrayList<>();
        String sql = "select p.id,p.title, p.thumbnail, p.discount_id,p.gender_id,p.category_id, d.value ,min(sp.price_out-sp.price_out*d.value/100) as price, min(sp.sid) as sid \n" +
"                                from Products p \n" +
"                                 join SizeProduct sp on p.id = sp.pid \n" +
"                                 join Sizes s on s.id = sp.sid \n" +
"                                  join Discounts d on d.id = p.discount_id \n" +
"                                   group by p.id,p.title, p.thumbnail , p.discount_id, d.value,p.gender_id,p.category_id\n" +
"              				   order by p.id desc\n" +
"            			   OFFSET (?-1)*? rows				\n" +
"             		   FETCH NEXT ? rows only ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pageIndex);
            st.setInt(2, pageSize);
            st.setInt(3, pageSize);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setThumbnail(rs.getString("thumbnail"));
                Discount d = getDisCountById(rs.getInt("discount_id"));
                Gender g = getGenderById(rs.getInt("gender_id"));
                Category c = getCategoryById(rs.getInt("category_id"));
                SizeProduct sp = getSizeProduct(rs.getInt("id"), rs.getInt("sid"));
                p.setCategory(c);
                p.setDiscount(d);
                p.setSizeproduct(sp);
                p.setGender(g);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
     public List<Product> getAllProductPresentationPagingByDiscountDes(int pageIndex, int pageSize) { 
        List<Product> list = new ArrayList<>();
        String sql = "select p.id,p.title, p.thumbnail, p.discount_id,p.gender_id,p.category_id, d.value ,min(sp.price_out-sp.price_out*d.value/100) as price, min(sp.sid) as sid \n" +
"                                from Products p \n" +
"                                 join SizeProduct sp on p.id = sp.pid \n" +
"                                 join Sizes s on s.id = sp.sid \n" +
"                                 join Discounts d on d.id = p.discount_id \n" +
"                                 group by p.id,p.title, p.thumbnail , p.discount_id, d.value,p.gender_id,p.category_id\n" +
"              				   order by d.value desc\n" +
"							   OFFSET (?-1)*? rows				\n" +
"             		        FETCH NEXT ? rows only ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pageIndex);
            st.setInt(2, pageSize);
            st.setInt(3, pageSize);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setThumbnail(rs.getString("thumbnail"));
                Discount d = getDisCountById(rs.getInt("discount_id"));
                Gender g = getGenderById(rs.getInt("gender_id"));
                Category c = getCategoryById(rs.getInt("category_id"));
                SizeProduct sp = getSizeProduct(rs.getInt("id"), rs.getInt("sid"));
                p.setCategory(c);
                p.setDiscount(d);
                p.setSizeproduct(sp);
                p.setGender(g);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //phan trang cac san pham theo gia nhap vao tu bn den bao nhieu
    public List<Product> getAllProductPresentationPagingBySearchPrice(int fromValue, int toValue, int pageIndex, int pageSize) { // lay tat ca san pham dai dien cho tung category
        List<Product> list = new ArrayList<>();
        String sql = " select * from (select p.id,p.title, p.thumbnail, p.discount_id,p.gender_id,p.category_id, d.value ,min(sp.price_out-sp.price_out*d.value/100) as price, min(sp.sid) as sid\n"
                + " from Products p  join SizeProduct sp on p.id = sp.pid \n"
                + "                  join Sizes s on s.id = sp.sid  \n"
                + "                  join Discounts d on d.id = p.discount_id\n"
                + " group by p.id,p.title, p.thumbnail , p.discount_id, d.value,p.gender_id,p.category_id) as t\n"
                + "where t.price between ? and ?\n"
                + "order by t.price \n"
                + " OFFSET (?-1)*? rows					\n"
                + "FETCH NEXT ? rows only";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, fromValue);
            st.setInt(2, toValue);
            st.setInt(3, pageIndex);
            st.setInt(4, pageSize);
            st.setInt(5, pageSize);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setThumbnail(rs.getString("thumbnail"));
                Discount d = getDisCountById(rs.getInt("discount_id"));
                Gender g = getGenderById(rs.getInt("gender_id"));
                Category c = getCategoryById(rs.getInt("category_id"));
                SizeProduct sp = getSizeProduct(rs.getInt("id"), rs.getInt("sid"));
                p.setCategory(c);
                p.setDiscount(d);
                p.setSizeproduct(sp);
                p.setGender(g);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //dem tat ca cac san pham tim kiem dc theo gia tu bao nhieu den bao nhieu 
    public int countAllProductBySearchPrice(int x, int y) {
        String sql = " select count(*) from (select p.id,p.title, p.thumbnail, p.discount_id,p.gender_id,p.category_id, d.value ,min(sp.price_out-sp.price_out*d.value/100) as price, min(sp.sid) as sid\n"
                + " from Products p  join SizeProduct sp on p.id = sp.pid \n"
                + "                  join Sizes s on s.id = sp.sid  \n"
                + "                  join Discounts d on d.id = p.discount_id\n"
                + " group by p.id,p.title, p.thumbnail , p.discount_id, d.value,p.gender_id,p.category_id) as t\n"
                + "where t.price between ? and ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, x);
            st.setInt(2, y);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    //phan trang cac san pham theo sap xep giam dan theo gia
    public List<Product> getAllProductPresentationPagingBySortAZ(int pageIndex, int pageSize) { // lay tat ca san pham dai dien cho tung category
        List<Product> list = new ArrayList<>();
        String sql = "select p.id,p.title, p.thumbnail, p.discount_id,p.gender_id,p.category_id, d.value ,min(sp.price_out-sp.price_out*d.value/100) as price, min(sp.sid) as sid \n"
                + "                   from Products p  \n"
                + "                   join SizeProduct sp on p.id = sp.pid  \n"
                + "                   join Sizes s on s.id = sp.sid  \n"
                + "                   join Discounts d on d.id = p.discount_id  \n"
                + "                   group by p.id,p.title, p.thumbnail , p.discount_id, d.value,p.gender_id,p.category_id\n"
                + "				   order by p.title asc\n"
                + "				   OFFSET (?-1)*? rows					\n"
                + "				   FETCH NEXT ? rows only";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pageIndex);
            st.setInt(2, pageSize);
            st.setInt(3, pageSize);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setThumbnail(rs.getString("thumbnail"));
                Discount d = getDisCountById(rs.getInt("discount_id"));
                Gender g = getGenderById(rs.getInt("gender_id"));
                Category c = getCategoryById(rs.getInt("category_id"));
                SizeProduct sp = getSizeProduct(rs.getInt("id"), rs.getInt("sid"));
                p.setCategory(c);
                p.setDiscount(d);
                p.setSizeproduct(sp);
                p.setGender(g);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    //phan trang cac san pham theo sap xep giam dan theo gia

    public List<Product> getAllProductPresentationPagingBySortZA(int pageIndex, int pageSize) { // lay tat ca san pham dai dien cho tung category
        List<Product> list = new ArrayList<>();
        String sql = "select p.id,p.title, p.thumbnail, p.discount_id,p.gender_id,p.category_id, d.value ,min(sp.price_out-sp.price_out*d.value/100) as price, min(sp.sid) as sid \n"
                + "                   from Products p  \n"
                + "                   join SizeProduct sp on p.id = sp.pid  \n"
                + "                   join Sizes s on s.id = sp.sid  \n"
                + "                   join Discounts d on d.id = p.discount_id  \n"
                + "                   group by p.id,p.title, p.thumbnail , p.discount_id, d.value,p.gender_id,p.category_id\n"
                + "				   order by p.title desc\n"
                + "				   OFFSET (?-1)*? rows					\n"
                + "				   FETCH NEXT ? rows only";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pageIndex);
            st.setInt(2, pageSize);
            st.setInt(3, pageSize);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setThumbnail(rs.getString("thumbnail"));
                Discount d = getDisCountById(rs.getInt("discount_id"));
                Gender g = getGenderById(rs.getInt("gender_id"));
                Category c = getCategoryById(rs.getInt("category_id"));
                SizeProduct sp = getSizeProduct(rs.getInt("id"), rs.getInt("sid"));
                p.setCategory(c);
                p.setDiscount(d);
                p.setSizeproduct(sp);
                p.setGender(g);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
        ShopDAO sd = new ShopDAO();
//        List<Category> listC = sd.getAllCategory();
//         for (Category o : listC) {
//             System.out.println(o.getId() +" "+o.getName());
//         }

//            Category c1 = sd.getCategoryById(1);
//            System.out.println(c1.getId() + " " +c1.getName());
//        List<Product> listP = sd.getAllProductPresentation();
//        int cnt = 0;
//        for (Product o : listP) {
//            System.out.println(o.getId() + " " + o.getTitle() + o.getSizeProduct().getPrice_out());
//            cnt++;
//        }
//        System.out.println(cnt);
//        int cnt = 0;
//        List<Product> listSearch = sd.searchProductByTitle("12");
//        for (Product o : listSearch) {
//            System.out.println(o.getTitle() + " " + o.getSizeproduct().getPrice_out() + " " + o.getDiscount().getValue());
//            cnt++;
//        }
//        System.out.println(cnt);
//
//        int cnt = 0;
//        List<Product> listP = sd.getAllProductPresentationPaging(2, 4);
//        for (Product o : listP) {
//            System.out.println(o.getId() + " " + o.getTitle() + " " + o.getSizeproduct().getPrice_out());
//            cnt++;
//        }
//        System.out.println(cnt);
//        int cnt = 0;
//        List<Product> listSearch = sd.searchProductByGender(1);
//        for (Product o : listSearch) {
//            System.out.println(o.getTitle() + " " + o.getSizeProduct().getPrice_out());
//            cnt++;
//        }
//        System.out.println(cnt);
//        int cnt = 0;
//        List<Product> listSort = sd.sortProductByZA();
//        for (Product o : listSort) {
//            System.out.println(o.getTitle() + " " + o.getSizeproduct().getPrice_out());
//            cnt++;
//        }
//        System.out.println(cnt);
//        int cnt = 0;
//        List<Product> listP = sd.getAllProductPresentationByCid(1);
//        for (Product o : listP) {
//            System.out.println(o.getId() + " " + o.getTitle() + " " + o.getSizeproduct().getPrice_out());
//            cnt++;
//        }
//        System.out.println(cnt);
//        int cnt = 0;
//        List<Product> listP = sd.sortProductByPriceDesc();
//        for (Product o : listP) {
//            System.out.println(o.getId() + " " + o.getTitle() + " " + o.getSizeproduct().getPrice_out());
//            cnt++;
//        }
//        System.out.println(cnt);
        int cnt = 0;
        List<Product> listP = sd.getAllProductPresentationPagingBySortZA(1, 20);
        for (Product o : listP) {
            System.out.println(o.getId() + " " + o.getTitle() + " " + o.getSizeproduct().getPrice_out());
            cnt++;
        }
        System.out.println(cnt);

    }
}
