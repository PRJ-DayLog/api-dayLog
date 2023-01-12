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
@Table(name = "comments")
@NoArgsConstructor(access = PROTECTED)
public class Comment extends BaseDateEntity {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String content;
}
