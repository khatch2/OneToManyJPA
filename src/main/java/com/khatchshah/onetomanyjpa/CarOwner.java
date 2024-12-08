package com.khatchshah.onetomanyjpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CarOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Let MySQL ta hand om unik PKnumrering
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "owner") // tips , ta alltid med, annars extra link table
    private List<Car> cars;

    public void addCar(Car car) {
        cars.add(car);
    }

    public CarOwner(String name) {
        this.name = name;
        cars = new ArrayList<>();
    }

    public CarOwner() {
        cars = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "CarOwner{" +
                "id=" + id +
                ", cars=" + getCars() +
                ", name='" + name + '\'' +
                '}';
    }

    public List<Car> getCars() {
        return cars;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
