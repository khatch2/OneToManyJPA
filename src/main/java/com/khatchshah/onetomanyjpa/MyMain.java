package com.khatchshah.onetomanyjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyMain implements CommandLineRunner {

    @Autowired CarOwnerRepo repo;

    /**
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n\tthe male man Khatchik Shahinyan .\t\n");

        CarOwner myCarOwner = new CarOwner("Ulf");
        CarOwner look1 = repo.save(myCarOwner);
        System.out.println("look1 = " + look1);

        myCarOwner.addCar(new Car("mkl678", "BMW", 2015, look1));
        CarOwner look2 = repo.save(myCarOwner);
        System.out.println("look2 = " + look2);

        myCarOwner.addCar(new Car("xxx678", "Volvo", 2015, look2));
        CarOwner look3 = repo.save(myCarOwner);
        System.out.println("look3 = " + look3);

        System.out.println("repo.findAll() = " + repo.findAll());

        repo.findById(1L).ifPresent(carOwner -> {
            System.out.println();
            System.out.println("carOwner = " + carOwner.getName());
            System.out.println("carOwner.getCars() = " + carOwner.getCars());
            System.out.println();
        });

        CarOwner ny = repo.findById(1L).get();
        ny.setName("Oskar");
        ny.addCar(new Car("yyy678", "Audi", 2015, ny));
        repo.save(ny);  //uppdatera

        CarOwner egen = repo.findByName("Oskar").get(0);
        egen.setName("Ulf B");
        egen.addCar(new Car("zzz678", "Saab", 2015, egen));
        repo.save(egen);  //uppdatera
    }
}
