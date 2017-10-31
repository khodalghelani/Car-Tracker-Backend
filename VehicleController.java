package io.egen.controller;

import io.egen.entity.Vehicles;
import io.egen.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
public class VehicleController {

    @Autowired
    VehicleService service;

    @RequestMapping(value = "/vehicles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicles> findAll(){
        return service.findAll() ;
    }

    @RequestMapping(value = "/vehicles/{vin}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicles findOne(@PathVariable("vin") String vin){
        return service.findOne(vin);
    }

    @RequestMapping(value = "/vehicles", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicles create(@RequestBody Vehicles vehicles){
        return service.create( vehicles);
    }

    @RequestMapping(value = "/vehicles", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicles update(@RequestBody List<Vehicles> vehicles){

        return (Vehicles) service.update(vehicles);
    }

    @RequestMapping(value = "/vehicles/{vin}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("vin") String vin){
        service.delete(vin);
    }
}
