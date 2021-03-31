package dao.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.business.MenuVO;

public class Menu_Dao {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public List<MenuVO> Menu_List(String business_id){ // 메뉴목록
		MenuVO menu = null;
		List<MenuVO> list = new ArrayList<>();
		String sql = "select * from menu where business_id = ? and menu_check = 'Y'"; 
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, business_id);
			rs = ps.executeQuery();
			while (rs.next()){
				menu = new MenuVO(rs.getString("menu_id"), business_id,
						rs.getString("menu_name"), rs.getInt("menu_price"), rs.getString("menu_desc"),
						rs.getString("recommend")); // 인자 넣어야함
				System.out.println("테스트:"+rs.getString("recommend"));
				list.add(menu);
				//System.out.println(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
		
		return list;
	}
	public void Menu_Insert(MenuVO vo){ // 메뉴 등록
		String sql = "insert into menu values (menu_id.nextval, ?, ?, ?, ?, 'N', 'Y')";
		con = JDBCUtil.getConnection();

		try {
			ps = con.prepareStatement(sql); 
			ps.setString(1, vo.getBusiness_id());
			ps.setString(2, vo.getMenu_name()); 
			ps.setInt(3, vo.getMenu_price()); 
			ps.setString(4, vo.getMenu_desc());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
	}

	public void Menu_Delete(String menu_id){ // 일단 삭제기능
		String sql = "update menu set menu_check = 'N' where menu_id = ?";  // update
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, menu_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void Menu_Recommend(String menu_id, String ischeck){ // 추천메뉴 기능
		String sql2 = "select menu_id from menu where menu_id = ?";
		String sql = "update menu set recommend = ? where menu_id = ?";  // where menu_id = ? 인거 Y로 바꾸기 
		con = JDBCUtil.getConnection();
		String Menuid = null;
		try {
			ps = con.prepareStatement(sql2);
			ps.setString(1, menu_id);
			rs = ps.executeQuery();
			while(rs.next()){
			Menuid = rs.getString("menu_id");
			}
			
			if(Menuid != null)
			{
			ps.close();
			ps = con.prepareStatement(sql);
			if(ischeck.equals("Y")){
				ps.setString(1, "Y");
			} else
				ps.setString(1, "N");
			ps.setString(2, menu_id);
			ps.executeUpdate();
			}
			else{
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
