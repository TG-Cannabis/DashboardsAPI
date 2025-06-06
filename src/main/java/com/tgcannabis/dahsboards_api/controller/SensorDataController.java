package com.tgcannabis.dahsboards_api.controller;

import com.tgcannabis.dahsboards_api.model.AvailableTags;
import com.tgcannabis.dahsboards_api.model.SensorData;
import com.tgcannabis.dahsboards_api.service.SensorDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class SensorDataController {

    private final SensorDataService service;

    @GetMapping("/sensorData")
    public ResponseEntity<List<SensorData>> getSensorMeasures(
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(required = false) String sensorType,
            @RequestParam(required = false) String location
    ) {
        return new ResponseEntity<>(service.getFilteredData(startDate, endDate, sensorType, location), HttpStatus.OK);
    }

    @GetMapping("/availableTags")
    public ResponseEntity<AvailableTags> getAvailableTags() {
        return new ResponseEntity<>(service.getAvailableTags(), HttpStatus.OK);
    }
}
