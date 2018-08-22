package com.lzh.weixinservice.feignService;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "WXService",url = "https://api.weixin.qq.com")
public interface WXService {

	
	@RequestMapping(value="/sns/jscode2session",method=RequestMethod.GET)
	public String loginCheck(@RequestParam(value = "appid")String appid,@RequestParam(value = "secret")String secret,@RequestParam(value = "js_code")String js_code,@RequestParam(value = "grant_type")String grant_type);
}
