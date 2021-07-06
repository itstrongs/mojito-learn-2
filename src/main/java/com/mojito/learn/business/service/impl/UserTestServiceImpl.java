package com.mojito.learn.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mojito.learn.business.mapper.UserTestMapper;
import com.mojito.learn.business.entity.UserTest;
import com.mojito.learn.business.service.UserTestService;
import org.springframework.stereotype.Service;

/**
 * @author liufengqiang
 * @date 2021-06-24 14:34:44
 */
@Service
public class UserTestServiceImpl extends ServiceImpl<UserTestMapper, UserTest> implements UserTestService {
}
