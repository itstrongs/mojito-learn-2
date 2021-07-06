package com.mojito.learn.business.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liufengqiang
 * @date 2021-06-24 14:35:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("user_test")
public class UserTest extends BaseEntity {

    private String mobileNo;
    private String userName;
    private String sex;
}
