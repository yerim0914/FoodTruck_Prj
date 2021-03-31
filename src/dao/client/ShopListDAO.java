package dao.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.client.ShopListVO;

public class ShopListDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	ShopListVO shoplist = null;
	List<ShopListVO> list1 = new ArrayList<>();
	List<String> list = new ArrayList<>();
	public List<ShopListVO> ShopList(String business_code){ 
		String sql = "select * from business_info where business_code=? "; 
		con = JDBCUtil.getConnection();
		int i=0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, business_code);
			System.out.println("비지니스코드 :"+business_code);
			rs = ps.executeQuery();
			System.out.println("여기왓나");
			while (rs.next()){
				
				shoplist = new ShopListVO(rs.getString("business_id"), rs.getString("business_name"), 
						rs.getString("owner_name"), rs.getString("owner_phone"), rs.getString("business_code"));
				
				list.add(i++,shoplist.getBusiness_name());
				System.out.println();

				
				
				
				list1.add(shoplist);
			}
			
			System.out.println("여기왓나");
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
		return list1;
	}
	public List<ShopListVO> BookMarkShopList(String business_code){ // 즐겨찾기순 목록
		String sql = "select b.business_id, b.business_name, nvl(a, 0) 즐겨찾기 from business_info b, "
				+ "(select bi.business_id, count(b.business_id) a from bookmark b, business_info bi "
				+ "where b.business_id(+) = bi.business_id group by bi.business_id) b2 "
				+ "where b.business_id = b2.business_id(+) and business_code = ? order by a desc"; 
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, business_code);
			rs = ps.executeQuery();
			while (rs.next()){
				shoplist = new ShopListVO(rs.getString("business_id"), rs.getString("business_name"), 
						rs.getString("owner_name"), rs.getString("owner_phone"), rs.getString("business_code"));
				list1.add(shoplist);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
		return list1;
	}
	public List<ShopListVO> OrdersShopList(String business_code){ // 주문순 목록
		String sql = "select b.business_id, b.business_name, nvl(a, 0) 주문순 from business_info b, "
				+ "(select bi.business_id, count(o.business_id) a from orders o, business_info bi "
				+ "where o.business_id(+) = bi.business_id group by bi.business_id) o2 "
				+ "where b.business_id = o2.business_id(+) and business_code = ? order by a desc"; 
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, business_code);
			rs = ps.executeQuery();
			while (rs.next()){
				shoplist = new ShopListVO(rs.getString("business_id"), rs.getString("business_name"), 
						rs.getString("owner_name"), rs.getString("owner_phone"), rs.getString("business_code"));
				list1.add(shoplist);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
		return list1;
	}
	public List<ShopListVO> OpinionShopList(String business_code){
		String sql = "select b.business_id,b.business_name,nvl(a,0) 평가평점 from business_info b, "
				+ "(select bi.business_id,avg(score) a from opinion p, business_info bi "
				+ "where p.business_id(+)=bi.business_id group by bi.business_id) p2 "
				+ "where b.business_id = p2.business_id(+) order by 평가평점 desc"; 
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, business_code);
			rs = ps.executeQuery();
			while (rs.next()){
				shoplist = new ShopListVO(rs.getString("business_id"), rs.getString("business_name"), 
						rs.getString("owner_name"), rs.getString("owner_phone"), rs.getString("business_code"));
				list1.add(shoplist);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
		return list1;
	}
	public List<ShopListVO> selectShopSearch(String business_name){ // 사용자 검색단어 리스트
		String sql = "select * from business_info where business_name = ?"; 
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, business_name);
			rs = ps.executeQuery();
			while (rs.next()){
				shoplist = new ShopListVO(rs.getString("business_id"), rs.getString("business_name"), 
						rs.getString("owner_name"), rs.getString("owner_phone"), rs.getString("business_code"));
				list1.add(shoplist);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
		return list1;
	}
}
