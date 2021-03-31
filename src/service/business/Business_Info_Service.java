package service.business;

import vo.business.Business_InfoVO;

public interface Business_Info_Service {
	public Business_InfoVO getBusiness_Info_List(String business_id);
	public void Join_Business(Business_InfoVO vo); // 가입
	public void Info_Modify(String business_id, String business_name, 
			String owner_phone, String pw, String owner_acc, String business_code);
	// 가입정보 수정, 수정가능한 정보를 인자로 받습니다.
	public void Info_Delete(String business_id); // 삭제기능 할까말까
	public boolean Owner_Login(String business_id, String pw);
	
}
