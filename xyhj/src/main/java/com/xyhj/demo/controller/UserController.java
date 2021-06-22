package com.xyhj.demo.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyhj.demo.annotation.PassAspect;
import com.xyhj.demo.base.Result;
import com.xyhj.demo.base.ResultGenerator;
import com.xyhj.demo.base.RetEnum;
import com.xyhj.demo.bean.User;
import com.xyhj.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author 12623
 */
@RestController
@RequestMapping(value="/users")
@Api
public class UserController {

    @Autowired
    private UserService userService;
    
    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value={""}, method= RequestMethod.GET)
    public List<User> getUserList() {
        Wrapper<User> wrapper = new QueryWrapper<>();
        IPage<User> iPage = new Page<>();
        userService.page(iPage, wrapper);
        PaginationInterceptor interceptor = new PaginationInterceptor();
        return null;
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="", method=RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        userService.save(user);
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        return userService.getOne(wrapper);
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @PutMapping("{id}")
    public String putUser(@PathVariable Long id, @RequestBody User user) {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("id",id);
        boolean update = userService.update(user, wrapper);
        return update ? "success" : "fail";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    // 对参数进行描述,     参数名称        描述          是否必须        参数类型            paramType传参方式 path query body header form
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        boolean remove = userService.remove(wrapper);
        return remove ? "success" : "fail";
    }
    
    @GetMapping("/selectList")
    public List<User> selectList() {
        return userService.selectList();
    }
    
    @PostMapping(value = "/import", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "导入")
    public Result importDealerPartsTransferOrderDetail(@RequestParam("file") MultipartFile file, HttpServletResponse response) {
        userService.importDealerPartsTransferOrderDetail(file, response);
        return ResultGenerator.genSuccessResult(RetEnum.SUCCESS);
    }

}