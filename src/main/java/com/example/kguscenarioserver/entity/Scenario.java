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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scenario_num")
    private Long id;
    private String memo;
    @Column(columnDefinition = "TEXT")
    private String result;
    @Column(name = "created_at")
    private Timestamp createdAt;

    @PrePersist
    protected void onCreate(){
        createdAt = new Timestamp(System.currentTimeMillis());
    }
}
