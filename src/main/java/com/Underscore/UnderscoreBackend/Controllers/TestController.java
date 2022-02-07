package com.Underscore.UnderscoreBackend.Controllers;

import com.Underscore.UnderscoreBackend.Models.MetricSnapshot;
import com.Underscore.UnderscoreBackend.Services.MetricSnapshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    MetricSnapshotService metricSnapshotService;

    @GetMapping(value = "/test")
    public String getData() {
        System.out.println("hey you hit me");
        return "firing again me back from the server";
    }

    @PostMapping(value = "/metric-snapshot")
    public void saveMetricSnapshot(@RequestBody MetricSnapshot metricSnapshot) {
        metricSnapshotService.saveMetricSnapshot(metricSnapshot);
    }
}
