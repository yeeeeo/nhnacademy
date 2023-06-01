package com.nhnacademy.springbootstudent.student.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class
Student {
    private final Long id;
    private final String name;
    private final Integer score;
}
