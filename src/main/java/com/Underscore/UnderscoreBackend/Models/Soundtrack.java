package com.Underscore.UnderscoreBackend.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Soundtrack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String composer;

    @OneToMany
    private List<Track> tracksList;
}
