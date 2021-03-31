package service.client;

import vo.client.Client_InfoVO;

public interface Client_InfoService {
	public Client_InfoVO getClientInfoList(String client_id);
	public void insertClientInfo(Client_InfoVO vo); //����
	public void updateClientInfo(String client_id, String pw, String client_phone, String client_addr); // ���� ����
	public void deleteClientInfo(String client_id); // Ż��
	public boolean Login(String client_id, String pw); // �α���
}


