package com.api.daylog.entity;

import com.api.daylog.common.entity.BaseDateWithDeletedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Table(name = "diarys")
@NoArgsConstructor(access = PROTECTED)
public class Diary extends BaseDateWithDeletedEntity {

    @Id
    @Column(name = "diary_id")
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "map_y")
    private float mapY;

    @Column(name = "map_x")
    private float mapX;

    @Column(name = "diary_date")
    private LocalDateTime diaryDate;

}
