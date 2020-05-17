package com.controller;

import com.github.pagehelper.PageInfo;
import com.model.School;
import com.service.SchoolService;
import com.utils.RequestParamsUtil;
import com.utils.ResultVOUtil;
import com.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学院Controller
 * @author Clrvn
 */
@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    /**
     * 查询学院页面
     * @return 分页学院数据
     */
    @GetMapping("/page")
    public PageInfo<School> page() {
        return schoolService.page(new RequestParamsUtil());
    }

    /**
     * 查询学院列表
     */
    @GetMapping("/list")
    public ResultVO list() {
        List<School> schoolList = schoolService.list(new RequestParamsUtil().getParameters());
        return ResultVOUtil.success(schoolList);
    }

    /**
     * 通过code查询单个学院
     */
    @GetMapping("/findById")
    public ResultVO findById(@RequestParam(value = "code") String code) {
        School school =schoolService.findById(code);
        return ResultVOUtil.success(school);
    }

    /**
     * 通过map查询单个学院
     */
    @GetMapping("/findByMap")
    public ResultVO findByMap() {
        School school =schoolService.findByMap(new RequestParamsUtil().getParameters());
        return ResultVOUtil.success(school);
    }

    /**
     * 添加学院
     */
    @PostMapping("/save")
    public ResultVO save(@RequestBody School school) {
        try{
            schoolService.save(school);
            return ResultVOUtil.success();
        }catch (Exception ex){
            return ResultVOUtil.failure("添加失败！");
        }
    }

    /**
     * 修改学院
     */
    @PutMapping("/update")
    public ResultVO update(@RequestBody School school) {
        try{
            schoolService.update(school);
            return ResultVOUtil.success();
        }catch (Exception ex){
            return ResultVOUtil.failure("修改失败！");
        }

    }

    /**
     * 删除学院
     */
    @DeleteMapping("/deleteById")
    public ResultVO deleteById(@RequestParam(value = "code") String code) {
        try{
            schoolService.deleteById(code);
            return ResultVOUtil.success();
        }catch (Exception ex){
            return ResultVOUtil.failure("删除失败！");
        }
    }

}