package vo.client;

import java.io.Serializable;

public class Stamp_ListVO implements Serializable{
	private String st_list_id;
	private String stamp_id;
	private String orders_num;
	private String client_id;
	private int stamp_pre;
	private String cmp_num;
	
	public Stamp_ListVO() {
		super();
	}

	public Stamp_ListVO(String st_list_id, String stamp_id, String orders_num, String client_id, int stamp_pre,
			String cmp_num) {
		super();
		this.st_list_id = st_list_id;
		this.stamp_id = stamp_id;
		this.orders_num = orders_num;
		this.client_id = client_id;
		this.stamp_pre = stamp_pre;
		this.cmp_num = cmp_num;
	}

	public String getSt_list_id() {
		return st_list_id;
	}

	public void setSt_list_id(String st_list_id) {
		this.st_list_id = st_list_id;
	}

	public String getStamp_id() {
		return stamp_id;
	}

	public void setStamp_id(String stamp_id) {
		this.stamp_id = stamp_id;
	}

	public String getOrders_num() {
		return orders_num;
	}

	public void setOrders_num(String orders_num) {
		this.orders_num = orders_num;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public int getStamp_pre() {
		return stamp_pre;
	}

	public void setStamp_pre(int stamp_pre) {
		this.stamp_pre = stamp_pre;
	}

	public String getCmp_num() {
		return cmp_num;
	}

	public void setCmp_num(String cmp_num) {
		this.cmp_num = cmp_num;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client_id == null) ? 0 : client_id.hashCode());
		result = prime * result + ((cmp_num == null) ? 0 : cmp_num.hashCode());
		result = prime * result + ((orders_num == null) ? 0 : orders_num.hashCode());
		result = prime * result + ((st_list_id == null) ? 0 : st_list_id.hashCode());
		result = prime * result + ((stamp_id == null) ? 0 : stamp_id.hashCode());
		result = prime * result + stamp_pre;
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
		Stamp_ListVO other = (Stamp_ListVO) obj;
		if (client_id == null) {
			if (other.client_id != null)
				return false;
		} else if (!client_id.equals(other.client_id))
			return false;
		if (cmp_num == null) {
			if (other.cmp_num != null)
				return false;
		} else if (!cmp_num.equals(other.cmp_num))
			return false;
		if (orders_num == null) {
			if (other.orders_num != null)
				return false;
		} else if (!orders_num.equals(other.orders_num))
			return false;
		if (st_list_id == null) {
			if (other.st_list_id != null)
				return false;
		} else if (!st_list_id.equals(other.st_list_id))
			return false;
		if (stamp_id == null) {
			if (other.stamp_id != null)
				return false;
		} else if (!stamp_id.equals(other.stamp_id))
			return false;
		if (stamp_pre != other.stamp_pre)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Stamp_ListVO [st_list_id=" + st_list_id + ", stamp_id=" + stamp_id + ", orders_num=" + orders_num
				+ ", client_id=" + client_id + ", stamp_pre=" + stamp_pre + ", cmp_num=" + cmp_num + "]";
	}

	
}
