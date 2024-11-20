/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.CartDAO;
import dal.ProductDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Cart {

    List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public int getQuantity(int pid, int sid) {
        return getItem(pid, sid).getQuantity();
    }

    private Item getItem(int pid, int sid) {
        for (Item i : items) {
            if (i.getProduct().getId() == pid && i.getSize().getId() == sid) {
                return i;
            }
        }
        return null;
    }

    public void addItem(Item t) {
        Item m = getItem(t.getProduct().getId(), t.getSize().getId());
        if (m != null) {
            m.setQuantity(m.getQuantity() + t.getQuantity());
        } else {
            items.add(t);
        }
    }

    public void removeItem(int pid, int sid) {
        Item i = getItem(pid, sid);
        if (i != null) {
            items.remove(i);
        }
    }

    public int getTotalMoney(List<Discount> ld) {
        int t = 0;
        for (Item i : items) {
            for(Discount d:ld){
                
            if(d.getId()==i.getProduct().getDiscount_id()){
                t += (i.getQuantity() * (i.getPrice()-i.getPrice()*d.getValue()/100));
            }
            }
        }
        return t;
    }
    
    public double getExactItemMoneyOut(Item i,List<Discount> ld){
         double t=0;
         for(Discount d:ld){
             if(d.getId()==i.getProduct().getDiscount_id()){
                t=(i.getPrice()-i.getPrice()*d.getValue()/100);
             }
         
         }
        return t;
    }
    
 

    public Cart(String txt, User user) {
        items = new ArrayList();
        CartDAO d = new CartDAO();
        ProductDAO dao = new ProductDAO();
        try {
            if (txt != null && txt.length() != 0) {
                String[] s = txt.split("/");
                for (String i : s) {
                    String[] n = i.split(":");
                    int uid = Integer.parseInt(n[0]);
                    int pid = Integer.parseInt(n[1]);
                    int sid = Integer.parseInt(n[2]);
                    int quantity = Integer.parseInt(n[3]);
                    Product p = d.getProductsById(pid);
                    Size size = d.getSizeByID(sid);
                    SizeProduct sizeproduct = dao.getSizeProductByPidSid(pid, sid);
                    if (user != null) {
                        if (uid == 0 || uid == user.getId()) {
                            addItem(new Item(sizeproduct, p, size, quantity, sizeproduct.getPrice_out()));
                        }
                    } else {
                        if (uid == 0) {
                            addItem(new Item(sizeproduct, p, size, quantity, sizeproduct.getPrice_out()));
                        }
                    }
                }
            }
        } catch (Exception e) {

        }

    }

}
