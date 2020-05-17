package com.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户
 *
 * @author Clrvn
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键自增id
     */
    private Integer id;

    /**
     * 工号
     */
    private String userNo;

    /**
     * 姓名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 角色，1、管理员 2、教师
     */
    private Integer roleId;


}
