package com.zu.milkbackground.DTO;/**
 * Created by Ky2Fe on 2022/5/3 13:57
 */

import com.zu.milkbackground.Vo.CommodityVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: Ky2Fe
 * @program: milk-background
 * @description: 创建订单
 **/

@Data
@EqualsAndHashCode(callSuper = false)
public class CreateOrderDTO {

    private Integer userId;

    private String phoneNumber;

    private String remarks;

    private BigDecimal orderTotal;

    private Integer sumNum;

    private List<CommodityVo> commodities;

    private StoreInfoDTO storeInfo;
}
