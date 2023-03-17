package com.hawk.common.base;


import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

/**
 * 实体类基类
 *
 * @author 杨晨
 * @date 2023-03-16
 */
public class BaseClass {

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
