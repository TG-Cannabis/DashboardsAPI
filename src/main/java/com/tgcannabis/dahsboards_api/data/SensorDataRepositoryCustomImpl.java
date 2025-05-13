package com.tgcannabis.dahsboards_api.data;

import com.tgcannabis.dahsboards_api.model.SensorData;
import com.tgcannabis.dahsboards_api.service.SensorDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
class SensorDataRepositoryCustomImpl implements SensorDataRepositoryCustom {

    private final MongoTemplate template;

    @Override
    public List<SensorData> findFiltered(
            Long startDate,
            Long endDate,
            String sensorType,
            String location) {
        List<Criteria> criteria = new ArrayList<>();

        if (startDate != null && endDate != null) {
            criteria.add(Criteria.where("timestamp").gte(startDate).lte(endDate));
        } else if (startDate != null) {
            criteria.add(Criteria.where("timestamp").gte(startDate));
        }

        if (sensorType != null) {
            criteria.add(Criteria.where("sensorType").is(sensorType));
        }

        if (location != null) {
            criteria.add(Criteria.where("location").is(location));
        }

        Query query = new Query();
        if (!criteria.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[0])));
        }

        return template.find(query, SensorData.class);
    }

    @Override
    public List<String> findDistinctSensorTypes() {
        return template.query(SensorData.class)
                .distinct("sensorType")
                .as(String.class)
                .all();
    }

    @Override
    public List<String> findDistinctLocations() {
        return template.query(SensorData.class)
                .distinct("location")
                .as(String.class)
                .all();
    }
}
