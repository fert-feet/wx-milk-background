package com.zu.milkbackground.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zu.milkbackground.DTO.CreateOrderDTO;
import com.zu.milkbackground.Vo.CommodityVo;
import com.zu.milkbackground.Vo.OrderDetailVo;
import com.zu.milkbackground.Vo.ProductDetailVo;
import com.zu.milkbackground.Vo.OrderVo;
import com.zu.milkbackground.mapper.OrderDetailMapper;
import com.zu.milkbackground.mapper.OrderMapper;
import com.zu.milkbackground.po.Order;
import com.zu.milkbackground.po.OrderDetail;
import com.zu.milkbackground.service.IOrderService;
import com.zu.milkbackground.utils.redisUtils.RedisService;
import com.zu.milkbackground.utils.returnUtils.Response;
import com.zu.milkbackground.utils.returnUtils.ResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ky2fe
 * @since 2022-05-02
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;


    /**
     * 根据用户Id和订单Id查询订单细节
     * @param userId
     * @param orderId
     * @return
     */
    @Override
    public Response OrderDetailAble(Integer userId, Integer orderId) {
        OrderDetailVo orderDetail = orderMapper.findOrderDetail(userId, orderId);
        System.out.println(orderDetail);
        if (orderDetail != null) {
            List<ProductDetailVo> productDetail=orderMapper.findProductDetail(orderId);
            orderDetail.setProductDetail(productDetail);
            return Response.success(orderDetail);
        };
        return Response.error(ResponseEnum.FAIL);
    }

    @Override
    public Response AllOrderInfoAble(Integer userId) {
        List<OrderVo> orderVos = (List<OrderVo>) redisService.getRT("orderList");
        if (orderVos!=null){
            return Response.success(orderVos);
        }
        List<OrderVo> orderList = orderMapper.findAllOrder(userId);
        if (orderList!=null){
            for(OrderVo order:orderList){
                List<ProductDetailVo> productDetail = orderMapper.findProductDetail(order.getId());
                order.setProductDetail(productDetail);
            }
            redisService.setRT("orderList",orderList);
            redisService.setTime("orderList",200);
            return Response.success(orderList);
        }
        return Response.error(ResponseEnum.FAIL);
    }

    /**
     * 创建订单
     *
     * @param dto
     * @return
     */
    @Override
    public Response CreateOrderAble(CreateOrderDTO dto) {
        Random random = new Random();
        String orderCode= UUID.randomUUID().toString().replace("-","");
        LocalDateTime nowTime = LocalDateTime.now();
        String orderTime = nowTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Order order = new Order();
        order.setTakeNumber(random.nextInt(400));
        order.setStoreId(dto.getStoreInfo().getId());
        order.setOrderTotal(dto.getOrderTotal());
        order.setOrderCode(orderCode);
        order.setOrderTime(orderTime);
        order.setRemarks(dto.getRemarks());
        order.setUserId(dto.getUserId());
        order.setStateName("已下单");
        order.setPhoneNumber(dto.getPhoneNumber());
        order.setSumNum(dto.getSumNum());
        orderMapper.insert(order);
        for(CommodityVo commodity:dto.getCommodities()){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(order.getId());
            orderDetail.setCommodityId(commodity.getId());
            orderDetail.setNumber(commodity.getNumber());
            orderDetailMapper.insert(orderDetail);
        }
        if (order.getId()>=1){
            redisService.remove("orderList");
            return Response.success(order.getId());
        }
        return Response.error(ResponseEnum.FAIL);
    }
}
