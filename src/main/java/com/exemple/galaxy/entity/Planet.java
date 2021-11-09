package com.exemple.galaxy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@Table(name = "PLANET")
@NoArgsConstructor
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PLANET_ID")
    private Long id;
    @Column(name = "PLANET_NAME")
    private String name;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
    @JoinColumn(name="lord")
    private Lord lord;

    public Planet(String name) {
        this.name = name;
    }
}
