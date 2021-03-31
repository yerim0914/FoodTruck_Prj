package dao.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.JDBCUtil;
import vo.client.StampVO;

public class StampDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public StampVO getStamp(String business_id){
		StampVO stamp = null;
		String sql = "select * from stamp where business_id = ?";
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, business_id);
			rs = ps.executeQuery();
			if(rs.isAfterLast()){
				stamp = new StampVO(rs.getString("stamp_id"), rs.getString("stamp_name"), 
						rs.getString("business_id"), rs.getInt("stp_targer"), rs.getString("menu_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stamp;
	}
	public void insertStamp(StampVO vo){
		String sql = "insert into business_info values (stamp_sq.nextval, ?, ?, ?, ?)";
		con = JDBCUtil.getConnection();

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getStamp_name()); // 스탬프 이름
			ps.setString(2, vo.getBusiness_id()); // 사업자 id
			ps.setInt(3, vo.getStp_target()); // 목표 개수
			ps.setString(4, vo.getMenu_id()); // 제공 메뉴
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
		
	}
	public void updateStamp(StampVO vo){
		String sql = "update stamp set stamp_name = ? and stp_targer = ? and menu_id = ? "
				+ "where stamp_id = ?";
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getStamp_name());
			ps.setInt(2, vo.getStp_target());
			ps.setString(3, vo.getMenu_id());
			ps.setString(4, vo.getStamp_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void SubStamp(String st_list_id){ // 사장이 개인 고객의 사용완료된 쿠폰 cmp_num = -1
		String sql = "update stamp_list set cmp_num = cmp_num - 1 where st_list_id = ?";
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, st_list_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
