package com.Underscore.UnderscoreBackend.Models;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class MetricSnapshot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String snapshotName;

    private Date date;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Object value;

    @PrePersist
    protected void onCreate() {
        date = new Date();
    }
}
