package com.example.demospringpact.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Person {
    private Long id;
    private String name;
    private int age;
}
