package com.zhengke.pojo;

import java.io.Serializable;

public class SysDictionary implements Serializable {
    private String dicId;

    private String dicName;

    private Integer createrId;

    private String createTime;

    private Integer alterId;

    private String alterTime;

    public String getDicId() {
        return dicId;
    }

    public void setDicId(String dicId) {
        this.dicId = dicId == null ? null : dicId.trim();
    }

    public String getDicName() {
        return dicName;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName == null ? null : dicName.trim();
    }

    public Integer getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Integer createrId) {
        this.createrId = createrId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Integer getAlterId() {
        return alterId;
    }

    public void setAlterId(Integer alterId) {
        this.alterId = alterId;
    }

    public String getAlterTime() {
        return alterTime;
    }

    public void setAlterTime(String alterTime) {
        this.alterTime = alterTime == null ? null : alterTime.trim();
    }
}