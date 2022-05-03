package com.zu.milkbackground.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zu.milkbackground.Vo.CommodityVo;
import com.zu.milkbackground.po.Commodity;
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
public interface CommodityMapper extends BaseMapper<Commodity> {

    @Select("SELECT\n" +
            "\t* \n" +
            "FROM\n" +
            "\tl_commodity")
    List<CommodityVo> findAll();
}
