package com.example.kguscenarioserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Scenario {
    //인덱스 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scenario_num")
    private Long id;
    //특이사항 메모 공간
    private String memo;
    //조합된 scenario 한줄로 저장
    @Column(columnDefinition = "TEXT")
    private String result;
    //시나리오 생성된 시간
    @Column(name = "created_at")
    private Timestamp createdAt;

    @PrePersist
    protected void onCreate(){
        createdAt = new Timestamp(System.currentTimeMillis());
    }
}
