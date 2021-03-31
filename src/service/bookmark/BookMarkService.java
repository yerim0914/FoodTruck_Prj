package service.bookmark;

import java.util.List;

import vo.client.BookMarkVO;

public interface BookMarkService {
	public void insertBookMark(String client_id, String business_id, boolean ischeck); // 즐겨찾기 등록 & 해제
	public List<BookMarkVO> getBoormarkList(String client_id); // 회원이 자신의 즐겨찾기 목록 가져옴
}
