package com.lzh.weixinservice.persistence;

import java.util.Map;

import com.lzh.common.persistence.CrudMapper;
import com.lzh.weixinservice.model.entity.TAccountWxInfo;

public interface TAccountWxInfoMapper extends CrudMapper {
    int deleteByPrimaryKey(Long uuid);

    int insert(TAccountWxInfo record);

    int insertSelective(TAccountWxInfo record);

    TAccountWxInfo selectByPrimaryKey(Long uuid);

    int updateByPrimaryKeySelective(TAccountWxInfo record);

    int updateByPrimaryKey(TAccountWxInfo record);
    
    /**
     * 通过openid查询用户信息
     * @param map
     * @return
     */
    TAccountWxInfo findUserInfoByOpenId(Map map);
}