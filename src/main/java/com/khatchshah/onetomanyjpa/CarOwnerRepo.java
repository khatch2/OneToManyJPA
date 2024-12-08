package com.khatchshah.onetomanyjpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository public interface CarOwnerRepo extends JpaRepository<CarOwner, Long> {
    List<CarOwner> findByName(String name);
}
