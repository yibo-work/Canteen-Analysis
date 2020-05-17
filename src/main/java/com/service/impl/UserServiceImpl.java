package com.service.impl;

import com.dao.UserDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.model.ImportLog;
import com.model.User;
import com.service.UserService;
import com.utils.RequestParamsUtil;
import com.utils.XLSConvertCSVUtil;
import com.utils.XLSXCovertCSVUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * 用户ServiceImpl
 *
 * @author Clrvn
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 查询用户页面
     *
     * @return 分页用户数据
     */
    @Override
    public PageInfo<User> page(RequestParamsUtil requestParamsUtil) {
        PageHelper.startPage(requestParamsUtil.getPageNo(), requestParamsUtil.getPageSize());
        return new PageInfo<>(userDao.list(requestParamsUtil.getParameters()));
    }

    /**
     * 查询用户列表
     */
    @Override
    public List<User> list(Map<String, Object> map) {
        return userDao.list(map);
    }


    /**
     * 通过id查询单个用户
     */
    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    /**
     * 通过map查询单个用户
     */
    @Override
    public User findByMap(Map<String, Object> map) {
        return userDao.findByMap(map);
    }

    /**
     * 新增用户
     */
    @Override
    public int save(User user) {
        return userDao.save(user);
    }

    /**
     * 修改用户
     */
    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    /**
     * 删除用户
     */
    @Override
    public int deleteById(Integer id) {
        return userDao.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void importUser(File file) throws Exception {
        // 解析excel的第一个sheet页，导入全部资质的数据
        int columnsForRead = 2;
        List<List<String>> list;
        if (file.getName().toLowerCase().endsWith(".xlsx")) {
            list = XLSXCovertCSVUtil.readXLSX(file, 1, 2, columnsForRead);
        } else {
            list = XLSConvertCSVUtil.readXLS(file, 1, 2, columnsForRead);
        }

        for (List<String> strings : list) {
            User user = new User();
            user.setUserNo(strings.get(0));
            user.setName(strings.get(1));
            //角色为教师
            user.setRoleId(2);
            //默认密码000000
            user.setPassword("000000");
            userDao.save(user);
        }
    }

}
