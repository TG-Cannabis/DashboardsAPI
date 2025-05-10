package com.tgcannabis.dahsboards_api.service;

import com.tgcannabis.dahsboards_api.data.SensorDataRepository;
import com.tgcannabis.dahsboards_api.model.SensorData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorDataService {
    private final SensorDataRepository sensorDataRepository;

    public List<SensorData> getFilteredData(Long startDate, Long endDate, String sensorType) {
        return sensorDataRepository.findFiltered(startDate, endDate, sensorType);
    }
}
