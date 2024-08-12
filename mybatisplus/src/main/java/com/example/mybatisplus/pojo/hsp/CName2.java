package com.example.mybatisplus.pojo.hsp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CName2 {
    private String cname;
    private String cid;
    private List<SName2> list;
}
