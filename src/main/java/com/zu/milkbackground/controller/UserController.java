package com.zu.milkbackground.controller;


import com.zu.milkbackground.Vo.ReturnVo.Response;
import com.zu.milkbackground.Vo.ReturnVo.ResponseEnum;
import com.zu.milkbackground.po.User;
import com.zu.milkbackground.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ky2fe
 * @since 2022-05-02
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public Response loginOrRegister(@RequestBody User user){
        if (user==null||user.getOpenId()==null){
            return Response.error(ResponseEnum.FAIL);
        }
        return userService.LoginOrRegisterAble(user);
    }
}
