package com.Underscore.UnderscoreBackend.Controllers;

import com.Underscore.UnderscoreBackend.Models.MetricSnapshot;
import com.Underscore.UnderscoreBackend.Services.MetricSnapshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/metric-snapshot")
public class MetricSnapshotController {

    @Autowired
    MetricSnapshotService metricSnapshotService;

    @PostMapping(value = "")
    public MetricSnapshot saveMetricSnapshot(@RequestBody MetricSnapshot metricSnapshot) {
        return metricSnapshotService.saveMetricSnapshot(metricSnapshot);
    }

    @PostMapping(value = "/id")
    public MetricSnapshot loadMetricSnapshotById(@RequestBody LinkedHashMap<String,Long> body) {
        Long id = body.get("id");
        return metricSnapshotService.getSnapshotById(id);
    }

    @GetMapping(value = "/latest")
    public List<MetricSnapshot> getLastListOfMetricSnapshots() {
        return metricSnapshotService.getTop10MetricSnapshotsByDate();
    }

    @PostMapping(value = "/latest/userId")
    public MetricSnapshot getLatestMetricSnapshot(@RequestBody LinkedHashMap<String,String> body) {
        String userId = body.get("userId");
        MetricSnapshot metricSnapshot = metricSnapshotService.getLatestMetricSnapshot(userId);
        if(metricSnapshot == null) {
            return getDefaultMetricSnapshot(userId);
        }
        return metricSnapshot;
    }

    private MetricSnapshot getDefaultMetricSnapshot(String userId) {
        MetricSnapshot metricSnapshot = new MetricSnapshot();
        metricSnapshot.setDefaultValues();
        return metricSnapshot;
    }
}
