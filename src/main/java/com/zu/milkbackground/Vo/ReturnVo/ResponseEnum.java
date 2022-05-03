package com.zu.milkbackground.Vo.ReturnVo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by Ky2Fe on 2022/5/2 16:30
 */

@Getter
@ToString
@AllArgsConstructor
public enum ResponseEnum {

    FAIL(800,"后台错误"),


    SUCCESS(200,"成功"),



    ;


    private final Integer code;
    private final String message;
}

