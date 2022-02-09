package com.Underscore.UnderscoreBackend.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Track {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String title;

    private String mp3;

    @ElementCollection
    private List<Integer> cuePoints;

    private String imageBackground;
}
