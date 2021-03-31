package vo.business;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author student
 * 기업회원 정보 table 데이터
 */
public class Business_InfoVO implements Serializable{
	private String business_id; // 사업자번호
	private String business_name; // 상호명
	private String owner_name; // 대표자명
	private String owner_phone; // 연락처
	private String pw; // 비밀번호
	private String owner_acc; // 계좌번호
	private Date create_date; // 가입일자
	private String business_code; //업종코드
	private String business_check;
	public Business_InfoVO() {
		super();
	}
	public Business_InfoVO(String business_id, String business_name, String owner_name, String owner_phone, String pw,
			String owner_acc, Date create_date, String business_code, String business_check) {
		super();
		this.business_id = business_id;
		this.business_name = business_name;
		this.owner_name = owner_name;
		this.owner_phone = owner_phone;
		this.pw = pw;
		this.owner_acc = owner_acc;
		this.create_date = create_date;
		this.business_code = business_code;
		this.business_check = business_check;
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
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getOwner_acc() {
		return owner_acc;
	}
	public void setOwner_acc(String owner_acc) {
		this.owner_acc = owner_acc;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getBusiness_code() {
		return business_code;
	}
	public void setBusiness_code(String business_code) {
		this.business_code = business_code;
	}
	public String getBusiness_check() {
		return business_check;
	}
	public void setBusiness_check(String business_check) {
		this.business_check = business_check;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((business_check == null) ? 0 : business_check.hashCode());
		result = prime * result + ((business_code == null) ? 0 : business_code.hashCode());
		result = prime * result + ((business_id == null) ? 0 : business_id.hashCode());
		result = prime * result + ((business_name == null) ? 0 : business_name.hashCode());
		result = prime * result + ((create_date == null) ? 0 : create_date.hashCode());
		result = prime * result + ((owner_acc == null) ? 0 : owner_acc.hashCode());
		result = prime * result + ((owner_name == null) ? 0 : owner_name.hashCode());
		result = prime * result + ((owner_phone == null) ? 0 : owner_phone.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
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
		Business_InfoVO other = (Business_InfoVO) obj;
		if (business_check == null) {
			if (other.business_check != null)
				return false;
		} else if (!business_check.equals(other.business_check))
			return false;
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
		if (create_date == null) {
			if (other.create_date != null)
				return false;
		} else if (!create_date.equals(other.create_date))
			return false;
		if (owner_acc == null) {
			if (other.owner_acc != null)
				return false;
		} else if (!owner_acc.equals(other.owner_acc))
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
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Business_InfoVO [business_id=" + business_id + ", business_name=" + business_name + ", owner_name="
				+ owner_name + ", owner_phone=" + owner_phone + ", pw=" + pw + ", owner_acc=" + owner_acc
				+ ", create_date=" + create_date + ", business_code=" + business_code + ", business_check="
				+ business_check + "]";
	}
	
}