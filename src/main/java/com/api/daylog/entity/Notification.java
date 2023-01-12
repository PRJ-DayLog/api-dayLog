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
@Table(name = "notifications")
@NoArgsConstructor(access = PROTECTED)
public class Notification extends BaseDateEntity {

    @Id
    @Column(name = "notification_id")
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "send_user_id")
    private User sendUser;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "receiver_user_id")
    private User receiverUser;

    @Column(name = "content")
    private String content;

    @Column(name = "diary_url")
    private String diaryUrl;
}
