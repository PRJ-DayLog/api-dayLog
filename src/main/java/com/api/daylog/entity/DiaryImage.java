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
@Table(name = "diary_images")
@NoArgsConstructor(access = PROTECTED)
public class DiaryImage extends BaseDateWithDeletedEntity {

    @Id
    @Column(name = "diary_image_id")
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "diary_id")
    private Diary diary;

    @Column(name = "image_url")
    private String imageUrl;
}
