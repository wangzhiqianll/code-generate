package com.domain;

import lombok.Data;


/**
 * 
 * @Description TODO
 * @author ansen.zhu
 * @date 2019年3月19日
 */
@Data
public class Column {

    private String columnName;
    private String columnDataType;
    private String columnKey;
    private String columnComment;
    private String uppercaseAttrName;
    private String lowercaseAttrName;
    private String javaDataType;

}
