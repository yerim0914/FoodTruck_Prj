package service.client;

import vo.client.Client_InfoVO;

public interface Client_InfoService {
	public Client_InfoVO getClientInfoList(String client_id);
	public void insertClientInfo(Client_InfoVO vo); //가입
	public void updateClientInfo(String client_id, String pw, String client_phone, String client_addr); // 정보 수정
	public void deleteClientInfo(String client_id); // 탈퇴
	public boolean Login(String client_id, String pw); // 로그인
}


