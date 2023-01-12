package com.api.daylog.entity;

import com.api.daylog.common.entity.BaseDateWithDeletedEntity;
import com.api.daylog.common.enums.DaybookType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Table(name = "daybooks")
@NoArgsConstructor(access = PROTECTED)
public class Daybook extends BaseDateWithDeletedEntity {

    @Id
    @Column(name = "daybook_id")
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "daybook_type")
    private DaybookType daybookType;

    @Column(name = "daybook_date")
    private LocalDateTime daybookDate;

}
