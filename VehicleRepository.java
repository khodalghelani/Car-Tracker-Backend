package io.egen.repository;

import io.egen.entity.Readings;
import io.egen.entity.Vehicles;

import java.util.List;

public interface VehicleRepository {

    List<Vehicles> findAll();
    Vehicles findOne(String vin);
    Vehicles findByVin(String vin);
    Vehicles create(Vehicles vehicles);
    List<Vehicles> update(List<Vehicles> vehicles);
    void delete(String vin);

}
