package com.sist.main;
// �÷��� �ִ� �����Ͱ��� �ޱ� ���ؼ� ������ ��Ī 
public class Zipcode {
    private String zipcode;
    private String sido;
    private String gugun;
    private String dong;
    private String bunji;
    private String address;
    
	public String getAddress() {
		return sido+" "+gugun+" "+dong+" "+bunji;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getBunji() {
		return bunji;
	}
	public void setBunji(String bunji) {
		this.bunji = bunji;
	}
	  
}
