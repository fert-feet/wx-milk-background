package com.zu.milkbackground.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author ky2fe
 * @since 2022-05-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("l_store")
public class Store implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 店铺名称
     */
    private String storeName;

    /**
     * 是否营业
     */
    private Boolean status;

    /**
     * 距离
     */
    private Double distance;

    /**
     * 店铺电话号码
     */
    private String hotLine;

    /**
     * 是否收藏
     */
    private Boolean isCollection;

    /**
     * 营业开始时间
     */
    private Date beginTime;

    /**
     *  营业结束时间
     */
    private Date endTime;

    /**
     * 地址
     */
    private String address;


}
