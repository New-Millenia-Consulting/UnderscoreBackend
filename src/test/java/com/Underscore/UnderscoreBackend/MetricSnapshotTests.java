package com.Underscore.UnderscoreBackend;

import com.Underscore.UnderscoreBackend.Models.MetricSnapshot;
import com.Underscore.UnderscoreBackend.Repositories.MetricSnapshotRepository;
import com.Underscore.UnderscoreBackend.Services.MetricSnapshotService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest @Transactional
class MetricSnapshotTests {

    @Autowired
    MetricSnapshotService metricSnapshotService;

    @Autowired
    MetricSnapshotRepository metricSnapshotRepository;

    @Test
    void saveMetricSnapshot() {
        String userId = "Zain";
        MetricSnapshot metricSnapshot = new MetricSnapshot();
        metricSnapshot.setUserId(userId);
        metricSnapshot = metricSnapshotService.saveMetricSnapshot(metricSnapshot);
        MetricSnapshot metricSnapshotFromDb = metricSnapshotRepository.getById(metricSnapshot.getId());
        assertThat(metricSnapshotFromDb).isNotNull();
        assertThat(metricSnapshotFromDb.getDate()).isNotNull();
        assertThat(metricSnapshotFromDb.getId()).isNotNull();
        assertThat(metricSnapshotFromDb.getUserId()).isEqualTo(userId);
    }

    @Test
    void getLatestMetricSnapshot() {
        String userId = "Zain";
        String newMotionValue = "New Motion Value";
        MetricSnapshot metricSnapshot = new MetricSnapshot();
        metricSnapshot.setUserId(userId);
        metricSnapshotService.saveMetricSnapshot(metricSnapshot);
        metricSnapshot = new MetricSnapshot();
        metricSnapshot.setUserId(userId);
        metricSnapshot.setMotionValue(newMotionValue);
        metricSnapshotService.saveMetricSnapshot(metricSnapshot);
        MetricSnapshot metricSnapshotFromDb = metricSnapshotService.getLatestMetricSnapshot(userId);
        assertThat(metricSnapshotFromDb).isNotNull();
        assertThat(metricSnapshotFromDb.getDate()).isNotNull();
        assertThat(metricSnapshotFromDb.getId()).isNotNull();
        assertThat(metricSnapshotFromDb.getMotionValue()).isEqualTo(newMotionValue);
    }

}