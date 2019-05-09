package com.domain;


import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 
 * @Description TODO
 * @author ansen.zhu
 * @date 2019年3月19日
 */
@Data
@Builder
public class Table {
	
    private String tableName;
    private Column pk;
    private List<Column> columns;
    private String uppercaseClassName;
    private String lowercaseClassName;

}
