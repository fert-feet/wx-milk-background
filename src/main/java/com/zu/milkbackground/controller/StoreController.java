package com.zu.milkbackground.controller;


import com.zu.milkbackground.Vo.ReturnVo.Response;
import com.zu.milkbackground.Vo.ReturnVo.ResponseEnum;
import com.zu.milkbackground.po.Store;
import com.zu.milkbackground.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private IStoreService storeService;

    /**
     * 获取店铺信息
     * @return
     */
    @GetMapping("/info")
    public Response getStoreInfo(){
        List<Store> storeList = storeService.list();
        if (storeList==null){
            return Response.error(ResponseEnum.FAIL);
        }
        return Response.success(storeList);
    }
}
