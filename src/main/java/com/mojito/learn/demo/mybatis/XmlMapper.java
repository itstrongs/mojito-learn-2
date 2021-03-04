package com.mojito.learn.demo.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-04-23 16:08
 */
@Component
@Mapper
public interface XmlMapper {

    User findByUserId(Long id);
}
