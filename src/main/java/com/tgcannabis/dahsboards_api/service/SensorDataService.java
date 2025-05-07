package com.tgcannabis.dahsboards_api.service;

import com.tgcannabis.dahsboards_api.data.SensorDataRepository;
import com.tgcannabis.dahsboards_api.model.SensorData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorDataService {
    private final SensorDataRepository repository;

    public List<SensorData> getFilteredData(Long startDate, Long endDate, String sensorType) {
        if (startDate != null && endDate != null && sensorType != null) {
            return repository.findByDateRangeAndSensorType(startDate, endDate, sensorType);
        } else if (startDate != null && endDate != null) {
            return repository.findByDateRange(startDate, endDate);
        } else if (sensorType != null) {
            return repository.findBySensorType(sensorType);
        } else {
            return repository.findAll();
        }
    }
}
