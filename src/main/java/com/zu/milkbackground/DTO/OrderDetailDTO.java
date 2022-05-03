package com.zu.milkbackground.DTO;/**
 * Created by Ky2Fe on 2022/5/2 20:23
 */

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: Ky2Fe
 * @program: milk-background
 * @description: User接收数据类
 **/

@Data
@EqualsAndHashCode(callSuper = false)
public class OrderDetailDTO {
    private Integer userId;

    private Integer orderId;
}
