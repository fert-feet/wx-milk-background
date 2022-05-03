package com.zu.milkbackground.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zu.milkbackground.Vo.OrderDetailVo;
import com.zu.milkbackground.Vo.ProductDetailVo;
import com.zu.milkbackground.Vo.ReturnVo.OrderVo;
import com.zu.milkbackground.po.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ky2fe
 * @since 2022-05-02
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    @Select("SELECT\n" +
            "\ta.*,\n" +
            "\tb.store_name,\n" +
            "\tb.address \n" +
            "FROM\n" +
            "\tl_order a,\n" +
            "\tl_store b \n" +
            "WHERE\n" +
            "\ta.store_id = b.id \n" +
            "\tAND a.user_id = #{userId} \n" +
            "\tAND a.id =#{orderId}")
    OrderDetailVo findOrderDetail(Integer userId, Integer orderId);

    @Select("SELECT\n" +
            "\ta.product_name,\n" +
            "\ta.img_url,\n" +
            "\ta.price,\n" +
            "\tb.number \n" +
            "FROM\n" +
            "\tl_commodity a,\n" +
            "\tl_order_detail b \n" +
            "WHERE\n" +
            "\tb.commodity_id = a.id \n" +
            "\tAND b.order_id =#{orderId}")
    List<ProductDetailVo> findProductDetail(Integer orderId);

    @Select("SELECT\n" +
            "\ta.id,\n" +
            "\ta.state_name,\n" +
            "\ta.order_time,\n" +
            "\ta.order_total,\n" +
            "\ta.`status`,\n" +
            "\ta.take_number,\n" +
            "\tb.store_name,\n" +
            "\ta.sum_num \n" +
            "FROM\n" +
            "\tl_store b,\n" +
            "\tl_order a \n" +
            "WHERE\n" +
            "\ta.store_id = b.id \n" +
            "\tAND user_id =#{userId}")
    List<OrderVo> findAllOrder(Integer userId);
}
