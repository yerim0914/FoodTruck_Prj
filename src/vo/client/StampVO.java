package vo.client;

import java.io.Serializable;

public class StampVO implements Serializable{
	private String stamp_id;
	private String stamp_name;
	private String business_id;
	private int stp_target;
	private String menu_id;
	public StampVO() {
		super();
	}
	public StampVO(String stamp_id, String stamp_name, String business_id, int stp_target, String menu_id) {
		super();
		this.stamp_id = stamp_id;
		this.stamp_name = stamp_name;
		this.business_id = business_id;
		this.stp_target = stp_target;
		this.menu_id = menu_id;
	}
	public String getStamp_id() {
		return stamp_id;
	}
	public void setStamp_id(String stamp_id) {
		this.stamp_id = stamp_id;
	}
	public String getStamp_name() {
		return stamp_name;
	}
	public void setStamp_name(String stamp_name) {
		this.stamp_name = stamp_name;
	}
	public String getBusiness_id() {
		return business_id;
	}
	public void setBusiness_id(String business_id) {
		this.business_id = business_id;
	}
	public int getStp_target() {
		return stp_target;
	}
	public void setStp_target(int stp_target) {
		this.stp_target = stp_target;
	}
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((business_id == null) ? 0 : business_id.hashCode());
		result = prime * result + ((menu_id == null) ? 0 : menu_id.hashCode());
		result = prime * result + ((stamp_id == null) ? 0 : stamp_id.hashCode());
		result = prime * result + ((stamp_name == null) ? 0 : stamp_name.hashCode());
		result = prime * result + stp_target;
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
		StampVO other = (StampVO) obj;
		if (business_id == null) {
			if (other.business_id != null)
				return false;
		} else if (!business_id.equals(other.business_id))
			return false;
		if (menu_id == null) {
			if (other.menu_id != null)
				return false;
		} else if (!menu_id.equals(other.menu_id))
			return false;
		if (stamp_id == null) {
			if (other.stamp_id != null)
				return false;
		} else if (!stamp_id.equals(other.stamp_id))
			return false;
		if (stamp_name == null) {
			if (other.stamp_name != null)
				return false;
		} else if (!stamp_name.equals(other.stamp_name))
			return false;
		if (stp_target != other.stp_target)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StampVO [stamp_id=" + stamp_id + ", stamp_name=" + stamp_name + ", business_id=" + business_id
				+ ", stp_target=" + stp_target + ", menu_id=" + menu_id + "]";
	}
	
	
}
