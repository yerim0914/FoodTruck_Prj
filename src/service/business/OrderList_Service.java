package service.business;

import java.util.List;

import vo.business.OrderListVO;

public interface OrderList_Service {
	public List<OrderListVO> getOrderList(String business_id); // 주문목록보기
	public void soldoutIs(String orders_num, String ischeck); // 판매 되었는지 여부
	// primary key 가 orders_num (주문번호) 라서 이렇게 해놓구
	// ui에서 체크하면 ischeck 로 받아서 DB에 salable(판매여부)를 Y로
	public void orderCancel(String orders_num, String cancel_cause);
}
