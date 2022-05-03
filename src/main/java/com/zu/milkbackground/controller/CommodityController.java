package com.zu.milkbackground.controller;


import com.zu.milkbackground.Vo.CommodityVo;
import com.zu.milkbackground.Vo.ReturnVo.Response;
import com.zu.milkbackground.Vo.ReturnVo.ResponseEnum;
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
        List<CommodityVo> commodityList=commodityService.CommodityInfoAble();
        if (commodityList == null) {
            return Response.error(ResponseEnum.FAIL);
        }
        return Response.success(commodityList);
    }
}
