package service.business;

import java.util.List;

import vo.business.ScheduleVO;

public interface Schedule_Service {
	public List<ScheduleVO> Schedule_List(String business_id); // �ڽ��� ����� ��ü������
	public void Schedule_Insert(ScheduleVO vo); // �޴� ���
	public void Schedule_Modify(String business_id, String schedule_id, String business_day, 
			String business_addr, String business_hour);
	// �����ټ���, ���������� ������ ���ڷ� �޽��ϴ�.
	public void Menu_Delete(String business_day); // ������� ���Ϸ� �޴°� ������? �Ƹ�.. �ϴܺ���
	
}
