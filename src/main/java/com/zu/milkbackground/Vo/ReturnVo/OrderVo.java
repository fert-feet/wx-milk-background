package com.zu.milkbackground.Vo.ReturnVo;/**
 * Created by Ky2Fe on 2022/5/2 21:22
 */

import com.zu.milkbackground.Vo.ProductDetailVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author: Ky2Fe
 * @program: milk-background
 * @description: 所有订单查询
 **/

@Data
@EqualsAndHashCode(callSuper = false)
public class OrderVo {

    private Integer id;

    private String stateName;

    private Date orderTime;

    private BigDecimal orderTotal;

    private Integer status;

    private Integer takeNumber;

    private String storeName;

    private Integer sumNum;

    private List<ProductDetailVo> productDetail;
}
