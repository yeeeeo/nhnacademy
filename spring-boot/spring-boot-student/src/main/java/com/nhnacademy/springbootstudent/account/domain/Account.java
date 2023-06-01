package com.nhnacademy.springbootstudent.account.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class Account {
    private final Long id;
    private final String number;
    private final Integer balance;
}
