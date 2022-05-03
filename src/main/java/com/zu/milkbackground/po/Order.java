package com.zu.milkbackground.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author ky2fe
 * @since 2022-05-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("l_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 状态码 1，2，3，4	1是已完成		2是已下单		3是正在制作		4是待取餐
     */
    private Integer status;

    /**
     * 取餐号
     */
    private Integer takeNumber;

    /**
     * 店铺id
     */
    private Integer storeId;

    /**
     * 订单总价
     */
    private BigDecimal orderTotal;

    /**
     * 订单号
     */
    private String orderCode;

    /**
     * 下单时间
     */
    private String orderTime;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 状态名
     */
    private String stateName;

    /**
     * 联系电话
     */
    private String phoneNumber;

    private Integer sumNum;


}
