package io.egen.entity;

import javax.persistence.*;
@Embeddable @Access(AccessType.FIELD)
public class Tires {

    /*@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;*/
    @Column(name = "frontLeft")
    private int frontLeft;
    @Column(name = "frontRight")
    private int frontRight;
    @Column(name = "rearLeft")
    private int rearLeft;
    @Column(name = "rearRight")
    private int rearRight;

   /* public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

    public int getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(int frontLeft) {
        this.frontLeft = frontLeft;
    }

    public int getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(int frontRight) {
        this.frontRight = frontRight;
    }

    public int getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(int rearLeft) {
        this.rearLeft = rearLeft;
    }

    public int getRearRight() {
        return rearRight;
    }

    public void setRearRight(int rearRight) {
        this.rearRight = rearRight;
    }

    @Override
    public String toString() {
        return "Tires{" +
                "frontLeft=" + frontLeft +
                ", frontRight=" + frontRight +
                ", rearLeft=" + rearLeft +
                ", rearRight=" + rearRight +
                '}';
    }
}