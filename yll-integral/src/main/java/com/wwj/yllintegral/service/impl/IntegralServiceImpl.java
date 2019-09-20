package com.wwj.yllintegral.service.impl;

import com.wwj.yllintegral.domain.emtity.Integral;
import com.wwj.yllintegral.mapper.IntegralMapper;
import com.wwj.yllintegral.service.IntegralService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.beans.Transient;
import java.util.List;
@Slf4j
@Service
public class IntegralServiceImpl implements IntegralService {
    @Resource
    IntegralMapper integralMapper;


    /**
     * 在插入数据的时候，确定好积分
     * @param integral
     * @return
     */

    @Override
    public int insertByIntegral(Integral integral) {
        //拿到操作数 正还是负
        String status = integral.getIntegralStatus();
        Integer number = integral.getIntegralNumber();
        Integer userId = integral.getUserId();
        int rows = integralMapper.insertReturnId(integral);

        if(rows>0){
            //拿到插入后的主键id
            Integer id = integral.getIntegralId();
            //根据时间排序 找出最新的插入的数据消息 改变其积分总数
            List<Integral> integralList = integralMapper.selectByIntegralId(userId);

            //如果第一次
            if (integralList.size()==1){
                //操作
                int updateSumRows = integralMapper.updateSum(status, number, id);
                return updateSumRows;
            }else {
                //拿出最近的积分总数
                Integer sum =0;
                //修改总积分
                for (int i = 0; i < integralList.size(); i++) {
                    if(i == 1){
                        sum = integralList.get(1).getIntegralSum();
                        break;
                    }
                }
                if(status=="0"){
                    sum =number+sum;
                    int updateSum = integralMapper.updateSum(status, sum, id);
                    return updateSum;
                }else {
                    sum -=number;
                    if(sum<0){
                        return 0;
                    }
                    int updateSum = integralMapper.updateSum(status, sum, id);
                    return updateSum;
                }
            }
        }
        return 0;
    }

    @Override
    public List<Integral> showMsg(int userId, Integer status) {
        /**
         * 新用户送100积分
         */
        List<Integral> integralList = integralMapper.selectByIntegralStatus(userId, status);

        return integralList;
    }


}
