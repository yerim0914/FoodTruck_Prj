package vo.business;

import java.io.Serializable;
import java.util.Date;

public class OrderListVO implements Serializable{
	private String orders_num; // 주문번호
	private String business_id; // 사업자번호
	private String client_id; // 회원 ID
	private String menu_id; // 메뉴 번호
	private String coupon_id; // 쿠폰번호
	private Date orders_date; // 주문날짜
	private int orders_count; // 수량
	private String salable; // 판매 되었다  
	public OrderListVO() {
		super();
	}
	public OrderListVO(String orders_num, String business_id, String client_id, String menu_id, String coupon_id,
			Date orders_date, int orders_count, String salable) {
		super();
		this.orders_num = orders_num;
		this.business_id = business_id;
		this.client_id = client_id;
		this.menu_id = menu_id;
		this.coupon_id = coupon_id;
		this.orders_date = orders_date;
		this.orders_count = orders_count;
		this.salable = salable;
	}
	public String getOrders_num() {
		return orders_num;
	}
	public void setOrders_num(String orders_num) {
		this.orders_num = orders_num;
	}
	public String getBusiness_id() {
		return business_id;
	}
	public void setBusiness_id(String business_id) {
		this.business_id = business_id;
	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
	}
	public Date getOrders_date() {
		return orders_date;
	}
	public void setOrders_date(Date orders_date) {
		this.orders_date = orders_date;
	}
	public int getOrders_count() {
		return orders_count;
	}
	public void setOrders_count(int orders_count) {
		this.orders_count = orders_count;
	}
	public String getSalable() {
		return salable;
	}
	public void setSalable(String salable) {
		this.salable = salable;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((business_id == null) ? 0 : business_id.hashCode());
		result = prime * result + ((client_id == null) ? 0 : client_id.hashCode());
		result = prime * result + ((coupon_id == null) ? 0 : coupon_id.hashCode());
		result = prime * result + ((menu_id == null) ? 0 : menu_id.hashCode());
		result = prime * result + orders_count;
		result = prime * result + ((orders_date == null) ? 0 : orders_date.hashCode());
		result = prime * result + ((orders_num == null) ? 0 : orders_num.hashCode());
		result = prime * result + ((salable == null) ? 0 : salable.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderListVO other = (OrderListVO) obj;
		if (business_id == null) {
			if (other.business_id != null)
				return false;
		} else if (!business_id.equals(other.business_id))
			return false;
		if (client_id == null) {
			if (other.client_id != null)
				return false;
		} else if (!client_id.equals(other.client_id))
			return false;
		if (coupon_id == null) {
			if (other.coupon_id != null)
				return false;
		} else if (!coupon_id.equals(other.coupon_id))
			return false;
		if (menu_id == null) {
			if (other.menu_id != null)
				return false;
		} else if (!menu_id.equals(other.menu_id))
			return false;
		if (orders_count != other.orders_count)
			return false;
		if (orders_date == null) {
			if (other.orders_date != null)
				return false;
		} else if (!orders_date.equals(other.orders_date))
			return false;
		if (orders_num == null) {
			if (other.orders_num != null)
				return false;
		} else if (!orders_num.equals(other.orders_num))
			return false;
		if (salable == null) {
			if (other.salable != null)
				return false;
		} else if (!salable.equals(other.salable))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderListVO [orders_num=" + orders_num + ", business_id=" + business_id + ", client_id=" + client_id
				+ ", menu_id=" + menu_id + ", coupon_id=" + coupon_id + ", orders_date=" + orders_date
				+ ", orders_count=" + orders_count + ", salable=" + salable + "]";
	}
	
	
}
