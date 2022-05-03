package com.zu.milkbackground.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zu.milkbackground.Vo.ReturnVo.Response;
import com.zu.milkbackground.po.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ky2fe
 * @since 2022-05-02
 */
public interface IUserService extends IService<User> {

    /**
     * 登录或注册
     * @param user
     * @return
     */
    Response LoginOrRegisterAble(User user);
}
