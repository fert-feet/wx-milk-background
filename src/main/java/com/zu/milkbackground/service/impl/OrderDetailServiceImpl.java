package com.zu.milkbackground.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zu.milkbackground.mapper.OrderDetailMapper;
import com.zu.milkbackground.po.OrderDetail;
import com.zu.milkbackground.service.IOrderDetailService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ky2fe
 * @since 2022-05-02
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements IOrderDetailService {

}
