package com.mojito.learn.test;

import com.mojito.learn.common.pojo.TestRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liufengqiang
 * @date 2020-12-10 18:28:16
 */
@RestController
@RequestMapping("/test")
public class TestController {

//    @GetMapping
//    public Response mybatis() {
//        cloudDiskService.save(BaseHelper.r2t(request, CloudDiskDo.class));
//        return Response.ok();
//    }

    @PostMapping
    public String test1(@RequestBody TestRequest request) {
        Integer reservationFlag;
        if (request.getBuyType() != null) {
            reservationFlag = request.getBuyType().intValue();
        } else {
            reservationFlag = 0;
        }
        return "reservationFlag==>" + reservationFlag;
    }
}
