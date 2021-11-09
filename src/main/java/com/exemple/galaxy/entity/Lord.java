package com.exemple.galaxy.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "LORD")
@NoArgsConstructor
public class Lord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @NotNull
    @Column(name = "NAME")
    private String name;
    @NotNull
    @Column(name = "AGE")
    private int age;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Planet> planets = new HashSet<>();

    public Lord(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
