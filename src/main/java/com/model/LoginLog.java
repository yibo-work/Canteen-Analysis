package com.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录记录
 *
 * @author Clrvn
 */
@Data
public class LoginLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键自增id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 登录时间
     */
    private Date createTime;

    /**
     * 用户名
     */
    private String userName;

}
