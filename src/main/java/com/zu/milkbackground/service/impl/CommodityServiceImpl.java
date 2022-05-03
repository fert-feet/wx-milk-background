package com.zu.milkbackground.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zu.milkbackground.Vo.CommodityVo;
import com.zu.milkbackground.mapper.CommodityMapper;
import com.zu.milkbackground.po.Commodity;
import com.zu.milkbackground.service.ICommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ky2fe
 * @since 2022-05-02
 */
@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements ICommodityService {

    @Autowired
    private CommodityMapper commodityMapper;

    /**
     * 查询所有商品
     * @return
     */
    @Override
    public List<CommodityVo> CommodityInfoAble() {
        List<CommodityVo> commodityList=commodityMapper.findAll();
        for (CommodityVo commodityVo:commodityList){
            commodityVo.setNumber(0);
        }
        return commodityList;
    }
}
