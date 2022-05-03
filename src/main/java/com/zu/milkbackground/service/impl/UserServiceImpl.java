package com.zu.milkbackground.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zu.milkbackground.Vo.ReturnVo.Response;
import com.zu.milkbackground.mapper.UserMapper;
import com.zu.milkbackground.po.User;
import com.zu.milkbackground.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录或注册
     * @param user
     * @return
     */
    @Override
    public Response LoginOrRegisterAble(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id","nick_name","avatar_url","member_score").eq("open_id",user.getOpenId());
        User userInfo = userMapper.selectOne(queryWrapper);
        if(userInfo==null){
            user.setMemberScore("5");
            userMapper.insert(user);
            return Response.success(user);
        }
        return Response.success(userInfo);
    }
}
