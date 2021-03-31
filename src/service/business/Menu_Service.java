package service.business;

import java.util.List;

import vo.business.MenuVO;

public interface Menu_Service {
	public List<MenuVO> Menu_List(String business_id); // 메뉴목록도 일단 볼 필요가 있을 것 같아요.;
	public void Menu_Insert(MenuVO vo); // 메뉴 등록
	public void Menu_Delete(String menu_id); // 메뉴 하나하나 삭제
	public void Menu_Recommend(String menu_id, String ischeck); 
	// 추천메뉴 체크하면 그 메뉴번호 정보 받아서 추천메뉴 boolean true, DB에서 Y로 바꾸고 추천메뉴부분에 뜨도록
	
}
