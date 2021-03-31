package service.shoplist;

import java.util.List;

import dao.client.ShopListDAO;
import vo.client.ShopListVO;

public class ShopListServiceImpl implements ShopListService{
	ShopListDAO dao = new ShopListDAO();

	@Override
	public List<ShopListVO> BookMarkShopList(String business_code) {
		return dao.BookMarkShopList(business_code);
	}
	
	@Override
	public List<ShopListVO> OpinionShopList(String business_code) {
		return dao.OpinionShopList(business_code);
	}
	
	@Override
	public List<ShopListVO> OrdersShopList(String business_code) {
		return dao.OrdersShopList(business_code);
	}

	@Override
	public List<ShopListVO> selectShopSearch(String business_name) {
		return dao.selectShopSearch(business_name);
	}
	
	public List<ShopListVO> ShopList(String business_code){ 
		return dao.ShopList(business_code) ;
	}


	
	
}
