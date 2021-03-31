package dao.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.client.Stamp_ListVO;

public class StampListDao {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public List<Stamp_ListVO> getAllStamp(String client_id){ // 고객이 가진 전체 가게 스탬프들
		Stamp_ListVO stamp = null;
		List<Stamp_ListVO> list = new ArrayList<>();
		String sql = "select * from stamp where client_id = ?";
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, client_id);
			rs = ps.executeQuery();
			while(rs.next()){
				stamp = new Stamp_ListVO(rs.getString("st_list_id"), rs.getString("stamp_id"), 
						rs.getString("orders_num"), rs.getString("client_id"), rs.getInt("stamp_pre"),
						rs.getString("cmp_num"));
				list.add(stamp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public String CheckStamp(String sql, String set, String get){
		String a = null;
		try {
			ps.close();
			ps = con.prepareStatement(sql);
			ps.setString(1, set);
			rs = ps.executeQuery();
			while(rs.next()){
				a = rs.getString(get);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
		
		}
		return a;
	}
	public void addStamp(String stamp_id, String client_id, int orders_count,int cmp_num){ // 스탬프 ++
		String sql  = "insert into stamp_list values(stamp_list_sq.nextval,?,?,?,?)";
		// 처음 인설트		
		con = JDBCUtil.getConnection();
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1, stamp_id);
				ps.setString(2, client_id);
				ps.setInt(3, orders_count);
				ps.setInt(4, cmp_num);				
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
	public void upStamp(String st_list_id,int stamp_pre,int cmp_num){ // 스탬프 ++
		String sql  = "update stamp_list set stamp_pre=?, cmp_num=cmp_num+? where st_list_id=?";
		// 업뎃
		con = JDBCUtil.getConnection();	
			try {
				ps=con.prepareStatement(sql);
				ps.setInt(1, stamp_pre);
				ps.setInt(2, cmp_num);				
				ps.setString(3, st_list_id);				
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}	
	
	
}
