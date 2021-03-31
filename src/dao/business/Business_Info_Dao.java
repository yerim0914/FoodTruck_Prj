package dao.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.business.Business_InfoVO;
import util.JDBCUtil;

public class Business_Info_Dao {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	

	public Business_InfoVO getBusiness_Info_List(String business_id){
		Business_InfoVO info = null;
		String sql = "select business_id from business_info where business_id = ?";
		// SQL �־���� �⺻�������� ������ �������� �׸��� ������ư, ������ư ���־����
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, business_id);
			rs = ps.executeQuery();

			while(rs.next()){ 
			info = new Business_InfoVO(rs.getString("business_id"), rs.getString("business_name"),
					rs.getString("owner_name"), rs.getString("owner_phone"), rs.getString("pw"),
					rs.getString("owner_acc"), rs.getDate("create_date"), 
					rs.getString("business_code"), rs.getString("business_check")); // ���� �־����
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
		
		return info;
	}
	
	public void Join_Business(Business_InfoVO vo){ // ����� ����
		String sql = "insert into business_info values (?, ?, ?, ?, ?, ?, sysdate, ?, 'Y')";
		String[] model = new String[] {"�ѽ�", "���","�߽�","�Ͻ�","�н�","����Ŀ��","����","�ַ�","����Ʈ"};
		String[] index = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
		con = JDBCUtil.getConnection();
		for(int i = 0; i < model.length; i++){
		if(model[i].equals(vo.getBusiness_code())){
			vo.setBusiness_code(index[i+1]);
		}
		}
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getBusiness_id()); // ����ڹ�ȣ
			ps.setString(2, vo.getBusiness_name()); // ��ȣ��
			ps.setString(3, vo.getOwner_name()); // ��ǥ�ڸ�
			ps.setString(4, vo.getOwner_phone()); // ����ó
			ps.setString(5, vo.getPw()); // ��й�ȣ
			ps.setString(6, vo.getOwner_acc()); // ����
			ps.setString(7, vo.getBusiness_code()); // �����ڵ�
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
		
	}
	public void Info_Modify(String business_id, String business_name, 
			String owner_phone, String pw, String owner_acc, String business_code){ // �������� ����
		String sql = "update business_info set business_name = ?,  owner_phone = ?, "
				+ "pw = ?, owner_acc = ? business_code = ? where business_id = ?";
		con = JDBCUtil.getConnection();
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, business_name);
			ps.setString(2, owner_phone);
			ps.setString(3, pw);
			ps.setString(4, owner_acc);
			ps.setString(5, business_code);
			ps.setString(6, business_id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void Info_Delete(String business_id){ // �������� ����
		String sql = "update business_info set business_check = 'N' where business_id = ?";
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, business_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean Owner_Login(String business_id, String pw){
		String sql = "select pw from business_info where business_id = ?";
		String busi_pw = null;
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, business_id);
			rs = ps.executeQuery();
			while(rs.next()){
			busi_pw = rs.getString("pw");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
		
		if(busi_pw.equals(pw))
			return true;
		else 
			return false;
		
	}

}
