package service.business;

import dao.business.Business_Info_Dao;
import vo.business.Business_InfoVO;

public class Business_Info_ServiceImpl implements Business_Info_Service{
	Business_Info_Dao dao = new Business_Info_Dao();
	@Override
	public Business_InfoVO getBusiness_Info_List(String business_id) {
		return dao.getBusiness_Info_List(business_id);
	}

	@Override
	public void Join_Business(Business_InfoVO vo) {
		dao.Join_Business(vo);
	}

	@Override
	public void Info_Modify(String business_id, String business_name, 
			String owner_phone, String pw, String owner_acc, String business_code) {
		dao.Info_Modify(business_id, business_name, owner_phone, pw, owner_acc, business_code);
	}

	@Override
	public void Info_Delete(String business_id) {
		dao.Info_Delete(business_id); 
	}

	@Override
	public boolean Owner_Login(String business_id, String pw) {
		return dao.Owner_Login(business_id, pw);
	}
	
}
