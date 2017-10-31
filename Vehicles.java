package io.egen.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "vehicle.findAll", query = "SELECT vehicles FROM Vehicles vehicles"),
        @NamedQuery(name = "vehicle.findByVin", query = "SELECT vehicles FROM Vehicles vehicles WHERE vehicles.vin =:paramVin"),
})
public class Vehicles {

    //@OneToMany(mappedBy = "vin", targetEntity = Readings.class, fetch = FetchType.EAGER)
   // private Readings readings;

    //@OneToMany(mappedBy = "vin", targetEntity = Alerts.class, fetch = FetchType.EAGER)
    //private Alerts alerts;

    @Id
    private String vin;
    private String make;
    private String model;
    private int year;
    private int redlineRpm;
    private double maxFuelVolume;
    private Date lastServiceDate;

    /*public Reading getReading() {
        return reading;
    }

    public void setReading(Reading reading) {
        this.reading = reading;
    }*/

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(int redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public double getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(double maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public Date getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Date lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    /*public Readings getReadings() {
        return readings;
    }*/

    /*public void setReadings(Readings readings) {
        this.readings = readings;
    }*/


    @Override
    public String toString() {
        return "Vehicle{" +
                ", vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", redlineRpm=" + redlineRpm +
                ", maxFuelVolume=" + maxFuelVolume +
                ", lastServiceDate='" + lastServiceDate + '\'' +
                '}';
    }
}
