package service.user_order;

import java.util.List;

import vo.business.OrderListVO;
import vo.client.PaymentVO;

public interface User_Order_Service {
	public List<OrderListVO> getOrderList(String client_id);
	public void insertOrderList(OrderListVO vo);

	public PaymentVO getPayment(String orders_num); // 결제정보 가져오기
	public void insertPayment(PaymentVO vo);
	public void DecidePayment(String payment_num);
}

