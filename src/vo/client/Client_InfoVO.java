package vo.client;

import java.io.Serializable;

public class Client_InfoVO implements Serializable {
	private String client_id;
	private String pw;
	private String regident_num;
	private String client_phone;
	private String client_addr;
	
	public Client_InfoVO() {
		super();
	}

	public Client_InfoVO(String client_id, String pw, String regident_num, String client_phone, String client_addr) {
		super();
		this.client_id = client_id;
		this.pw = pw;
		this.regident_num = regident_num;
		this.client_phone = client_phone;
		this.client_addr = client_addr;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getRegident_num() {
		return regident_num;
	}

	public void setRegident_num(String regident_num) {
		this.regident_num = regident_num;
	}

	public String getClient_phone() {
		return client_phone;
	}

	public void setClient_phone(String client_phone) {
		this.client_phone = client_phone;
	}

	public String getClient_addr() {
		return client_addr;
	}

	public void setClient_addr(String client_addr) {
		this.client_addr = client_addr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client_addr == null) ? 0 : client_addr.hashCode());
		result = prime * result + ((client_id == null) ? 0 : client_id.hashCode());
		result = prime * result + ((client_phone == null) ? 0 : client_phone.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		result = prime * result + ((regident_num == null) ? 0 : regident_num.hashCode());
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
		Client_InfoVO other = (Client_InfoVO) obj;
		if (client_addr == null) {
			if (other.client_addr != null)
				return false;
		} else if (!client_addr.equals(other.client_addr))
			return false;
		if (client_id == null) {
			if (other.client_id != null)
				return false;
		} else if (!client_id.equals(other.client_id))
			return false;
		if (client_phone == null) {
			if (other.client_phone != null)
				return false;
		} else if (!client_phone.equals(other.client_phone))
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		if (regident_num == null) {
			if (other.regident_num != null)
				return false;
		} else if (!regident_num.equals(other.regident_num))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client_InfoVO [client_id=" + client_id + ", pw=" + pw + ", regident_num=" + regident_num
				+ ", client_phone=" + client_phone + ", client_addr=" + client_addr + "]";
	}

	
	
}
