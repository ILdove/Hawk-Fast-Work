package com.hawk.common.api;


import java.util.Date;

/**
 * 实体类基类
 *
 * @author 杨晨
 * @date 2023-03-16
 */
public class CommonEntity {

    private Date createTime;

    private Date updateTime;

    private String order;

    private String sort;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
