package com.hawk.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.hawk.common.api.CommonEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author Hawk
 * @since 2023-03-16
 */
@Getter
@Setter
@ApiModel(value="HawkUser对象", description="用户")
public class HawkUser extends CommonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "邮箱")
    private byte[] email;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "禁用状态(0 正常 1 被禁用)")
    private String isDisabled;
}
