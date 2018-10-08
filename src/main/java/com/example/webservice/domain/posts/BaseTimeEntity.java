package com.example.webservice.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 해당 클래스를 상속할 경우, 그 안의 멤버 필드 변수를 컬럼으로 인식하도록 함
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate //시간 자동 저장
    private LocalDateTime createdDate;
    @LastModifiedDate //조회한 Entity의 값을 변경시킬 때 자동으로 시간 저장 
    private LocalDateTime modifiedDate;
}
