package service.business;

import java.util.List;

import vo.business.ScheduleVO;

public interface Schedule_Service {
	public List<ScheduleVO> Schedule_List(String business_id); // 자신의 저장된 전체스케줄
	public void Schedule_Insert(ScheduleVO vo); // 메뉴 등록
	public void Schedule_Modify(String business_id, String schedule_id, String business_day, 
			String business_addr, String business_hour);
	// 스케줄수정, 수정가능한 정보를 인자로 받습니다.
	public void Menu_Delete(String business_day); // 삭제기능 요일로 받는게 낫겠죠? 아마.. 일단보류
	
}
