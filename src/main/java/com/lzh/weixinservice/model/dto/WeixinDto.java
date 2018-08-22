package com.lzh.weixinservice.model.dto;

public class WeixinDto {

	private String loginState;
	
	private Long userId;

	public WeixinDto(){}
	
	public String getLoginState() {
		return loginState;
	}

	public void setLoginState(String loginState) {
		this.loginState = loginState;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
