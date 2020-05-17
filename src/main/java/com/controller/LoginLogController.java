package com.controller;

import com.github.pagehelper.PageInfo;
import com.model.LoginLog;
import com.service.LoginLogService;
import com.utils.RequestParamsUtil;
import com.utils.ResultVOUtil;
import com.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 登录记录Controller
 *
 * @author Clrvn
 */
@RestController
@RequestMapping("/loginLog")
public class LoginLogController {

    @Autowired
    private LoginLogService loginLogService;

    /**
     * 查询登录记录页面
     *
     * @return 分页登录记录数据
     */
    @GetMapping("/page")
    public PageInfo<LoginLog> page() {
        return loginLogService.page(new RequestParamsUtil());
    }

    /**
     * 查询登录记录列表
     */
    @GetMapping("/list")
    public ResultVO list() {
        List<LoginLog> loginLogList = loginLogService.list(new RequestParamsUtil().getParameters());
        return ResultVOUtil.success(loginLogList);
    }

    /**
     * 通过id查询单个登录记录
     */
    @GetMapping("/findById")
    public ResultVO findById(@RequestParam(value = "id") Integer id) {
        LoginLog loginLog = loginLogService.findById(id);
        return ResultVOUtil.success(loginLog);
    }

    /**
     * 通过map查询单个登录记录
     */
    @GetMapping("/findByMap")
    public ResultVO findByMap() {
        LoginLog loginLog = loginLogService.findByMap(new RequestParamsUtil().getParameters());
        return ResultVOUtil.success(loginLog);
    }

    /**
     * 添加登录记录
     */
    @PostMapping("/save")
    public ResultVO save(@RequestBody LoginLog loginLog) {
        loginLogService.save(loginLog);
        return ResultVOUtil.success();
    }

    /**
     * 修改登录记录
     */
    @PutMapping("/update")
    public ResultVO update(@RequestBody LoginLog loginLog) {
        loginLogService.update(loginLog);
        return ResultVOUtil.success();
    }

    /**
     * 删除登录记录
     */
    @DeleteMapping("/deleteById")
    public ResultVO deleteById(@RequestParam(value = "id") Integer id) {
        loginLogService.deleteById(id);
        return ResultVOUtil.success();

    }

}