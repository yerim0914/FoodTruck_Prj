package dao.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.client.BookMarkVO;

public class BookMarkDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public void insertBookMark(String client_id, String business_id, boolean ischeck) { // 즐겨찾기 등록 & 해제
		String sql  = "insert into bookmark values (bookmar_id.nextval, ?, ?)";
		String sql2 = "delete from bookmark where client_id = ? and business_id = ?";
		con = JDBCUtil.getConnection();

		try {
			if(ischeck == true)
				ps = con.prepareStatement(sql);
			else
				ps = con.prepareStatement(sql2);
			ps.setString(1, client_id); // 회원ID
			ps.setString(2, business_id); // 사업자 등록번호
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
	}
	public List<BookMarkVO> getBoormarkList(String client_id){
		BookMarkVO bookmark = null;
		List<BookMarkVO> list = new ArrayList<>();
		String sql = "select business_name from business_info where client_id = ?";
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, client_id);
			rs = ps.executeQuery();
			while (rs.next()){
				bookmark = new BookMarkVO(client_id, rs.getString("business_id")); // 인자 넣어야함
				list.add(bookmark);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
		
		return list;
	}
	
	
}
