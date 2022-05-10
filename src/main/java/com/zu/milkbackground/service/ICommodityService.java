package com.zu.milkbackground.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zu.milkbackground.Vo.CommodityVo;
import com.zu.milkbackground.po.Commodity;
import com.zu.milkbackground.utils.returnUtils.Response;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ky2fe
 * @since 2022-05-02
 */
public interface ICommodityService extends IService<Commodity> {

    /**
     * 查询所有商品
     *
     * @return
     */
    Response CommodityInfoAble();
}
