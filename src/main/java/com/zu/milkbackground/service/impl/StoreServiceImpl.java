package com.zu.milkbackground.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zu.milkbackground.mapper.StoreMapper;
import com.zu.milkbackground.po.Store;
import com.zu.milkbackground.service.IStoreService;
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
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store> implements IStoreService {

    @Autowired
    private StoreMapper storeMapper;

}
