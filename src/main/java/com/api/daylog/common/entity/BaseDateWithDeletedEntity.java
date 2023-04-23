package com.api.daylog.common.entity;


import com.api.daylog.common.converter.BooleanToYnConverter;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseDateWithDeletedEntity {

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    @Column(name = "deleted_yn", length = 1)
    @Convert(converter = BooleanToYnConverter.class)
    private boolean isDeleted;

    @Column(name = "deleted_date")
    private LocalDateTime deletedDate;
}
