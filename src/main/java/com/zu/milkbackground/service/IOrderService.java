package com.zu.milkbackground.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zu.milkbackground.DTO.CreateOrderDTO;
import com.zu.milkbackground.Vo.OrderDetailVo;
import com.zu.milkbackground.Vo.ReturnVo.OrderVo;
import com.zu.milkbackground.po.Order;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ky2fe
 * @since 2022-05-02
 */
public interface IOrderService extends IService<Order> {

    /**
     * 根据用户Id和订单Id查询订单细节
     *
     * @param userId
     * @param orderId
     * @return
     */
    OrderDetailVo OrderDetailAble(Integer userId, Integer orderId);

    /**
     * 根据用户id查询所有订单
     * @param userId
     * @return
     */
    List<OrderVo> AllOrderInfoAble(Integer userId);

    /**
     * 创建订单
     * @param dto
     * @return
     */
    int CreateOrderAble(CreateOrderDTO dto);
}
