package com.nhnacademy.residentmanage.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Users")
public class User {
    @Id
    @Column(name = "member_id")
    private String memberId;
    private String name;
    private String pwd;
    @OneToOne(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Authority authority;
}
