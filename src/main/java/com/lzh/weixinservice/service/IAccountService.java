package com.lzh.weixinservice.service;

import java.util.Map;

import com.lzh.weixinservice.model.dto.WeixinInfo;
import com.lzh.weixinservice.model.entity.TAccountUser;
import com.lzh.weixinservice.model.entity.TAccountWxInfo;

public interface IAccountService {

	/**
	 * 通过openid查询用户信息
	 * @param wxInfo
	 * @return
	 */
	TAccountWxInfo findUserInfoByOpenId(WeixinInfo wxInfo);
	/**
	 * 插入新用户
	 * @param map
	 * @return
	 */
	TAccountUser addUser(Map map);
	/**
	 * 插入用户微信信息
	 * @param map
	 */
	void addUserWxInfo(TAccountWxInfo wxInfo);
}
