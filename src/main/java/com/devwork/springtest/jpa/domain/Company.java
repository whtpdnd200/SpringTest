package com.devwork.springtest.jpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor // 매개 변수 없는 기본 생성자 어노테이션
@AllArgsConstructor // 모든 멤버 변수를 채우고 생성하는 생성자 어노테이션
@Builder(toBuilder = true) // 객체 생성시 특정 멤버 변수의 값만 채우면서 생성 할 수 있게 해주는 어노테이션
@Getter // 게터 생성 어노테이션
@Table(name = "`company`") // db의 테이블 이름을 명시해서 어떤 테이블의 엔티티인지 정의하는 어노테이션?
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String business;
    private String scale;
    private int headcount;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


}
