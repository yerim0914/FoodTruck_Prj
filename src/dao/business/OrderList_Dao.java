package dao.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.client.StampListDao;
import util.JDBCUtil;
import vo.business.OrderListVO;

public class OrderList_Dao {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	StampListDao dao = new StampListDao();

	public List<OrderListVO> getOrderList(String business_id) { // 주문목록보기
		OrderListVO order = null;
		List<OrderListVO> list = new ArrayList<>();
		String sql = "select orders_num, client_id, menu_name, orders_count, salable"
				+ " from business_info b, menu m, orders o "
				+ "where b.business_id = m.business_id and m.menu_id = o.menu_id and b.business_id = ?";
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, business_id);
			rs = ps.executeQuery();
			while(rs.next()){
				order = new OrderListVO(rs.getString("orders_num"), null, rs.getString("client_id"), 
						rs.getString("menu_name"), null, null,
						rs.getInt("orders_count"), rs.getString("salable")); // 인자				
				list.add(order);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}

		return list;
	}

	public void soldoutIs(String orders_num, String ischeck) { // 판매 완료 선택하면
		String sql = "update orders set salable = ? where orders_num = ?";

		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ischeck);
			ps.setString(2, orders_num);
			ps.executeUpdate();
			ps.close();
			if (ischeck.equals("Y")) { // 판매 완료 Y 들어오면

				sql = "select s.stamp_id,sl.st_list_id,o.client_id,o.orders_count,sl.stamp_pre,s.stp_target "
						+ "from stamp s, stamp_list sl, orders o "
						+ "  where s.stamp_id=sl.stamp_id(+) and s.business_id(+)=o.business_id"
						+ " and o.orders_num=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, orders_num);
				rs = ps.executeQuery();

				while (rs.next()) {
					// System.out.println(rs.getString("stamp_id")+"확인");
					if (rs.getString("stamp_id") != null) {
						if (rs.getString("st_list_id") == null) {
														
							int cnt = rs.getInt("orders_count");
							int cmp=0;
							while((rs.getInt("stp_target")<=cnt)){
								cnt=cnt-rs.getInt("stp_target");
								cmp++;
							}							
							dao.addStamp(rs.getString("stamp_id"),rs.getString("client_id"),cnt,cmp);
							
						} else {
							
							int cnt = rs.getInt("orders_count")+rs.getInt("stamp_pre");
							int cmp=0;
							while((rs.getInt("stp_target")<=cnt)){
								cnt=cnt-rs.getInt("stp_target");
								cmp++;								
							}

							dao.upStamp(rs.getString("st_list_id"), cnt,cmp);
						}
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void orderCancel(String orders_num, String cancel_cause) { // 주문취소
		String sql = "insert into cancle values (cancel_sq.nextval, ?, ?, sysdate)";
		String sql2 = "delete from orders where orders_num = ?";
		String sql3 = "delete from payment where orders_num = ?";
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, orders_num);
			ps.setString(2, cancel_cause);
			ps.executeUpdate();
			ps.close();

			ps = con.prepareStatement(sql2);
			ps.setString(1, orders_num);
			ps.executeUpdate();
			ps.close();

			ps = con.prepareStatement(sql3);
			ps.setString(1, orders_num);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
