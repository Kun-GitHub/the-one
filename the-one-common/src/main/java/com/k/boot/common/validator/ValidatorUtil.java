/**
 * Copyright (c) 2016-2019 聚云科技 All rights reserved.
 * <p>
 * http://www.juiniot.com
 * <p>
 * 版权所有，侵权必究！
 */

package com.k.boot.common.validator;

import com.k.boot.common.exception.ResultException;
import com.k.boot.common.result.ResultCodeEnum;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * hibernate-validator校验工具类
 *
 * @author K.
 * @Email hot_kun@hotmail.com
 * @date 2021-04-20 20:28
 */
public class ValidatorUtil {
    private static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     *
     * @author K.
     * @Email hot_kun@hotmail.com
     * @date 2021-04-20 21:16
     * @param object
     * @param groups
     */
    public static void validateEntity(Object object, Class<?>... groups)
            throws ResultException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            ConstraintViolation<Object> constraint = constraintViolations.iterator().next();
            throw new ResultException(ResultCodeEnum.FAILED.getCode(), constraint.getMessage());
        }
    }
}
