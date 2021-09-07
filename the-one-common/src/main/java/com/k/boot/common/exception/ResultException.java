

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

    public ResultException(int code, String msg) {
        super();
        this.code = code;
        this.message = msg;
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
