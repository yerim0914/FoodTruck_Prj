package service.bookmark;

import java.util.List;

import vo.client.BookMarkVO;

public interface BookMarkService {
	public void insertBookMark(String client_id, String business_id, boolean ischeck); // ���ã�� ��� & ����
	public List<BookMarkVO> getBoormarkList(String client_id); // ȸ���� �ڽ��� ���ã�� ��� ������
}
