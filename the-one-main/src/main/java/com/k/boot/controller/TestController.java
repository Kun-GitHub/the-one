
package com.k.boot.controller;

import com.k.boot.common.exception.ResultException;
import com.k.boot.common.result.Result;
import com.k.boot.common.result.ResultCodeEnum;
import com.k.boot.common.validator.ValidatorUtil;
import com.k.boot.entity.BaseEntity;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *
 * @author K.
 * @Email hot_kun@hotmail.com
 * @date 2021-09-07 14:33
 */
@RestController
@RequestMapping("/")
@Api(tags = "***")
public class TestController {

    @PostMapping("captcha")
    @ResponseBody
    public Result captcha(@Valid @RequestBody BaseEntity baseEntity) {

        throw new ResultException(ResultCodeEnum.FAILED.getCode(),"3rwerqwer");

//        System.out.println(baseEntity.getSex());

//        return new Result();
    }

}
