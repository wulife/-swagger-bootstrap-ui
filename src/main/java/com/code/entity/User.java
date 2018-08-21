package com.code.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 测试用户类
 *
 * @author ww
 * @date 2018/8/14
 */
@ApiModel(description="用户表user")
public class User {
    @ApiModelProperty(value = "用户名", example = "wwei")
    private String username;
    @ApiModelProperty(value = "性别", example = "man")
    private String sex;
    @ApiModelProperty(value = "手机", example = "178501")
    private String phone;
    @ApiModelProperty(value = "年龄", example = "16")
    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
