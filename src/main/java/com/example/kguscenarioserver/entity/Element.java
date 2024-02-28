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
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "element_id")
    private Long id;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String name;
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private Element parent;

    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }

}
