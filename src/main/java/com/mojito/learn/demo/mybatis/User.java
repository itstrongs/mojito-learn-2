package com.mojito.learn.demo.mybatis;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-04-23 13:51
 */
@Getter
@Setter
public class User {

    private Long id;
    /**
     * 手机号
     */
    private String mobileNo;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String portrait;
    /**
     * 标签 ,分割
     */
    private String tags;
    /**
     * 最后一次登录时间
     */
    private Date lastLoginAt;
    /**
     * 个性签名
     */
    private String signature;
}
