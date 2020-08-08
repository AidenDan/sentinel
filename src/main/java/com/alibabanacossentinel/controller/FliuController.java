package com.alibabanacossentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-4-20 14:00:16
 */
@Slf4j
@RestController
public class FliuController {

    @GetMapping("testA")
    public String testA(){
        log.info(Thread.currentThread().getName());
        return "testA";
    }

    @GetMapping("testB")
    public String testB(){
        return "testB";
    }

    @GetMapping("testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD");
        return "testD";
    }

    /**
     * 热点key限流
     *
     * @param p1 p1
     * @param p2 p2
     * @return testHotKey
     */
    @GetMapping("testE")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                                                @RequestParam(value = "p2", required = false) String p2){
        return "testHotKey";
    }

    /**
     * 兜底的方法，当请求的次数超过了阀值就会调用这个方法
     *
     * @param p1 p1
     * @param p2 p2
     * @param e e
     * @return deal_testHotKey
     */
    private String deal_testHotKey(String p1, String p2, BlockException e){
        return "deal_testHotKey";
    }
}
