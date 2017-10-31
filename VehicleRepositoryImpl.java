package io.egen.repository;

import io.egen.entity.Vehicles;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements  VehicleRepository{

    @PersistenceContext
    private EntityManager entityManager;

    //@Override
    public List<Vehicles> findAll() {
        TypedQuery<Vehicles> query = entityManager.createNamedQuery("vehicle.findAll", Vehicles.class);
        return query.getResultList();
    }

    @Override
    public Vehicles findOne(String vin) {
        return entityManager.find(Vehicles.class, vin);
    }

    @Override
    public Vehicles findByVin(String vin) {
        TypedQuery<Vehicles> query = entityManager.createNamedQuery("vehicle.findByVin", Vehicles.class);
        query.setParameter("paramVin", vin);
        List<Vehicles> resultList = query.getResultList();
        if(resultList != null && resultList.size() == 1){
            return resultList.get(0);
        } else{
            return null;
        }
    }

    @Override
    public Vehicles create(Vehicles vehicles) {
        entityManager.persist(vehicles);
        return vehicles;
    }

    @Override
    public List<Vehicles> update(List<Vehicles> vehicles) {
        for(Vehicles vec:vehicles){
            entityManager.merge(vec);
        }
        return vehicles;
    }

    @Override
    public void delete(String vin) {
        entityManager.remove(vin);
       // return vin;
    }
}
