package com.example.project.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "city")
@Getter
@Setter
@AllArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "City content cannot be empty")
    @Size(max = 255, message = "City content cannot exceed 255 characters")
    private String content;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @NotNull(message = "Country cannot be null")
    private Country country;

    @Column(name = "created_at")
    @NotNull(message = "Creation date cannot be null")
    private LocalDateTime createdAt;

    public City() {
        this.createdAt = LocalDateTime.now();
    }
}
