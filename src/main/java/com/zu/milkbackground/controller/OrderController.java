package com.zu.milkbackground.controller;


import com.zu.milkbackground.DTO.CreateOrderDTO;
import com.zu.milkbackground.DTO.OrderDetailDTO;
import com.zu.milkbackground.Vo.OrderDetailVo;
import com.zu.milkbackground.Vo.ReturnVo.OrderVo;
import com.zu.milkbackground.Vo.ReturnVo.Response;
import com.zu.milkbackground.Vo.ReturnVo.ResponseEnum;
import com.zu.milkbackground.po.Commodity;
import com.zu.milkbackground.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ky2fe
 * @since 2022-05-02
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    /**
     * 查询订单详情
     * @param dto
     * @return
     */
    @PostMapping("/detail")
    public Response getOrderDetailInfo(@RequestBody OrderDetailDTO dto){
        if (dto==null||dto.getUserId()==null||dto.getOrderId()==null){
            return Response.error(ResponseEnum.FAIL);
        }
        OrderDetailVo orderDetail=orderService.OrderDetailAble(dto.getUserId(),dto.getOrderId());
        if (orderDetail==null){
            return Response.error(ResponseEnum.FAIL);
        }
        return Response.success(orderDetail);
    }

    /**
     * 查询用户所有订单
     * @param dto
     * @return
     */
    @PostMapping("/info")
    public Response getAllOrderInfo(@RequestBody OrderDetailDTO dto){
        if (dto==null||dto.getUserId()==null){
            return Response.error(ResponseEnum.FAIL);
        }
        List<OrderVo> orderList=orderService.AllOrderInfoAble(dto.getUserId());
        if(orderList==null){
            return Response.error(ResponseEnum.FAIL);
        }
        return Response.success(orderList);
    }

    /**
     * 新建订单
     * @param dto
     * @return
     */
    @PostMapping("/create")
    public Response createOrder(@RequestBody CreateOrderDTO dto){
        System.out.println(dto);
        if (dto==null||dto.getUserId()==null||dto.getStoreInfo()==null){
            return Response.error(ResponseEnum.FAIL);
        }
        int orderId= orderService.CreateOrderAble(dto);
        if(orderId<1){
            return Response.error(ResponseEnum.FAIL);
        }
        return Response.success(orderId);
    }
}
