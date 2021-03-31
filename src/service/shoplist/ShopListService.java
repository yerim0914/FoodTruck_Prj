package service.shoplist;

import java.util.List;
import vo.client.ShopListVO;

public interface ShopListService {
	
	public List<ShopListVO> BookMarkShopList(String business_code); // ���ã��� ���
	public List<ShopListVO> OrdersShopList(String business_code); // �ֹ��� ���
	public List<ShopListVO> OpinionShopList(String business_code); //�򰡼� ���
	public List<ShopListVO> selectShopSearch(String business_name); // ����� �˻��ܾ� ����Ʈ
	public List<ShopListVO> ShopList(String business_code);
	
}

