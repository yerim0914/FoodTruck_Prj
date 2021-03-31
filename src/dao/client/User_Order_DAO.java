package dao.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.business.OrderListVO;
import vo.client.PaymentVO;

public class User_Order_DAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public List<OrderListVO> getOrderList(String client_id){ // 개인 주문내역
		OrderListVO order = null;
		List<OrderListVO> list = new ArrayList<>(); 
		String sql = "select * from orders o, business_info b, menu m, coupon_id c "
				+ "where o.business_id = b.business_id and o.menu_id = m.menu_id and o.coupon_id = c.coupon_id "
				+ "and client_id = ?"; 
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, client_id);
			rs = ps.executeQuery();
			
			while (rs.next()){
				order = new OrderListVO(rs.getString("orders_num"), rs.getString("business_id"), 
						rs.getString("client_id"), rs.getString("menu_id"), rs.getString("coupon_id"), 
						rs.getDate("orders_date"), rs.getInt("orders_count"), rs.getString("salable")); // 인자 넣어야함
				list.add(order);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
		
		return list;
	}
	public void insertOrderList(OrderListVO vo){ // 주문 
		String sql = "insert into orders values(orders_sq.nextval, ?,?,?,?,sysdate,?,'N')";
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getBusiness_id());
			ps.setString(2, vo.getClient_id()); 
			ps.setString(3, vo.getMenu_id()); 
			ps.setString(4, vo.getCoupon_id());
			ps.setInt(5, vo.getOrders_count());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
	}
	public PaymentVO getPayment(String orders_num){ // 결제정보 가져오기
		PaymentVO payment = null;
		String sql = "select * from payment where orders_num = ?";
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, orders_num);
			rs = ps.executeQuery();
			
			payment = new PaymentVO(rs.getString(""), rs.getString(""), rs.getString(""),
					rs.getString(""));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return payment;
	}
	public void insertPayment(PaymentVO vo){ // 결제 요청
		String sql = "insert into orders values(payment_sq.nextval, ?, ?, 'N')";
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getOrders_num());
			ps.setString(2, vo.getPayment_type());  

			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
	}
	
	public void DecidePayment(String payment_num){ // 결제 확정해주는 메소드
		String sql = "update payment set payment_check = 'Y' where payment_num = ?";
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, payment_num);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
