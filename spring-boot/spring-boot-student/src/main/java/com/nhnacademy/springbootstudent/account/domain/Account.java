package com.nhnacademy.springbootstudent.account.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    private Long id;
    private String number;
    private Integer balance;
}
