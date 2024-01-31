package com.example.testproject.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@MappedSuperclass // 상속하는 Entity에 컬럼을 추가하기 위해 필요한 어노테이션
@EntityListeners(AuditingEntityListener.class) // Listener에서 받아서 특정 행동을 하는(저장되는 시점 이전인지 이후인지)
public class BaseEntity {

    @CreatedDate
    @Column(updatable = false) // 데이터 임의 변경 불가
    private LocalDateTime createdAt;

    /*
    @CreatedBy
    @Column(updatable = false)
    private String createdBy;
    */

    @LastModifiedDate
    private LocalDateTime updatedAt;

    /*
    @LastModifiedBy
    private String updatedBy;
    */

}
