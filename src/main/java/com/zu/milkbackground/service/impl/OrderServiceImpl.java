package com.zu.milkbackground.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zu.milkbackground.DTO.CreateOrderDTO;
import com.zu.milkbackground.Vo.CommodityVo;
import com.zu.milkbackground.Vo.OrderDetailVo;
import com.zu.milkbackground.Vo.ProductDetailVo;
import com.zu.milkbackground.Vo.ReturnVo.OrderVo;
import com.zu.milkbackground.mapper.OrderDetailMapper;
import com.zu.milkbackground.mapper.OrderMapper;
import com.zu.milkbackground.po.Order;
import com.zu.milkbackground.po.OrderDetail;
import com.zu.milkbackground.service.IOrderService;
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
    public OrderDetailVo OrderDetailAble(Integer userId, Integer orderId) {
        OrderDetailVo orderDetail = orderMapper.findOrderDetail(userId, orderId);
        List<ProductDetailVo> productDetail=orderMapper.findProductDetail(orderId);
        orderDetail.setProductDetail(productDetail);
        return orderDetail;
    }

    @Override
    public List<OrderVo> AllOrderInfoAble(Integer userId) {
        List<OrderVo> orderList = orderMapper.findAllOrder(userId);
        for(OrderVo order:orderList){
            List<ProductDetailVo> productDetail = orderMapper.findProductDetail(order.getId());
            order.setProductDetail(productDetail);
        }
        return orderList;
    }

    /**
     * 创建订单
     * @param dto
     * @return
     */
    @Override
    public int CreateOrderAble(CreateOrderDTO dto) {
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
        return order.getId();
    }
}
