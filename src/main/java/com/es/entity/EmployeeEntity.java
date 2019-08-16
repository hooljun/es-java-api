package com.es.entity;

import com.es.util.IndexName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/**
 * EmployeeEntity
 * @date 2019/8/12
 * @author luohaipeng
 */
@Data
@IndexName("employee-1")
public class EmployeeEntity {
    private Long id;
    private String name;
    private Integer age;
    private String about;
    private List<Map<String, Object>> roleList;
}
