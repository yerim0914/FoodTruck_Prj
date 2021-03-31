package service.stamp;

import java.util.List;

import dao.business.StampDAO;
import dao.client.StampListDao;
import vo.client.StampVO;
import vo.client.Stamp_ListVO;

public class StampServiceImpl implements StampService{
	
	StampDAO Bdao = new StampDAO();
	StampListDao Cdao = new StampListDao();
	@Override
	public StampVO getStamp(String business_id) {
		return Bdao.getStamp(business_id);
	}

	@Override
	public void insertStamp(StampVO vo) {
		Bdao.insertStamp(vo);
	}

	@Override
	public void updateStamp(StampVO vo) {
		Bdao.updateStamp(vo);
	}
	
	@Override
	public void SubStamp(String st_list_id) {
		Bdao.SubStamp(st_list_id);
	}

	@Override
	public List<Stamp_ListVO> getAllStamp(String client_id) {
		return Cdao.getAllStamp(client_id);
	}


	@Override
	public void addStamp(String stamp_id, String client_id, int orders_count,int cmp_num){
		Cdao.addStamp(stamp_id, client_id, orders_count,cmp_num);		
	}
	public void upStamp(String st_list_id,int stamp_pre,int cmp_num){
		Cdao.upStamp(st_list_id,stamp_pre,cmp_num);
	}

}
