package com.tgcannabis.dahsboards_api.data;

import com.tgcannabis.dahsboards_api.model.SensorData;

import java.util.List;

interface SensorDataRepositoryCustom {
    List<SensorData> findFiltered(Long startDate, Long endDate, String sensorType);
}
