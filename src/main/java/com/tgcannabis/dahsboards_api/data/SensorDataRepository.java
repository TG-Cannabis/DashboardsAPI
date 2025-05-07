package com.tgcannabis.dahsboards_api.data;

import com.tgcannabis.dahsboards_api.model.SensorData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SensorDataRepository extends MongoRepository<SensorData, String> {

    @Query("{ 'timestamp': { $gte: ?0, $lte: ?1 }, 'sensorType': ?2 }")
    List<SensorData> findByDateRangeAndSensorType(long startDate, long endDate, String sensorType);

    @Query("{ 'timestamp': { $gte: ?0, $lte: ?1 } }")
    List<SensorData> findByDateRange(long startDate, long endDate);

    List<SensorData> findBySensorType(String sensorType);
}
