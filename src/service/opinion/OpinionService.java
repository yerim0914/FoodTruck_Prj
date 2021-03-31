package service.opinion;

import java.util.List;

import vo.client.OpinionVO;

public interface OpinionService {
	public OpinionVO getOpinion(String business_id, String client_id);// ���� ����� �� �ϳ��� �ı�
	public List<OpinionVO> getAllListOpinion(String business_id); // �ϳ��� ����� �ı���
	public void insertOpinion(String business_id, String client_id, String opinion_text, double score); // �ǰߵ��
	public void updateOpinion(String opinion_id, String opinion_text, double score); // �ǰ߼���
	public void deleteOpinion(String opinion_id); // �ǰ߻���
}

