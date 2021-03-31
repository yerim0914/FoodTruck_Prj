package service.stamp;

import java.util.List;

import vo.client.StampVO;
import vo.client.Stamp_ListVO;

public interface StampService {
	public StampVO getStamp(String business_id); // 스탬프 설정 가져오기
	public void insertStamp(StampVO vo); // 스탬프 규칙 사업자가 설정
	public void updateStamp(StampVO vo); // 수정
	public void SubStamp(String st_list_id); // 사장이 개인 고객의 사용완료된 쿠폰 cmp_num = -1
	
	public List<Stamp_ListVO> getAllStamp(String client_id); // 고객이 가진 전체 가게 스탬프들

	public void addStamp(String stamp_id, String client_id, int orders_count,int cmp_num);//스탬프 ++
	public void upStamp(String st_list_id,int stamp_pre,int cmp_num);//스탬프업데이트
		
		
	
	
}
