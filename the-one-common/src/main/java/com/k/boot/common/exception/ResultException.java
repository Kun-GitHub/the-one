

package com.k.boot.common.exception;

import com.k.boot.common.result.ResultCodeEnum;
import com.k.boot.common.utils.MessageUtil;
import lombok.Data;

/**
 *
 * 自定义异常
 * @author K.
 * @Email hot_kun@hotmail.com
 * @date 2021-04-20 21:01
 */
@Data
public class ResultException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message = ResultCodeEnum.SUCCESS.getMessage();
    private Integer code = ResultCodeEnum.SUCCESS.getCode();

    public ResultException(int code){
        this.code = code;
        this.message = MessageUtil.getMessage(code);
    }

    public ResultException(int code, String... params){
        this.code = code;
        this.message = MessageUtil.getMessage(code, params);
    }

    public ResultException(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public ResultException(int code, Throwable e){
        super(e);
        this.code = code;
        this.message = MessageUtil.getMessage(code);
    }

    public ResultException(int code, Throwable e, String... params){
        super(e);
        this.code = code;
        this.message = MessageUtil.getMessage(code, params);
    }

    public ResultException(String msg){
        super(msg);
        this.code = ResultCodeEnum.FAILED.getCode();
        this.message = msg;
    }

    public ResultException(String msg, Throwable e){
        super(msg, e);
        this.code = ResultCodeEnum.FAILED.getCode();
        this.message = msg;
    }



}
