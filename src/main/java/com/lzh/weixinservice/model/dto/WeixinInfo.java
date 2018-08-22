package com.lzh.weixinservice.model.dto;

public class WeixinInfo {

	private String openid;
	private String session_key;
	
	public WeixinInfo(){}
	
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getSession_key() {
		return session_key;
	}

	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}
	
}
