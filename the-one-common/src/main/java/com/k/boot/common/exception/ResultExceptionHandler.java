package com.k.boot.common.exception;

import com.k.boot.common.result.Result;
import com.k.boot.common.result.ResultCodeEnum;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author K.
 * @Email hot_kun@hotmail.com
 * @date 2021年09月03日 16:15
 */
@RestControllerAdvice
public class ResultExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return new Result().error(ResultCodeEnum.BAD_REQUEST.getCode(), objectError.getDefaultMessage());
    }

    @ExceptionHandler(ResultException.class)
    public Result<String> APIExceptionHandler(ResultException e) {
        return new Result().error(e.getCode(), e.getMessage());
    }
}
