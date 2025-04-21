package com.LVM.LSM.repository;

import com.LVM.LSM.model.Laptop;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface LaptopRepository extends MongoRepository<Laptop, String> {
    List<Laptop> findByStatus(String status);
    List<Laptop> findByQuantity(int quantity);
}