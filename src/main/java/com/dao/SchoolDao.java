package com.dao;

import com.model.School;

import java.util.List;
import java.util.Map;


/**
 * 学院DAO
 *
 * @author Clrvn
 */
public interface SchoolDao {

    /**
     * 通过code查询单个学院
     */
    School findById(String code);

    /**
     * 通过map查询单个学院
     */
    School findByMap(Map<String, Object> map);

    /**
     * 查询学院列表
     */
    List<School> list(Map<String, Object> map);

    /**
     * 新增学院
     */
    int save(School school);

    /**
     * 修改学院
     */
    int update(School school);

    /**
     * 删除学院
     */
    int deleteById(String code);

}
