package com.wwj.yllintegral.controller;

import com.wwj.yllintegral.domain.emtity.Integral;
import com.wwj.yllintegral.service.IntegralService;
import com.wwj.yllintegral.utility.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class IntegralController {
    @Resource
    IntegralService integralService;
    @GetMapping("/show")
    public Result show(Integer userId,Integer status){
        try{
            List<Integral> integralList = integralService.showMsg(userId, status);
            return Result.success(integralList);
        }catch (Exception e){
            log.debug(e.getMessage());
        }
        return Result.error();
    }
}
