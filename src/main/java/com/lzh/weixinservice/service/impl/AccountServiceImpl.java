package com.lzh.weixinservice.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lzh.weixinservice.model.dto.WeixinInfo;
import com.lzh.weixinservice.model.entity.TAccountUser;
import com.lzh.weixinservice.model.entity.TAccountWxInfo;
import com.lzh.weixinservice.persistence.TAccountUserMapper;
import com.lzh.weixinservice.persistence.TAccountWxInfoMapper;
import com.lzh.weixinservice.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
	
	@Autowired
	private TAccountWxInfoMapper accountWxInfoMapper;
	
	@Autowired
	private TAccountUserMapper accountUserMapper;
	
	@Override
	public TAccountWxInfo findUserInfoByOpenId(WeixinInfo wxInfo) {
		Map map = new HashMap(8);
		map.put("openid", wxInfo.getOpenid());
		//map.put("sessionKey", wxInfo.getSession_key());
		TAccountWxInfo rs = accountWxInfoMapper.findUserInfoByOpenId(map);
		return rs;
	}

	@Override
	public TAccountUser addUser(Map map) {
		
		TAccountUser rs = new TAccountUser();
		rs.setUsableFlag(0);
		accountUserMapper.insert(rs);
		return rs;
	}

	@Override
	public void addUserWxInfo(TAccountWxInfo wxInfo) {
		accountWxInfoMapper.insert(wxInfo);
	}
	
	
}
