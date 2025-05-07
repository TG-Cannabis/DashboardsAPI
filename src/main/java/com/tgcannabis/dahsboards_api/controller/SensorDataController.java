package com.tgcannabis.dahsboards_api.controller;

import com.tgcannabis.dahsboards_api.model.SensorData;
import com.tgcannabis.dahsboards_api.service.SensorDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sensorData")
@RequiredArgsConstructor
public class SensorDataController {

    private final SensorDataService service;

    @GetMapping
    public ResponseEntity<List<SensorData>> getSensorMeasures(
            @RequestParam(required = false) Long startDate,
            @RequestParam(required = false) Long endDate,
            @RequestParam(required = false) String sensorType
    ) {
        return new ResponseEntity<>(service.getFilteredData(startDate, endDate, sensorType), HttpStatus.OK);
    }
}
