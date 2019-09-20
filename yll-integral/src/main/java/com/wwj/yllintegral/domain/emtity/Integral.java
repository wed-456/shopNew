package com.wwj.yllintegral.domain.emtity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Integral {
    /**
     * 积分的数据id
     */
    @TableId
    private Integer integralId;

    private Integer userId;

    /**
     * 积分获取详情
     */
    private String integralContent;

    /**
     * 积分数据的创建时间
     */
    private Date createTime;

    /**
     * 0为增加，1为减少
     */
    private String integralStatus;

    /**
     * 总分
     */
    private Integer integralSum;

    /**
     * 操作的积分数
     */

    private Integer integralNumber;
}