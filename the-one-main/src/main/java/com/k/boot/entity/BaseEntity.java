package com.k.boot.entity;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 基础实体类
 *
 * @author K.
 * @Email hot_kun@hotmail.com
 * @date 2021-04-21 8:53
 */
@Data
public class BaseEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("所属楼栋 ")
    @NotBlank(message = "旧手机号码不能为空")
    private String name;

    @ApiModelProperty("所属楼栋 ")
    @NotBlank(message = "fasdfasdfafasd")
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
