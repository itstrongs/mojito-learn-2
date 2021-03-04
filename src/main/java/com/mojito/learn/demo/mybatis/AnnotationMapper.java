package com.mojito.learn.demo.mybatis;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-04-23 14:35
 */
@Component
@Mapper
public interface AnnotationMapper {

    @Select("select * from sys_user where id = #{id}")
    @Results(id = "learnMap", value = {
            @Result(column = "id", property = "id", javaType = Long.class)
    })
    User findByUserId(@Param("id") Long id);
}
