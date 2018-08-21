package com.code.util;

import com.code.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 返回结果封装类
 *
 * @author ww
 * @date 2018/8/14
 */
@ApiModel(value = "返回体")
public class ResultUtil<T> {
    @ApiModelProperty(value = "返回状态码", example = "200")
    private Integer code;
    @ApiModelProperty(value = "返回状态", example = "success")
    private String msg;
    @ApiModelProperty(value = "返回消息体", example = "{key:value}")
    private T data;

    public static ResultUtil success() {
        return new ResultUtil<>(200, "success");
    }
    public static <W> ResultUtil success(W data){
        return new ResultUtil<>(200, "success", data);
    }

    public ResultUtil(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultUtil(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
