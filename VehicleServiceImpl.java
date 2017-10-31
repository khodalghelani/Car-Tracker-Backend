package io.egen.service;

import io.egen.entity.Readings;
import io.egen.entity.Vehicles;
import io.egen.exception.BadRequestException;
import io.egen.exception.ResourceNotFoundException;
import io.egen.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository repository;

    @Override
    @Transactional/*(readOnly = true)*/
    public List<Vehicles> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional /*(readOnly = true)*/
    public Vehicles findOne(String vin) {
        Vehicles existing = repository.findOne(vin);
        if (existing == null) {
            //Exception - vehicle that need to find id not in database Error 404
            throw new ResourceNotFoundException("Vehicle with the id " + vin + " is not found..!!");
        }
        return existing;
    }

    @Override
    @Transactional // used to roll back failed transaction
    public Vehicles create(Vehicles vehicles) {
        Vehicles existing = repository.findByVin(vehicles.getVin());
        if (existing != null) {
            //Exception - vehicle with the same vin - update to the database 400 Bad Request
            throw new BadRequestException("Vehicle with the id " + vehicles.getVin() + " is already exist..!!");
        }
        //priorityRules(vehicle);

        return repository.create(vehicles);
    }

    @Override
    @Transactional
    public List<Vehicles> update(List<Vehicles> vehicles) {

        return repository.update(vehicles);
    }

    @Override
    @Transactional
    public void delete(String vin) {

        Vehicles existing = repository.findOne(vin);
        if (existing == null) {
            //Exception - vehicle vin is not exist in database, can't delete
            throw new ResourceNotFoundException("Vehicle with the id " + vin + " does not exist..!!");
        }
        repository.delete(existing.getVin());
    }
}

    /*public void priorityRules(Readings vin){
        if(vin.getEngineRpm() > vin.getReadlineRpm()) {
            vin.setPriority("High");
        }else if(vin.getFuelVolume() < 0.1*vin.getMaxFuelVolume()){
            vin.setPriority("MEDIUM");
        }
        else if (vin.getTirePressure() < 32 || vin.getTirePressure() > 36){
            vin.setPriority("LOW");
        } else if (vin.isEngineCoolantLow() == true || vin.isCheckEngineLightOn() == true){
            vin.setPriority("LOW");
        }

    }*/


