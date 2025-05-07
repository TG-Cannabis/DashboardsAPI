package com.tgcannabis.dahsboards_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "sensorData")
public class SensorData {
    @Id
    private String id;

    private String sensorType;
    private String location;
    private String sensorId;
    private double value;
    private long timestamp;
    private long savedAt;
}
