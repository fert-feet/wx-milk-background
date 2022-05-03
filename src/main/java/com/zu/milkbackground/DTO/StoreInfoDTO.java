package com.zu.milkbackground.DTO;/**
 * Created by Ky2Fe on 2022/5/3 14:05
 */

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: Ky2Fe
 * @program: milk-background
 * @description: 订单创建接收商店信息类
 **/

@Data
@EqualsAndHashCode(callSuper = false)
public class StoreInfoDTO {

    private Integer id;

    private String storeName;

    private String address;
}
