package com.wwj.yllintegral.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wwj.yllintegral.domain.emtity.Integral;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IntegralMapper extends BaseMapper<Integral> {

    /**
     * 返回插入时的id
     */
    int insertReturnId(@Param("Integral") Integral integral);

    /**
     * 修改总积分
     */
    int updateSum(@Param("status") String status,@Param("number") int number,
                  @Param("integralId")int integtalId);

    /**
     * 按照时间排序 查询最新的积分记录
     */
    List<Integral> selectByIntegralId(@Param("userId")int userId);

    /**
     * 默认值为查询所有，状态值查询
     */
    List<Integral> selectByIntegralStatus(@Param("userId")int usrId,@Param("status") Integer status);

}