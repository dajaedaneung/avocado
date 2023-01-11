package com.djdn.warning.domain.density.domain;

import com.djdn.warning.domain.camera.domain.Camera;
import com.djdn.warning.domain.density.presentation.dto.type.Code;
import com.djdn.warning.global.constant.Person;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_density")
@Entity
@Slf4j
public class Density {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "density_id")
    private Long id;

    @Column(nullable = false)
    private int people;

    @ManyToOne(fetch = FetchType.EAGER)
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

    public int getDensity() {
        return (int) (((Person.AREA * people) / (double) camera.getArea()) * 100);
    }

    public Code getCode() {
        int density = getDensity();

        for (Code c : Code.values()) {
            if (c.getMin() <= density && density <= c.getMax()) {
                return c;
            }
        }

        return null;
    }
}
