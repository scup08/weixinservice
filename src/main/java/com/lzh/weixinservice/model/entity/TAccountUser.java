package com.lzh.weixinservice.model.entity;

import java.util.Date;

public class TAccountUser {
    private Long uuid;

    private Date createTime;

    private Integer usableFlag;

    private String mobile;

    private String loginPwd;

    private String pwdSalt;

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUsableFlag() {
        return usableFlag;
    }

    public void setUsableFlag(Integer usableFlag) {
        this.usableFlag = usableFlag;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd == null ? null : loginPwd.trim();
    }

    public String getPwdSalt() {
        return pwdSalt;
    }

    public void setPwdSalt(String pwdSalt) {
        this.pwdSalt = pwdSalt == null ? null : pwdSalt.trim();
    }
}