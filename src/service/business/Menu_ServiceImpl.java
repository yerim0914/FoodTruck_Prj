package service.business;

import java.util.List;

import dao.business.Menu_Dao;
import vo.business.MenuVO;

public class Menu_ServiceImpl implements Menu_Service{
	Menu_Dao dao = new Menu_Dao();
	@Override
	public List<MenuVO> Menu_List(String business_id) {
		return dao.Menu_List(business_id);
	}

	@Override
	public void Menu_Insert(MenuVO vo) {
		dao.Menu_Insert(vo);
	}
	
	@Override
	public void Menu_Delete(String menu_id) {
		dao.Menu_Delete(menu_id);
	}

	@Override
	public void Menu_Recommend(String menu_id, String ischeck) {
		dao.Menu_Recommend(menu_id, ischeck);
	}



}
