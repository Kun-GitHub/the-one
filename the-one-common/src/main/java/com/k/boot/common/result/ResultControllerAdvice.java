package com.k.boot.common.result;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.k.boot.common.exception.ResultException;
import com.k.boot.common.validator.NotResponseWrap;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author K.
 * @Email hot_kun@hotmail.com
 * @date 2021年09月03日 16:36
 */
@RestControllerAdvice(basePackages = {"com.k.validator.controller"})
public class ResultControllerAdvice implements ResponseBodyAdvice<Object> {

    /**
     * 对那些方法需要包装，如果接口直接返回Response就没有必要再包装了
     *
     * @param returnType
     * @param aClass
     * @return 如果为true才会执行beforeBodyWrite
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> aClass) {
        return !(returnType.getParameterType().equals(Result.class) || returnType.hasMethodAnnotation(NotResponseWrap.class));
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter returnType, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest request, ServerHttpResponse response) {
        // String类型不能直接包装，所以要进行些特别的处理
        if (returnType.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // 将数据包装在Response里后，再转换为json字符串响应给前端
                return objectMapper.writeValueAsString(new Result(data));
            } catch (JsonProcessingException e) {
                throw new ResultException(ResultCodeEnum.FAILED.getCode());
            }
        }
        // 这里统一包装
        return new Result(data);
    }
}


