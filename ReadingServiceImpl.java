package io.egen.service;

import io.egen.entity.Readings;
import io.egen.exception.ResourceNotFoundException;
import io.egen.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    ReadingRepository repository;

    @Override
    @Transactional
    public List<Readings> findAllReading() {
        return repository.findAllReadings();
    }

    @Override
    @Transactional /*(readOnly = true)*/
    public Readings findOneReading(String vin) {
        Readings existing = repository.findOneVinReading(vin);
        if(existing == null){
            //Exception - vehicle that need to find id not in database Error 404
            throw new ResourceNotFoundException("Vehicle with the id " + vin + " is not found..!!");
        }
        return existing;
    }

    @Override
    @Transactional
    public Readings createReading(Readings readings) {
        return repository.createReadings(readings);
    }

    @Override
    @Transactional
    public List<Readings> update(List<Readings> readings) {
         return repository.updateReadings(( readings));
    }

    @Override
    @Transactional
    public void delete(String  vin) {
        Readings existing = repository.findOneVinReading(vin);
            if(existing == null){
                //Exception - vehicle vin is not exist in database, can't delete
                throw new ResourceNotFoundException("Vehicle with the id " + vin + " does not exist..!!");
        }
        repository.delete(vin);
    }
}
