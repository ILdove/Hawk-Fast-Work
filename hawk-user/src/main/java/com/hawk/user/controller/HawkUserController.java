package com.hawk.user.controller;


import com.hawk.user.dto.LoginDto;
import com.hawk.user.service.IHawkUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author Hawk
 * @since 2023-03-16
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户接口")
@Tag(name = "HawkUserController", description = "用户管理")
public class HawkUserController {

    @Autowired
    private IHawkUserService userService;

    @PostMapping("login")
    @ApiOperation("登录")
    public void login(@RequestBody LoginDto loginDto) {

    }
}
