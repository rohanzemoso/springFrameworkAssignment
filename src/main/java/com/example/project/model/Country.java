package com.example.project.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "country")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "cities")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Country name cannot be empty")
    @Size(max = 100, message = "Country name cannot exceed 100 characters")
    private String name;

    @NotEmpty(message = "Travelled from cannot be empty")
    @Size(max = 100, message = "Travelled from cannot exceed 100 characters")
    private String travelledFrom;

    @Column(name = "created_at")
    @NotNull(message = "Creation date cannot be null")
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<City> cities;

    @Transient
    public String getFormattedCreatedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return createdAt.format(formatter);
    }
}
