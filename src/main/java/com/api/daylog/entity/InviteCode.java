package com.api.daylog.entity;

import com.api.daylog.common.entity.BaseDateEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Table(name = "invited_codes")
@NoArgsConstructor(access = PROTECTED)
public class InviteCode extends BaseDateEntity {

    @Id
    @Column(name = "invited_code_id")
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column(name = "invited_code")
    private String invitedCode;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
