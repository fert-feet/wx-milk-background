package com.zu.milkbackground.Vo;/**
 * Created by Ky2Fe on 2022/5/2 20:47
 */

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @author: Ky2Fe
 * @program: milk-background
 * @description: 订单商品细节
 **/

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductDetailVo {
    private Integer id;

    private String stateName;

    private String imgUrl;

    private BigDecimal price;

    private String productName;

    private Integer number;
}
