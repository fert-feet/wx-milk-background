package com.zu.milkbackground.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ky2fe
 * @since 2022-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("l_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像url
     */
    private String avatarUrl;

    /**
     * 积分
     */
    private String memberScore;

    /**
     * 用户唯一标识
     */
    private String openId;


}
