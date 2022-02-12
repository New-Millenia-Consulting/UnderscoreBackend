package com.Underscore.UnderscoreBackend.Services;

import com.Underscore.UnderscoreBackend.Models.MetricSnapshot;
import com.Underscore.UnderscoreBackend.Repositories.MetricSnapshotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetricSnapshotService {

    @Autowired
    MetricSnapshotRepository metricSnapshotRepository;

    public MetricSnapshot saveMetricSnapshot(MetricSnapshot metricSnapshot) {
        return metricSnapshotRepository.saveAndFlush(metricSnapshot);
    }

    public MetricSnapshot getLatestMetricSnapshot(String userId) {
        return metricSnapshotRepository.findTopByUserIdOrderByDateDesc(userId);
    }

    public List<MetricSnapshot> getTop10MetricSnapshotsByDate() {
        return metricSnapshotRepository.findTop10ByOrderByDateDesc();
    }
}
