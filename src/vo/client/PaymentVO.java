package vo.client;

import java.io.Serializable;

public class PaymentVO implements Serializable{
	private String payment_num;
	private String orders_num;
	private String payment_type;
	private String payment_check;
	
	public PaymentVO() {
		super();
	}

	public PaymentVO(String payment_num, String orders_num, String payment_type, String payment_check) {
		super();
		this.payment_num = payment_num;
		this.orders_num = orders_num;
		this.payment_type = payment_type;
		this.payment_check = payment_check;
	}

	public String getPayment_num() {
		return payment_num;
	}

	public void setPayment_num(String payment_num) {
		this.payment_num = payment_num;
	}

	public String getOrders_num() {
		return orders_num;
	}

	public void setOrders_num(String orders_num) {
		this.orders_num = orders_num;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public String getPayment_check() {
		return payment_check;
	}

	public void setPayment_check(String payment_check) {
		this.payment_check = payment_check;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orders_num == null) ? 0 : orders_num.hashCode());
		result = prime * result + ((payment_check == null) ? 0 : payment_check.hashCode());
		result = prime * result + ((payment_num == null) ? 0 : payment_num.hashCode());
		result = prime * result + ((payment_type == null) ? 0 : payment_type.hashCode());
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
		PaymentVO other = (PaymentVO) obj;
		if (orders_num == null) {
			if (other.orders_num != null)
				return false;
		} else if (!orders_num.equals(other.orders_num))
			return false;
		if (payment_check == null) {
			if (other.payment_check != null)
				return false;
		} else if (!payment_check.equals(other.payment_check))
			return false;
		if (payment_num == null) {
			if (other.payment_num != null)
				return false;
		} else if (!payment_num.equals(other.payment_num))
			return false;
		if (payment_type == null) {
			if (other.payment_type != null)
				return false;
		} else if (!payment_type.equals(other.payment_type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PaymentVO [payment_num=" + payment_num + ", orders_num=" + orders_num + ", payment_type=" + payment_type
				+ ", payment_check=" + payment_check + "]";
	}
	
	
}
