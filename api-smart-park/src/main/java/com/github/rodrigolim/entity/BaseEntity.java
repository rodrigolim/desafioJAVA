package com.github.rodrigolim.entity;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Getter
@MappedSuperclass
public class BaseEntity extends PanacheEntityBase {

    @Column(name = "DATA_CRIACAO", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "DATA_ALTERACAO")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}