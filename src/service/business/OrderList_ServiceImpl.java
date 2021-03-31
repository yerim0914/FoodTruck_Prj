package service.business;

import java.util.List;

import dao.business.OrderList_Dao;
import vo.business.OrderListVO;

public class OrderList_ServiceImpl implements OrderList_Service{
	OrderList_Dao dao = new OrderList_Dao();
	@Override
	public List<OrderListVO> getOrderList(String business_id) {
		return dao.getOrderList(business_id);
	}

	@Override
	public void soldoutIs(String orders_num, String ischeck) { //판매 완료 선택
		dao.soldoutIs(orders_num, ischeck);
	}

	@Override
	public void orderCancel(String orders_num, String cancel_cause) {
		dao.orderCancel(orders_num, cancel_cause);
	}
	
}
