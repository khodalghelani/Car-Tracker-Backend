package io.egen.controller;

import io.egen.entity.Readings;
import io.egen.entity.Vehicles;
import io.egen.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RequestMapping(value = "/readings")
public class ReadingController {

    @Autowired
    ReadingService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Readings> findAll(){
        return service.findAllReading() ;
    }

    @RequestMapping(value = "/{vin}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Readings findOne(@PathVariable("vin") String vin){
        return service.findOneReading(vin);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Readings create(@RequestBody Readings readings){
        System.out.println("---------> " +readings);
        return service.createReading( readings);
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Readings update(@RequestBody List<Readings> readings){
        return (Readings) service.update(readings);
    }

    @RequestMapping(value = "/{vin}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("vin") String vin){
        service.delete(vin);
    }
}
