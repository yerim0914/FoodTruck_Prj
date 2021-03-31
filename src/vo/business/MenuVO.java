package vo.business;

import java.io.Serializable;

public class MenuVO implements Serializable{
	private String menu_id; // 메뉴번호
	private String business_id; // 사업자번호
	private String menu_name; // 메뉴이름
	private int menu_price; // 메뉴가격
	private String menu_desc; // 메뉴설명
	private String recommend; //추천메뉴 Y/N
	public MenuVO() {
	}
	public MenuVO(String menu_id, String business_id, String menu_name, int menu_price, 
			String menu_desc, String recommend) {
		super();
		this.menu_id = menu_id;
		this.business_id = business_id;
		this.menu_name = menu_name;
		this.menu_price = menu_price;
		this.menu_desc = menu_desc;
		this.recommend = recommend;
	}
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getBusiness_id() {
		return business_id;
	}
	public void setBusiness_id(String business_id) {
		this.business_id = business_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public int getMenu_price() {
		return menu_price;
	}
	public void setMenu_price(int menu_price) {
		this.menu_price = menu_price;
	}
	public String getMenu_desc() {
		return menu_desc;
	}
	public void setMenu_desc(String menu_desc) {
		this.menu_desc = menu_desc;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String reconmmend) {
		this.recommend = reconmmend;
	}
	@Override
	public String toString() {
		return "MenuVO [menu_id=" + menu_id + ", business_id=" + business_id + ", menu_name=" + menu_name
				+ ", menu_price=" + menu_price + ", menu_desc=" + menu_desc + ", recommend=" + recommend + "]";
	}
	
	
}
