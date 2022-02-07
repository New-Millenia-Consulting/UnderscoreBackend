package com.Underscore.UnderscoreBackend.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class MetricSnapshot {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String userId;

    private String motionValue;

    private Integer motionWeight;
}
