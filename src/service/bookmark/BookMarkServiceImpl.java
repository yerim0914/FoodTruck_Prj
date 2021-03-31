package service.bookmark;

import java.util.List;

import dao.client.BookMarkDAO;
import vo.client.BookMarkVO;

public class BookMarkServiceImpl implements BookMarkService {
	
	BookMarkDAO dao = new BookMarkDAO();

	@Override
	public void insertBookMark(String client_id, String business_id, boolean ischeck) {
		dao.insertBookMark(client_id, business_id, ischeck);
	}

	@Override
	public List<BookMarkVO> getBoormarkList(String client_id) {
		return null;
	}

	
	
}
