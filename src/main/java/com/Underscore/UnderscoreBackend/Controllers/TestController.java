package com.Underscore.UnderscoreBackend.Controllers;

import com.Underscore.UnderscoreBackend.Models.MetricSnapshot;
import com.Underscore.UnderscoreBackend.Services.MetricSnapshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@RestController
public class TestController {

    @Autowired
    MetricSnapshotService metricSnapshotService;

    @GetMapping(value = "/test")
    public String getData() {
        return "Underscore backend test endpoint is up and running!";
    }

    @PostMapping(value = "/metric-snapshot/latest")
    public MetricSnapshot getLatestMetricSnapshot(@RequestBody LinkedHashMap<String,String> body) {
        String userId = body.get("userId");
        MetricSnapshot metricSnapshot = metricSnapshotService.getLatestMetricSnapshot(userId);
        if(metricSnapshot == null) {
            return getDefaultMetricSnapshot(userId);
        }
        return metricSnapshot;
    }

    @PostMapping(value = "/metric-snapshot")
    public MetricSnapshot saveMetricSnapshot(@RequestBody MetricSnapshot metricSnapshot) {
        return metricSnapshotService.saveMetricSnapshot(metricSnapshot);
    }

    private MetricSnapshot getDefaultMetricSnapshot(String userId) {
        MetricSnapshot metricSnapshot = new MetricSnapshot();
        metricSnapshot.setDefaultValues();
        return metricSnapshot;
    }
}
