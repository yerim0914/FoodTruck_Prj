package service.business;

import java.util.List;

import vo.business.MenuVO;

public interface Menu_Service {
	public List<MenuVO> Menu_List(String business_id); // �޴���ϵ� �ϴ� �� �ʿ䰡 ���� �� ���ƿ�.;
	public void Menu_Insert(MenuVO vo); // �޴� ���
	public void Menu_Delete(String menu_id); // �޴� �ϳ��ϳ� ����
	public void Menu_Recommend(String menu_id, String ischeck); 
	// ��õ�޴� üũ�ϸ� �� �޴���ȣ ���� �޾Ƽ� ��õ�޴� boolean true, DB���� Y�� �ٲٰ� ��õ�޴��κп� �ߵ���
	
}
