package vo.business;

import java.io.Serializable;
/**
 * 
 * @author 2조 예림 물어보세용
 *	스케줄 테이블정보
 */
public class ScheduleVO implements Serializable{
	private String schedule_id; //sequence 
	private String business_id; //사업자번호
	private String business_day; // 영업요일(ex. 월요일)
	private String business_addr; // 영업장 주소
	private String business_hour; // 영업시간
	public ScheduleVO() {
		super();
	}
	public ScheduleVO(String schedule_id, String business_id, String business_day, 
			String business_addr, String business_hour) {
		super();
		this.business_id = business_id;
		this.business_day = business_day;
		this.business_addr = business_addr;
		this.business_hour = business_hour;
	}
	public String getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(String schedule_id) {
		this.schedule_id = schedule_id;
	}
	public String getBusiness_id() {
		return business_id;
	}
	public void setBusiness_id(String business_id) {
		this.business_id = business_id;
	}
	public String getBusiness_day() {
		return business_day;
	}
	public void setBusiness_day(String business_day) {
		this.business_day = business_day;
	}
	public String getBusiness_addr() {
		return business_addr;
	}
	public void setBusiness_addr(String business_addr) {
		this.business_addr = business_addr;
	}
	public String getBusiness_hour() {
		return business_hour;
	}
	public void setBusiness_hour(String business_hour) {
		this.business_hour = business_hour;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((business_addr == null) ? 0 : business_addr.hashCode());
		result = prime * result + ((business_day == null) ? 0 : business_day.hashCode());
		result = prime * result + ((business_hour == null) ? 0 : business_hour.hashCode());
		result = prime * result + ((business_id == null) ? 0 : business_id.hashCode());
		result = prime * result + ((schedule_id == null) ? 0 : schedule_id.hashCode());
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
		ScheduleVO other = (ScheduleVO) obj;
		if (business_addr == null) {
			if (other.business_addr != null)
				return false;
		} else if (!business_addr.equals(other.business_addr))
			return false;
		if (business_day == null) {
			if (other.business_day != null)
				return false;
		} else if (!business_day.equals(other.business_day))
			return false;
		if (business_hour == null) {
			if (other.business_hour != null)
				return false;
		} else if (!business_hour.equals(other.business_hour))
			return false;
		if (business_id == null) {
			if (other.business_id != null)
				return false;
		} else if (!business_id.equals(other.business_id))
			return false;
		if (schedule_id == null) {
			if (other.schedule_id != null)
				return false;
		} else if (!schedule_id.equals(other.schedule_id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ScheduleVO [schedule_id=" + schedule_id + ", business_id=" + business_id + ", business_day="
				+ business_day + ", business_addr=" + business_addr + ", business_hour=" + business_hour + "]";
	}
	
}
