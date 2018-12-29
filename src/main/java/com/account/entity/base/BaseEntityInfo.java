package com.account.entity.base;

import org.thymeleaf.util.StringUtils;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Administrator
 * @Date: 2018 2018/7/22 10 31
 **/
public class BaseEntityInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    // 状态
    protected String status;
    // 版本号
    protected int version;

    // 修改时间
    @Column(name = "edit_time")
    protected Date modifyTime;

    // 创建时间
    protected Date createTime;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
