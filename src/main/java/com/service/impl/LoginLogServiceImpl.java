package com.service.impl;

import com.dao.LoginLogDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.model.LoginLog;
import com.service.LoginLogService;
import com.utils.RequestParamsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 登录记录ServiceImpl
 *
 * @author Clrvn
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    private LoginLogDao loginLogDao;

    /**
     * 查询登录记录页面
     *
     * @return 分页登录记录数据
     */
    @Override
    public PageInfo<LoginLog> page(RequestParamsUtil requestParamsUtil) {
        PageHelper.startPage(requestParamsUtil.getPageNo(), requestParamsUtil.getPageSize());
        return new PageInfo<>(loginLogDao.list(requestParamsUtil.getParameters()));
    }

    /**
     * 查询登录记录列表
     */
    @Override
    public List<LoginLog> list(Map<String, Object> map) {
        return loginLogDao.list(map);
    }


    /**
     * 通过id查询单个登录记录
     */
    @Override
    public LoginLog findById(Integer id) {
        return loginLogDao.findById(id);
    }

    /**
     * 通过map查询单个登录记录
     */
    @Override
    public LoginLog findByMap(Map<String, Object> map) {
        return loginLogDao.findByMap(map);
    }

    /**
     * 新增登录记录
     */
    @Override
    public int save(LoginLog loginLog) {
        return loginLogDao.save(loginLog);
    }

    /**
     * 修改登录记录
     */
    @Override
    public int update(LoginLog loginLog) {
        return loginLogDao.update(loginLog);
    }

    /**
     * 删除登录记录
     */
    @Override
    public int deleteById(Integer id) {
        return loginLogDao.deleteById(id);
    }

}
