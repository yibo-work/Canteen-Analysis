package com.service.impl;

import com.dao.SchoolDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.model.School;
import com.service.SchoolService;
import com.utils.RequestParamsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 学院ServiceImpl
 *
 * @author Clrvn
 */
@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolDao schoolDao;

    /**
     * 查询学院页面
     *
     * @return 分页学院数据
     */
    @Override
    public PageInfo<School> page(RequestParamsUtil requestParamsUtil) {
        PageHelper.startPage(requestParamsUtil.getPageNo(), requestParamsUtil.getPageSize());
        return new PageInfo<>(schoolDao.list(requestParamsUtil.getParameters()));
    }

    /**
     * 查询学院列表
     */
    @Override
    public List<School> list(Map<String, Object> map) {
        return schoolDao.list(map);
    }


    /**
     * 通过code查询单个学院
     */
    @Override
    public School findById(String code) {
        return schoolDao.findById(code);
    }

    /**
     * 通过map查询单个学院
     */
    @Override
    public School findByMap(Map<String, Object> map) {
        return schoolDao.findByMap(map);
    }

    /**
     * 新增学院
     */
    @Override
    public int save(School school) {
        return schoolDao.save(school);
    }

    /**
     * 修改学院
     */
    @Override
    public int update(School school) {
        return schoolDao.update(school);
    }

    /**
     * 删除学院
     */
    @Override
    public int deleteById(String code) {
        return schoolDao.deleteById(code);
    }

}
