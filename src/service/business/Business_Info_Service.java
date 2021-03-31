package service.business;

import vo.business.Business_InfoVO;

public interface Business_Info_Service {
	public Business_InfoVO getBusiness_Info_List(String business_id);
	public void Join_Business(Business_InfoVO vo); // ����
	public void Info_Modify(String business_id, String business_name, 
			String owner_phone, String pw, String owner_acc, String business_code);
	// �������� ����, ���������� ������ ���ڷ� �޽��ϴ�.
	public void Info_Delete(String business_id); // ������� �ұ��
	public boolean Owner_Login(String business_id, String pw);
	
}
