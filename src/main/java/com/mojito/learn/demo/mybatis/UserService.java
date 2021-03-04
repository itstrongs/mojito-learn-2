package com.mojito.learn.demo.mybatis;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-04-23 14:34
 */
public interface UserService {

    User findByUserIdAndAnnotation(Long userId);

    User findByUserIdAndXml(Long userId);
}
