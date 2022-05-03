package com.zu.milkbackground.Vo;/**
 * Created by Ky2Fe on 2022/5/2 23:36
 */

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @author: Ky2Fe
 * @program: milk-background
 * @description: 商品封装
 **/

@Data
@EqualsAndHashCode(callSuper = false)
public class CommodityVo {
    private Integer id;

    private String productName;

    private String detailRemarks;

    private String imgUrl;

    private BigDecimal price;

    private Integer number;
}
