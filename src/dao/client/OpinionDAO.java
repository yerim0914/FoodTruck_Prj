package dao.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.client.OpinionVO;

public class OpinionDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public OpinionVO getOpinion(String business_id, String client_id){
		OpinionVO opinion = null;
		String sql = "select write_date, opinion_text, score from opinion o, business_info b, client_info c "
				+ "where o.business_id = b.business_id and o.client_id = c.client_id";
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.isAfterLast()){
			opinion = new OpinionVO(rs.getString("opinion_id"), business_id, client_id, rs.getDate("write_date"), 
					rs.getString("opinion_text"), rs.getInt("score"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return opinion;
	}
	public List<OpinionVO> getAllListOpinion(String business_id){
		OpinionVO opinion = null;
		List<OpinionVO> list = new ArrayList<>();
		String sql = "select client_id, write_date, opinion_text, score from opinion o, business_info b "
				+ "where b.business_id = o.business_id and b.business_id = ?"; 
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, business_id);
			rs = ps.executeQuery();
			while (rs.next()){
				opinion = new OpinionVO(null, null,
						rs.getString("client_id"), rs.getDate("write_date"), rs.getString("opinion_text"),
						rs.getDouble("score")); 
				list.add(opinion);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
		return list;
	}
	public void insertOpinion(String business_id, String client_id, String opinion_text, double score) {
		String sql = " insert into opinion values(opinion.nextval, ?, ?, sysdate, ?, ?)";
		con = JDBCUtil.getConnection();

		try {
			ps = con.prepareStatement(sql); 
			ps.setString(1, business_id);
			ps.setString(2, client_id); 
			ps.setString(3, opinion_text); 
			ps.setDouble(4, score);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
	}

	public void updateOpinion(String opinion_id, String opinion_text, double score) {
		String sql = "update opinion set write_date = sysdate, opinion_text = ?, score = ? where opnion_id = ?";
		con = JDBCUtil.getConnection();
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, opinion_text);
			ps.setDouble(2, score);
			ps.setString(3, opinion_id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteOpinion(String opinion_id) {
		String sql = "delete from opinion_id where opinion_id = ?";
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, opinion_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
