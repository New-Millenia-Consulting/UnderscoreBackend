package com.Underscore.UnderscoreBackend.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class MetricSnapshot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String snapshotName;

    private Date date;

    private Integer motionWeight;

    private Integer stepWeight;

    private Integer weatherWeight;

    private Integer temperatureWeight;

    @PrePersist
    protected void onCreate() {
        date = new Date();
    }

    public void setDefaultValues() {
        motionWeight = 2;
        weatherWeight = 2;
        stepWeight = 2;
        temperatureWeight = 2;
    }
}
