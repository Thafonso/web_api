package org.github.thafonso.project_api_springboot.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String productName;

    @Column(nullable = false, scale = 2)
    private Long productPrice;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @PrePersist
    public void prepersist(){
        this.createdAt = OffsetDateTime.now();
    }

}
