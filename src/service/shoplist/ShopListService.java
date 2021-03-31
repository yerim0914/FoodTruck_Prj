package service.shoplist;

import java.util.List;
import vo.client.ShopListVO;

public interface ShopListService {
	
	public List<ShopListVO> BookMarkShopList(String business_code); // 즐겨찾기순 목록
	public List<ShopListVO> OrdersShopList(String business_code); // 주문순 목록
	public List<ShopListVO> OpinionShopList(String business_code); //평가순 목록
	public List<ShopListVO> selectShopSearch(String business_name); // 사용자 검색단어 리스트
	public List<ShopListVO> ShopList(String business_code);
	
}

