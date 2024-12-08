package com.khatchshah.onetomanyjpa;

import jakarta.persistence.*;

@Entity
public class Car {

    public Car(String reg, String model, int year, CarOwner owner) {
        this.reg = reg;
        this.model = model;
        this.year = year;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "reg='" + reg + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", owner=" + owner.getName() +  //avoid infinite loop!
                '}';
    }

    @Id
    private String reg;

    private String model;

    private int year;

    @ManyToOne
    private CarOwner owner;  // inte nödvändig, men kanske praktisk


    public Car() {

    }


}
