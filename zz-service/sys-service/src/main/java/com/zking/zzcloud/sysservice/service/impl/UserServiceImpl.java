package com.zking.zzcloud.sysservice.service.impl;

import com.zking.zzcloud.sysservice.model.User;
import com.zking.zzcloud.sysservice.mapper.UserMapper;
import com.zking.zzcloud.sysservice.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 凌
 * @since 2020-04-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
