package service.user_order;

import java.util.List;

import dao.client.User_Order_DAO;
import vo.business.OrderListVO;
import vo.client.PaymentVO;

public class User_Order_ServiceImpl implements User_Order_Service {
	User_Order_DAO dao;
	@Override
	public List<OrderListVO> getOrderList(String client_id) {
		return dao.getOrderList(client_id);
	}
	
	@Override
	public void insertOrderList(OrderListVO vo) {
		dao.insertOrderList(vo);
	}

	@Override
	public PaymentVO getPayment(String orders_num) {
		return dao.getPayment(orders_num);
	}
	
	@Override
	public void insertPayment(PaymentVO vo) {
		dao.insertPayment(vo);
	}

	@Override
	public void DecidePayment(String payment_num) {
		dao.DecidePayment(payment_num);
	}

	
}
