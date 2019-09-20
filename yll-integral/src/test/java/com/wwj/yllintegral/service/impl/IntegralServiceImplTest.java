package com.wwj.yllintegral.service.impl;

import com.wwj.yllintegral.domain.emtity.Integral;
import com.wwj.yllintegral.service.IntegralService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class IntegralServiceImplTest {
    @Resource
    IntegralService integralService;
    @Test
    public void insertByIntegral() {
        Integral integral = new Integral();
        integral.setUserId(1);
        integral.setIntegralContent("消费");
        integral.setIntegralNumber(50);
        integral.setIntegralStatus("1");
        int rows = integralService.insertByIntegral(integral);
        log.debug(rows+"");
    }
}