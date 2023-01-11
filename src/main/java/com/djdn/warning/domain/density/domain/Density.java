package com.djdn.warning.domain.density.domain;

import com.djdn.warning.domain.camera.domain.Camera;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_density")
@Entity
public class Density {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "density_id")
    private Long id;

    @Column(nullable = false)
    private int people;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camera_id", nullable = false)
    private Camera camera;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Builder
    public Density(int people, Camera camera) {
        this.people = people;
        this.camera = camera;
    }
}
