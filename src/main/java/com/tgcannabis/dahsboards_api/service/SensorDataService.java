package com.tgcannabis.dahsboards_api.service;

import com.tgcannabis.dahsboards_api.data.SensorDataRepository;
import com.tgcannabis.dahsboards_api.model.SensorData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorDataService {
    private final SensorDataRepository sensorDataRepository;

    public List<SensorData> getFilteredData(String startDateStr, String endDateStr, String sensorType, String location) {
        Long startDate = null;
        Long endDate = null;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        if (startDateStr != null) {
            LocalDateTime startDateTime = LocalDateTime.parse(startDateStr, formatter);
            startDate = startDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
        }

        if (endDateStr != null) {
            LocalDateTime endDateTime = LocalDateTime.parse(endDateStr, formatter);
            endDate = endDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
        }

        return sensorDataRepository.findFiltered(startDate, endDate, sensorType, location);
    }
}
