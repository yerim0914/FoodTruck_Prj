package dao.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clientUI.views.Main;
import service.client.Client_InfoService;
import service.client.Client_InfoServiceImpl;
import util.JDBCUtil;
import vo.client.Client_InfoVO;

public class Client_InfoDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public static Client_InfoVO log=new Client_InfoVO();


	public Client_InfoVO getClientInfoList(String client_id) {
		Client_InfoVO info = null;
		String sql = "select * from client_info where client_id = ?";
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, client_id);
			rs = ps.executeQuery();
			while (rs.isAfterLast()) {
				info = new Client_InfoVO(null, rs.getString("pw"), rs.getString("regident_num"),
						rs.getString("client_phone"), rs.getString("client_addr"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}

		return info;
	}

	public void insertClientInfo(Client_InfoVO vo) {
		String sql = "insert into client_info values (?, ?, ?, ?, ?)";
		con = JDBCUtil.getConnection();

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getClient_id()); // 회원ID
			ps.setString(2, vo.getPw()); // 비밀번호
			ps.setString(3, vo.getRegident_num()); // 주민번호
			ps.setString(4, vo.getClient_phone()); // 연락처
			ps.setString(5, vo.getClient_addr()); // 주소

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
	}

	public void updateClientInfo(String client_id, String pw, String client_phone, String client_addr) {
		String sql = "update client_info set pw = ?,  client_phone = ?, client_addr = ? where client_id = ?";
		con = JDBCUtil.getConnection();
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, pw);
			ps.setString(2, client_phone);
			ps.setString(3, client_addr);
			ps.setString(4, client_id);

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteClientInfo(String client_id) { // 회원 탈퇴
		String sql = "delete from client_info where client_id = ?";
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, client_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean Login(String client_id, String pw) { // 회원 로그인
		String sql = "select * from client_info where client_id = ?";

		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, client_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				log.setClient_addr(rs.getString("Client_addr"));
				log.setClient_id(rs.getString("Client_id"));
				log.setClient_phone(rs.getString("client_phone"));
				log.setPw(rs.getString("pw"));
				log.setRegident_num("regident_num");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		if (log.getPw().equals(pw))
			return true;
		else
			return false;

	}
}
