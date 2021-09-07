
package com.k.boot.controller;

import com.k.boot.common.result.Result;
import com.k.boot.common.validator.ValidatorUtil;
import com.k.boot.entity.BaseEntity;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

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
    public Result captcha(@RequestBody BaseEntity baseEntity) {

//        if(bindingResult.hasErrors()){
//            return new Result().error(bindingResult.getFieldError().getDefaultMessage());
//        }

//        throw new ResultException(ResultCode.PARAMS_ERROR,"3rwerqwer");
//        ValidatorUtil.validateEntity(baseEntity);

//        System.out.println(baseEntity.getSex());

        return new Result();
    }

}
