package com.mojito.learn.demo.mybatis;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-04-23 14:35
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private AnnotationMapper userMapper;
    @Resource
    private XmlMapper xmlMapper;

    @Override
    public User findByUserIdAndAnnotation(Long userId) {
        return userMapper.findByUserId(userId);
    }

    @Override
    public User findByUserIdAndXml(Long userId) {
        return xmlMapper.findByUserId(userId);
    }
}
