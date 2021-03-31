package service.opinion;

import java.util.List;

import dao.client.OpinionDAO;
import vo.client.OpinionVO;

public class OpinionServiceImpl implements OpinionService {
	OpinionDAO dao = new OpinionDAO();
	
	@Override
	public OpinionVO getOpinion(String business_id, String client_id) {
		return dao.getOpinion(business_id, client_id);
	}
	@Override
	public List<OpinionVO> getAllListOpinion(String business_id) {
		return dao.getAllListOpinion(business_id);
	}

	@Override
	public void insertOpinion(String business_id, String client_id, String opinion_text, double score) {
		dao.insertOpinion(business_id, client_id, opinion_text, score);
	}

	@Override
	public void updateOpinion(String opinion_id, String opinion_text, double score) {
		dao.updateOpinion(opinion_id, opinion_text, score);
	}

	@Override
	public void deleteOpinion(String opinion_id) {
		dao.deleteOpinion(opinion_id);
	}

}
