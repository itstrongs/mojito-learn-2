package com.mojito.learn.demo.mq;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-07-17 15:47
 */
@Data
@AllArgsConstructor
public class OrderPaidEvent implements Serializable {

    public OrderPaidEvent() {
    }

    private String orderId;

    private BigDecimal paidMoney;
}
