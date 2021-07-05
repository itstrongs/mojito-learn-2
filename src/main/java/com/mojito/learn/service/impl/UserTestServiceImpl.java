package com.mojito.learn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mojito.learn.mapper.UserTestMapper;
import com.mojito.learn.pojo.entity.UserTest;
import com.mojito.learn.service.UserTestService;
import org.springframework.stereotype.Service;

/**
 * @author liufengqiang
 * @date 2021-06-24 14:34:44
 */
@Service
public class UserTestServiceImpl extends ServiceImpl<UserTestMapper, UserTest> implements UserTestService {
}
