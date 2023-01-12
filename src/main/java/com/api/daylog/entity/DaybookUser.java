package com.api.daylog.entity;

import com.api.daylog.common.entity.BaseDateWithDeletedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Table(name = "daybook_users")
@NoArgsConstructor(access = PROTECTED)

public class DaybookUser extends BaseDateWithDeletedEntity {

    @Id
    @Column(name = "daybook_user_id")
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "daybook_id")
    private Daybook daybook;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "connect_user_id")
    private User connectUser;
}
