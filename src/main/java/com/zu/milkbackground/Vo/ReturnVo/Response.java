package com.zu.milkbackground.Vo.ReturnVo;/**
 * Created by Ky2Fe on 2022/5/2 16:35
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Ky2Fe
 * @program: milk-background
 * @description: 统一返回类
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private long code;
    private String message;
    private Object data;



    public static Response success(Object data){
        return new Response(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMessage(),data);
    }


    public static Response success(){
        return new Response(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMessage(),null);
    }


    public static Response error(ResponseEnum resultEnum, Object data){
        return new Response(resultEnum.getCode(), resultEnum.getMessage(), data);
    }

    public static Response error(ResponseEnum resultEnum){
        return new Response(resultEnum.getCode(), resultEnum.getMessage(), null);
    }
}