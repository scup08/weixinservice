package com.lzh.weixinservice.controller;



import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.lzh.common.model.dto.response.ObjectDataResponse;
import com.lzh.weixinservice.config.WeixinConstant;
import com.lzh.weixinservice.feignService.WXService;
import com.lzh.weixinservice.model.dto.WeixinDto;
import com.lzh.weixinservice.model.dto.WeixinInfo;
import com.lzh.weixinservice.model.entity.TAccountUser;
import com.lzh.weixinservice.model.entity.TAccountWxInfo;
import com.lzh.weixinservice.service.IAccountService;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping(value="/weixin")
public class WeixinController {
	
	private static Logger logger = (Logger) LoggerFactory.getLogger(WeixinController.class);
	
	@Autowired
	private  WXService wxService;
	
	@Autowired
	private IAccountService accountService;
	/**
	 * 微信登录
	 */
	@RequestMapping(value="/login" ,method=RequestMethod.POST)
	public ObjectDataResponse<WeixinDto> login(@RequestParam("code") String code ){
		
		ObjectDataResponse<WeixinDto> rs = new ObjectDataResponse<WeixinDto>();
		WeixinDto rsDto = new WeixinDto();
		
		String wxrs = wxService.loginCheck(WeixinConstant.APPID, WeixinConstant.SECRET, code, "authorization_code");
		Gson gson = new Gson();
		WeixinInfo wxInfo= gson.fromJson(wxrs, WeixinInfo.class);
		
		//查询用户信息
		TAccountWxInfo taw = accountService.findUserInfoByOpenId(wxInfo);
		if(taw==null || taw.getUserId()==null){
				
			//插入新用户
			Map map = new HashMap(8);
			map.put("openid", wxInfo.getOpenid());
			//map.put("sessionKey", wxInfo.getSession_key());
			TAccountUser tau = accountService.addUser(map);
			taw.setUserId(tau.getUuid());
			//插入用户微信信息
			taw.setAppid(WeixinConstant.APPID);
			taw.setOpenid(openid);
			accountService.addUserWxInfo(taw);
			
		}
		rsDto.setUserId(taw.getUserId());
		rs.setData(rsDto);
		
		return rs;
	}
	
	/**
	 * 添加播放事件
	 * 
	 */
//	@RequestMapping(value="/palyEvent" ,method=RequestMethod.POST )
//	public void palyEvent(@RequestParam("userId") Integer userId,@RequestParam("audioId") Integer audioId){
//		//1.添加到播放历史记录表
//		
//		Map map = new HashMap(8);
//		map.put("userId", 1234);
//		map.put("audioId", audioId);
//		audioService.addPalyEvent(map);
//		//2.播放量加1
//		dynamicInfo(audioId , 2);
//	}
	
}
