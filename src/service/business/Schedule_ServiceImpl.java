package service.business;

import java.util.List;

import dao.business.Schedule_Dao;
import vo.business.ScheduleVO;

public class Schedule_ServiceImpl implements Schedule_Service{
	Schedule_Dao dao = new Schedule_Dao();
	@Override
	public List<ScheduleVO> Schedule_List(String business_id) {
		return dao.Schedule_List(business_id);
	}
	
	@Override
	public void Schedule_Insert(ScheduleVO vo) {
		dao.Schedule_Insert(vo);
	}

	@Override
	public void Menu_Delete(String business_day) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Schedule_Modify(String business_id, String schedule_id, String business_day, String business_addr,
			String business_hour) {
		// TODO Auto-generated method stub
		
	}



	
}
