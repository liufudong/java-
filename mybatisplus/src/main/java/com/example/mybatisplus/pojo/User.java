package com.example.mybatisplus.pojo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    private String id;
    private String name;
    private int age;
    private String email;
}
