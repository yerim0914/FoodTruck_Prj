package vo.client;

import java.io.Serializable;

public class BookMarkVO implements Serializable {
	String client_id;
	String business_id;
	public BookMarkVO() {
		super();
	}
	public BookMarkVO(String client_id, String business_id) {
		super();
		this.client_id = client_id;
		this.business_id = business_id;
	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getBusiness_id() {
		return business_id;
	}
	public void setBusiness_id(String business_id) {
		this.business_id = business_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((business_id == null) ? 0 : business_id.hashCode());
		result = prime * result + ((client_id == null) ? 0 : client_id.hashCode());
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
		BookMarkVO other = (BookMarkVO) obj;
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
		return true;
	}
	@Override
	public String toString() {
		return "BookMarkVO [client_id=" + client_id + ", business_id=" + business_id + "]";
	}
	
	
}
