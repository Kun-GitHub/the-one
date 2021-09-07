package com.k.boot.common.result;

import com.k.boot.common.utils.MessageUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 接口返回实体
 *
 * @author K.
 * @Email hot_kun@hotmail.com
 * @date 2021年09月02日 14:28
 */
@ApiModel(value="接口返回实体", description="接口返回实体")
@Data
public class Result<T> implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 返回处理消息
     * code=200 请求处理成功
     * code!=200 请求处理失败, 消息提示：message内容
     */
    @ApiModelProperty(value = "返回处理消息")
    private String message = ResultCodeEnum.SUCCESS.getMessage();

    /**
     * 请求处理状态
     * 200: 请求处理成功
     * 500: 请求处理失败
     * 401: 请求未认证，跳转登录页
     * 406: 请求未授权，跳转未授权提示页
     * 具体见ResultCodeEnum
     */
    @ApiModelProperty(value = "请求处理状态")
    private Integer code = ResultCodeEnum.SUCCESS.getCode();

    /**
     * 返回数据对象 data
     */
    @ApiModelProperty(value = "返回数据对象")
    private T result;

    /**
     * 时间戳
     */
    @ApiModelProperty(value = "时间戳")
    private long timestamp = System.currentTimeMillis();

    /** 默认成功*/
    public Result(){}

    public Result(T data){
        this.result = data;
    }

    public Result<T> success(T data){
        this.result = data;
        return this;
    }

    public boolean success(){
        return code == 200;
    }

    public Result<T> error(Integer code, String msg){
        this.code = code;
        this.message = msg;
        return this;
    }

    public Result<T> error(String msg){
        this.code = ResultCodeEnum.FAILED.getCode();;
        this.message = msg;
        return this;
    }

}
