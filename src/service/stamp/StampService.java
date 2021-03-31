package service.stamp;

import java.util.List;

import vo.client.StampVO;
import vo.client.Stamp_ListVO;

public interface StampService {
	public StampVO getStamp(String business_id); // ������ ���� ��������
	public void insertStamp(StampVO vo); // ������ ��Ģ ����ڰ� ����
	public void updateStamp(StampVO vo); // ����
	public void SubStamp(String st_list_id); // ������ ���� ���� ���Ϸ�� ���� cmp_num = -1
	
	public List<Stamp_ListVO> getAllStamp(String client_id); // ���� ���� ��ü ���� ��������

	public void addStamp(String stamp_id, String client_id, int orders_count,int cmp_num);//������ ++
	public void upStamp(String st_list_id,int stamp_pre,int cmp_num);//������������Ʈ
		
		
	
	
}
