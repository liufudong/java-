package com.example.mybatisplus.pojo.hsp;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class EmpBean {
    private String empNo;
    private String eName;
    private String job;
    private String mgr;
    private String hireDate;
    private String sal;
    private String comm;
    private String deptNo;
    private DeptBean deptBean;


}
