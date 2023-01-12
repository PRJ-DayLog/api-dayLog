package com.api.daylog.entity;

import com.api.daylog.common.entity.BaseDateWithDeletedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = PROTECTED)
public class User extends BaseDateWithDeletedEntity {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

}
