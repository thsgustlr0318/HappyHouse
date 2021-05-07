package com.ssafy.happyhouse.model.dto;

public class Location {
	
	String userid;
	String dong;
	String gugun;
	String sido;
	
	public Location() {
		super();
	}

	public Location(String userid, String dong, String gugun, String sido) {
		super();
		this.userid = userid;
		this.dong = dong;
		this.gugun = gugun;
		this.sido = sido;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getDong() {
		return dong;
	}


	public void setDong(String dong) {
		this.dong = dong;
	}


	public String getGugun() {
		return gugun;
	}


	public void setGugun(String gugun) {
		this.gugun = gugun;
	}


	public String getSido() {
		return sido;
	}


	public void setSido(String sido) {
		this.sido = sido;
	}

}
