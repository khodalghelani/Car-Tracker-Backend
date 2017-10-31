package io.egen.service;

import io.egen.entity.Readings;
import io.egen.entity.Vehicles;

import java.util.List;

public interface ReadingService {

    List<Readings> findAllReading();
    Readings findOneReading(String vin);
    Readings createReading(Readings readings);
    List<Readings> update(List<Readings> readings);
    void delete(String vin);
}
