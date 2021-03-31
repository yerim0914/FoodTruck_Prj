package vo.client;

import java.io.Serializable;

/**
 * 
 * @author 2조 이예림 궁금한거 물어보세용
 * 업체 목록을 즐겨찾기, 주문순, 검색내용순으로 정렬해서 보여주기 위한 데이터
 * 
 */
public class ShopListVO implements Serializable{
	private String business_id; // 사업자번호
	private String business_name; // 상호명
	private String owner_name; // 대표 이름
	private String owner_phone; // 연락처
	private String business_code;
	
	public ShopListVO() {
	}

	public ShopListVO(String business_id, String business_name, String owner_name, String owner_phone,
			String business_code) {
		super();
		this.business_id = business_id;
		this.business_name = business_name;
		this.owner_name = owner_name;
		this.owner_phone = owner_phone;
		this.business_code = business_code;
	}

	public String getBusiness_id() {
		return business_id;
	}

	public void setBusiness_id(String business_id) {
		this.business_id = business_id;
	}

	public String getBusiness_name() {
		return business_name;
	}

	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public String getOwner_phone() {
		return owner_phone;
	}

	public void setOwner_phone(String owner_phone) {
		this.owner_phone = owner_phone;
	}

	public String getBusiness_code() {
		return business_code;
	}

	public void setBusiness_code(String business_code) {
		this.business_code = business_code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((business_code == null) ? 0 : business_code.hashCode());
		result = prime * result + ((business_id == null) ? 0 : business_id.hashCode());
		result = prime * result + ((business_name == null) ? 0 : business_name.hashCode());
		result = prime * result + ((owner_name == null) ? 0 : owner_name.hashCode());
		result = prime * result + ((owner_phone == null) ? 0 : owner_phone.hashCode());
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
		ShopListVO other = (ShopListVO) obj;
		if (business_code == null) {
			if (other.business_code != null)
				return false;
		} else if (!business_code.equals(other.business_code))
			return false;
		if (business_id == null) {
			if (other.business_id != null)
				return false;
		} else if (!business_id.equals(other.business_id))
			return false;
		if (business_name == null) {
			if (other.business_name != null)
				return false;
		} else if (!business_name.equals(other.business_name))
			return false;
		if (owner_name == null) {
			if (other.owner_name != null)
				return false;
		} else if (!owner_name.equals(other.owner_name))
			return false;
		if (owner_phone == null) {
			if (other.owner_phone != null)
				return false;
		} else if (!owner_phone.equals(other.owner_phone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShopListVO [business_id=" + business_id + ", business_name=" + business_name + ", owner_name="
				+ owner_name + ", owner_phone=" + owner_phone + ", business_code=" + business_code + "]";
	}
	
	
}
