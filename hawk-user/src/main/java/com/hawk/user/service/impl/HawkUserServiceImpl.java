package com.hawk.user.service.impl;

import com.hawk.user.entity.HawkUser;
import com.hawk.user.mapper.HawkUserMapper;
import com.hawk.user.service.IHawkUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author Hawk
 * @since 2023-03-16
 */
@Service
public class HawkUserServiceImpl extends ServiceImpl<HawkUserMapper, HawkUser> implements IHawkUserService {

}
