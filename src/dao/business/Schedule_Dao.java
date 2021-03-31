package dao.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.business.ScheduleVO;

public class Schedule_Dao {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public List<ScheduleVO> Schedule_List(String business_id){ // 자신의 저장된 전체스케줄
		ScheduleVO schedule = null;
		List<ScheduleVO> list = new ArrayList<>();
		String sql = "select business_day, business_addr, business_hour "
				+ " from schedule s where business_id = ?"; 
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, business_id);
			rs = ps.executeQuery();
			
			while (rs.next()){
				schedule = new ScheduleVO(null, null,
						rs.getString("business_day"), rs.getString("business_addr"), 
						rs.getString("business_hour")); // 인자 넣어야함
				list.add(schedule);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
		
		return list;
	}
	public void Schedule_Insert(ScheduleVO vo){ // 스케줄 등록
		String sql = "insert into schedule values (schedule_sq.nextval, ?, ?, ?, ?)";
		String sql2 = "select schedule_id from schedule "
				+ "where business_id = ? and business_day = ?";
		String sql3 = "update schedule set business_addr = ?, business_hour = ? "
				+ "where schedule_id = ?"; //

		//main에서 요일, 사업자번호 넣어줘야함
		con = JDBCUtil.getConnection();
		String schedule = null;
		try {
			ps = con.prepareStatement(sql2);
			ps.setString(1, vo.getBusiness_id());
			ps.setString(2, vo.getBusiness_day());
			rs = ps.executeQuery();
			while(rs.next()){
			schedule = rs.getString("schedule_id");
			//System.out.println(schedule);
			}
			if(schedule == null){ // 없으면
				ps.close();
				ps = con.prepareStatement(sql);
				ps.setString(1, vo.getBusiness_id());
				ps.setString(2, vo.getBusiness_day()); 
				ps.setString(3, vo.getBusiness_addr());
				ps.setString(4, vo.getBusiness_hour());
				ps.executeUpdate();
			} else { // 있으면 
				ps.close();
				ps = con.prepareStatement(sql3);
				ps.setString(1, vo.getBusiness_addr()); 
				ps.setString(2, vo.getBusiness_hour());
				ps.setString(3, schedule);
				ps.executeUpdate();
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
	}
	/*
	public void Schedule_Modify(String business_id, String schedule_id, String business_day, 
			String business_addr, String business_hour){ // 스케줄 수정
		String sql = "update business_info set business_addr = ?, business_hour = ? "
				+ "where business_id = ? and schedule_id = ?"; // schedule_id 또는 business_day
		con = JDBCUtil.getConnection();
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, business_addr);
			ps.setString(2, business_hour);

			ps.setString(3, business_id);
			ps.setString(4, schedule_id);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	 */
}
