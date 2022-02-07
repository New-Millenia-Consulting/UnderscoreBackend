package com.Underscore.UnderscoreBackend.Services;

import com.Underscore.UnderscoreBackend.Models.MetricSnapshot;
import com.Underscore.UnderscoreBackend.Repositories.MetricSnapshotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetricSnapshotService {

    @Autowired
    MetricSnapshotRepository metricSnapshotRepository;

    public MetricSnapshot saveMetricSnapshot(MetricSnapshot metricSnapshot) {
        System.out.println(metricSnapshot.toString());
        return metricSnapshotRepository.saveAndFlush(metricSnapshot);
    }
}
