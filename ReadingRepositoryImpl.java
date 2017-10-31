package io.egen.repository;

import io.egen.entity.Readings;
import io.egen.entity.Vehicles;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository

public class ReadingRepositoryImpl implements ReadingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Readings> findAllReadings() {
        TypedQuery<Readings> query = entityManager.createNamedQuery("readings.findAll", Readings.class);
        return query.getResultList();
    }

    @Override
    public Readings findOneVinReading(String vin) {
        return entityManager.find(Readings.class, vin);
    }

    @Override
    public Readings createReadings(Readings readings) {
        entityManager.persist(readings);
        return readings;
    }

    @Override
    public List<Readings> updateReadings(List<Readings> readings) {
        for(Readings read:readings){
            entityManager.merge(read);
        }
        System.out.println(readings);
        return readings;
    }

    @Override
    public void delete(String vin) {
        entityManager.remove(vin);
    }
}
