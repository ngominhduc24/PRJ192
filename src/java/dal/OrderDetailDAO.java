/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.OrderDetail;

/**
 *
 * @author ASUS PC
 */
public class OrderDetailDAO {
    public void insertOrderDetail(OrderDetail orderDetail) {
        String sql = "INSERT INTO OrderDetail VALUES(?,?,?)"; // (orderID, productID, quantity)
        try {
            PreparedStatement ps = DbContext.getConnection().prepareStatement(sql);
            ps.setInt(1, orderDetail.getOrderID());
            ps.setInt(2, orderDetail.getProductID());
            ps.setInt(3, orderDetail.getQuantity());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public List<OrderDetail> getListOrderDetailByOrderID(int orderID) {
        String sql = "SELECT * FROM OrderDetail WHERE orderID = ?";
        try {
            PreparedStatement ps = DbContext.getConnection().prepareStatement(sql);
            ps.setInt(1, orderID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderID(rs.getInt("orderID"));
                orderDetail.setProductID(rs.getInt("productID"));
                orderDetail.setQuantity(rs.getInt("quantity"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
}
