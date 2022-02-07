package com.Underscore.UnderscoreBackend.Repositories;

import com.Underscore.UnderscoreBackend.Models.MetricSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricSnapshotRepository extends JpaRepository<MetricSnapshot, Long> {

}
