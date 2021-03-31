package service.client;

import dao.client.Client_InfoDAO;
import vo.client.Client_InfoVO;

public class Client_InfoServiceImpl implements Client_InfoService{
	Client_InfoDAO dao = new Client_InfoDAO();

	@Override
	public Client_InfoVO getClientInfoList(String client_id) {
		return dao.getClientInfoList(client_id);
	}

	@Override
	public void insertClientInfo(Client_InfoVO vo) {
		dao.insertClientInfo(vo);
	}

	@Override
	public void updateClientInfo(String client_id, String pw, String client_phone, String client_addr) {
		dao.updateClientInfo(client_id, pw, client_phone, client_addr);
	}

	@Override
	public void deleteClientInfo(String client_id) {
		dao.deleteClientInfo(client_id);
	}

	@Override
	public boolean Login(String client_id, String pw) {
		return dao.Login(client_id, pw);
	}


	
}
