package vo.client;

import java.io.Serializable;
import java.util.Date;

public class OpinionVO implements Serializable {
	private String opinion_id;
	private String business_id;
	private String client_id;
	private Date write_date;
	private String opinion_text;
	private double score;
	
	public OpinionVO() {
		super();
	}

	public OpinionVO(String opinion_id, String business_id, String client_id, Date write_date, String opinion_text,
			double score) {
		super();
		this.opinion_id = opinion_id;
		this.business_id = business_id;
		this.client_id = client_id;
		this.write_date = write_date;
		this.opinion_text = opinion_text;
		this.score = score;
	}

	public String getOpinion_id() {
		return opinion_id;
	}

	public void setOpinion_id(String opinion_id) {
		this.opinion_id = opinion_id;
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

	public Date getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}

	public String getOpinion_text() {
		return opinion_text;
	}

	public void setOpinion_text(String opinion_text) {
		this.opinion_text = opinion_text;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((business_id == null) ? 0 : business_id.hashCode());
		result = prime * result + ((client_id == null) ? 0 : client_id.hashCode());
		result = prime * result + ((opinion_id == null) ? 0 : opinion_id.hashCode());
		result = prime * result + ((opinion_text == null) ? 0 : opinion_text.hashCode());
		long temp;
		temp = Double.doubleToLongBits(score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((write_date == null) ? 0 : write_date.hashCode());
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
		OpinionVO other = (OpinionVO) obj;
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
		if (opinion_id == null) {
			if (other.opinion_id != null)
				return false;
		} else if (!opinion_id.equals(other.opinion_id))
			return false;
		if (opinion_text == null) {
			if (other.opinion_text != null)
				return false;
		} else if (!opinion_text.equals(other.opinion_text))
			return false;
		if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score))
			return false;
		if (write_date == null) {
			if (other.write_date != null)
				return false;
		} else if (!write_date.equals(other.write_date))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OpinionVO [opinion_id=" + opinion_id + ", business_id=" + business_id + ", client_id=" + client_id
				+ ", write_date=" + write_date + ", opinion_text=" + opinion_text + ", score=" + score + "]";
	}

	
	
}
