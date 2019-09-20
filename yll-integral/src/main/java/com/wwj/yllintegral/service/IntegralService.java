package com.wwj.yllintegral.service;

import com.wwj.yllintegral.domain.emtity.Integral;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IntegralService {


    /**
     * 添加新的积分数据
     */
    int insertByIntegral(Integral integral);

    /**
     * 展示积分使用情况
     */
    List<Integral> showMsg(int userId,Integer status);


}
