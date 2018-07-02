package com.zw.base.controller;

import com.wordnik.swagger.annotations.*;
import com.zw.base.model.Code;
import com.zw.base.model.User;
import com.zw.base.service.CodeService;
import com.zw.base.service.UtilsService;
import com.zw.common.vo.code.CodeListFind;
import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zhaowei on 2017/12/11.
 */
@Api("code")
@Controller("codeAction")
@Scope("prototype")
@RequestMapping("/cfmy/code")
public class CodeCtrl {

    @Autowired
    CodeService codeService;
    @Autowired
    UtilsService utilsService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加", httpMethod = "POST", notes = "添加")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "添加")})
    public ResponseVo add(
            @ApiParam(required = true, value = "code", name = "code") @RequestBody Code code,
            HttpServletRequest request
    ) {


        return codeService.add(code);
    }

    @ResponseBody
    @RequestMapping(value = "/list/{pageNum}/{pageSize}", method = RequestMethod.POST)
    @ApiOperation(value = "获取所有用户列表", httpMethod = "POST", notes = "获取用户")
    public ResponseVo<PageVo<List<User>>> List(
            @ApiParam(required = true, value = "当前页面", name = "pageNum") @PathVariable Integer pageNum,
            @ApiParam(required = true, value = "每页显示条数", name = "pageSize") @PathVariable Integer pageSize,
            @ApiParam(required = true, value = "codeListFind", name = "codeListFind") @RequestBody CodeListFind codeListFind
    ) {

        return codeService.list(pageNum, pageSize, codeListFind);
    }

    @ResponseBody
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    @ApiOperation(value = "根据id获取", httpMethod = "GET", notes = "获取")
    public ResponseVo<User> getById(
            @ApiParam(required = true, value = "Id", name = "Id") @RequestParam String id
    ) {
        return codeService.getById(id);
    }


    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "更新", httpMethod = "POST", notes = "更新")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "更新")})
    public ResponseVo update(
            @ApiParam(required = true, value = "code", name = "code") @RequestBody Code code
    ) {
        return codeService.update(code);
    }

    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    @ApiOperation(value = "根据id删除", httpMethod = "GET", notes = "删除")
    public ResponseVo<User> del(
            @ApiParam(required = true, value = "id", name = "id") @RequestParam String id
    ) {
        return codeService.del(id);
    }
}
