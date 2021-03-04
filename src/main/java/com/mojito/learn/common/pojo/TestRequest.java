package com.mojito.learn.common.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author liufengqiang
 * @date 2021-02-20 14:58:07
 */
@Data
public class TestRequest {

    @NotNull(message = "预约信息不能为空")
    private Byte buyType;
}
