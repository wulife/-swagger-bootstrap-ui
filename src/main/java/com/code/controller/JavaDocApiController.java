package com.code.controller;

import com.code.entity.User;
import com.code.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

/**
 * java api 接口文档测试
 *
 * @author ww
 * @date 2018/8/14
 */
@Api(value="测试接口",description="用户操作", tags={"用户操作接口"})
@RestController
@RequestMapping("/java-api")
public class JavaDocApiController {

    @ApiOperation(value = "测试方法",notes="注意问题点", nickname = "别名")
    @GetMapping(value = "/test")
    public String testApi(@RequestParam(defaultValue = "aasdf") String name){
        return name;
    }

    @ApiOperation(value = "获取用户信息")
    @ApiResponses({
            @ApiResponse(code=666,message="666666"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @PostMapping(value = "/userInfo")
    public User userInfo(@RequestBody User user){
        user.setAge(18);
        user.setPhone("1785015");
        return user;
    }
}
