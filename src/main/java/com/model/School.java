package com.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 学院
 *
 * @author Clrvn
 */
@Data
public class School implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学院编号
     */
    private String code;

    /**
     * 学院名称
     */
    private String name;


}
