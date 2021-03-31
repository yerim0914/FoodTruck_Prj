package service.opinion;

import java.util.List;

import vo.client.OpinionVO;

public interface OpinionService {
	public OpinionVO getOpinion(String business_id, String client_id);// 내가 기업에 쓴 하나의 후기
	public List<OpinionVO> getAllListOpinion(String business_id); // 하나의 기업의 후기목록
	public void insertOpinion(String business_id, String client_id, String opinion_text, double score); // 의견등록
	public void updateOpinion(String opinion_id, String opinion_text, double score); // 의견수정
	public void deleteOpinion(String opinion_id); // 의견삭제
}

