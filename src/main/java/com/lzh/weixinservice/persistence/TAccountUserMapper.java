package com.lzh.weixinservice.persistence;

import com.lzh.common.persistence.CrudMapper;
import com.lzh.weixinservice.model.entity.TAccountUser;

public interface TAccountUserMapper extends CrudMapper {
    int deleteByPrimaryKey(Long uuid);

    int insert(TAccountUser record);

    int insertSelective(TAccountUser record);

    TAccountUser selectByPrimaryKey(Long uuid);

    int updateByPrimaryKeySelective(TAccountUser record);

    int updateByPrimaryKey(TAccountUser record);
}