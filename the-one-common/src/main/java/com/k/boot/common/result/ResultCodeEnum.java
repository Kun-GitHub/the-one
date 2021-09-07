package com.k.boot.common.result;

import com.k.boot.common.utils.MessageUtil;
import lombok.Getter;

/**
 * 1**	信息，服务器收到请求，需要请求者继续执行操作
 * 2**	成功，操作被成功接收并处理
 * 3**	重定向，需要进一步的操作以完成请求
 * 4**	客户端错误，请求包含语法错误或无法完成请求
 * 5**	服务器错误，服务器在处理请求的过程中发生了错误
 * 参考：https://www.runoob.com/http/http-status-codes.html
 *
 * 其他错误编码，由5位数字组成，前2位为模块编码，后3位为业务编码
 * <p>
 * 如：60001（60代表系统模块，001代表业务代码）
 * </p>
 *
 * @author K.
 * @Email hot_kun@hotmail.com
 * @date 2021年09月03日 16:21
 */
@Getter
public enum ResultCodeEnum {
    SUCCESS(200, "请求成功"),
    FAILED(500, "服务器内部错误，无法完成请求"),
    BAD_REQUEST(400, "客户端请求的语法错误，服务器无法理解");



    private Integer code;
    private String message;

    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.message = msg;
    }
}


