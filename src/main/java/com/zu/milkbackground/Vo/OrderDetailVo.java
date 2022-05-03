package com.zu.milkbackground.Vo;/**
 * Created by Ky2Fe on 2022/5/2 17:40
 */

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author: Ky2Fe
 * @program: milk-background
 * @description: 返回订单细节
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderDetailVo  {
    private Integer id;

    private Integer status;

    private Integer takeNumber;

    private Integer userId;

    private BigDecimal orderTotal;

    private String orderCode;

    private Date orderTime;

    private String remarks;

    private String stateName;

    private String phoneNumber;

    private Integer storeId;

    private String storeName;

    private String address;

    private List<ProductDetailVo> productDetail;

}
