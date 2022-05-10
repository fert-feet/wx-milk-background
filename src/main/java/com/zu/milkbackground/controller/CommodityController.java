package com.zu.milkbackground.controller;


import com.zu.milkbackground.Vo.CommodityVo;
import com.zu.milkbackground.utils.redisUtils.RedisService;
import com.zu.milkbackground.utils.returnUtils.Response;
import com.zu.milkbackground.utils.returnUtils.ResponseEnum;
import com.zu.milkbackground.service.ICommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    private ICommodityService commodityService;

    /**
     * 获取商品信息
     * @return
     */
    @GetMapping("/info")
    public Response getCommodityInfo(){
        return commodityService.CommodityInfoAble();
    }
}
