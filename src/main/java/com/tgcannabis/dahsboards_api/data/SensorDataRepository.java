package com.tgcannabis.dahsboards_api.data;

import com.tgcannabis.dahsboards_api.model.SensorData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SensorDataRepository extends MongoRepository<SensorData, String>, SensorDataRepositoryCustom {
}
