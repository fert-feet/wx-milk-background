package com.zu.milkbackground.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

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
@TableName("l_commodity")
public class Commodity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String productName;

    private String detailRemarks;

    private String imgUrl;

    private BigDecimal price;


}
