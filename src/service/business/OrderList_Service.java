package service.business;

import java.util.List;

import vo.business.OrderListVO;

public interface OrderList_Service {
	public List<OrderListVO> getOrderList(String business_id); // �ֹ���Ϻ���
	public void soldoutIs(String orders_num, String ischeck); // �Ǹ� �Ǿ����� ����
	// primary key �� orders_num (�ֹ���ȣ) �� �̷��� �س���
	// ui���� üũ�ϸ� ischeck �� �޾Ƽ� DB�� salable(�Ǹſ���)�� Y��
	public void orderCancel(String orders_num, String cancel_cause);
}
