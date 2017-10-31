package io.egen.repository;

import io.egen.entity.Readings;
import io.egen.entity.Vehicles;

import java.util.List;

public interface ReadingRepository {

    List<Readings> findAllReadings();
    Readings findOneVinReading(String vin);
    Readings createReadings(Readings readings);
    List<Readings> updateReadings(List<Readings> readings);
    void delete(String  vin);
}
