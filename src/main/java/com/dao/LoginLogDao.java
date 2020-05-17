package com.dao;

import com.model.LoginLog;

import java.util.List;
import java.util.Map;


/**
 * 登录记录DAO
 *
 * @author Clrvn
 */
public interface LoginLogDao {

    /**
     * 通过id查询单个登录记录
     */
    LoginLog findById(Integer id);

    /**
     * 通过map查询单个登录记录
     */
    LoginLog findByMap(Map<String, Object> map);

    /**
     * 查询登录记录列表
     */
    List<LoginLog> list(Map<String, Object> map);

    /**
     * 新增登录记录
     */
    int save(LoginLog loginLog);

    /**
     * 修改登录记录
     */
    int update(LoginLog loginLog);

    /**
     * 删除登录记录
     */
    int deleteById(Integer id);

}
