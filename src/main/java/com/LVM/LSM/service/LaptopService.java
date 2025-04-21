package com.LVM.LSM.service;

import com.LVM.LSM.model.Laptop;
import com.LVM.LSM.model.LaptopStatus;
import com.LVM.LSM.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    public List<Laptop> getAvailableLaptops() {
        return laptopRepository.findByStatus(LaptopStatus.AVAILABLE.name());
    }
    public List<Laptop> getOutOfStockLaptops() {
        return laptopRepository.findByQuantity(0);
    }

    public Laptop buyLaptop(String laptopId) {
        Laptop laptop = laptopRepository.findById(laptopId).orElseThrow(() -> new RuntimeException("Laptop not found"));
        if (laptop.getQuantity() > 0) {
            laptop.setQuantity(laptop.getQuantity() - 1);
            if (laptop.getQuantity() == 0) {
                laptop.setStatus(LaptopStatus.SOLD);
            }
            return laptopRepository.save(laptop);
        } else {
            throw new RuntimeException("Laptop out of stock. Request sent to vendor.");
        }
    }

    public Laptop addLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    public Laptop sellLaptop(Laptop laptop) {
        laptop.setStatus(LaptopStatus.AVAILABLE);
        laptop.setQuantity(laptop.getQuantity() + 1);
        return laptopRepository.save(laptop);
    }

    public Laptop restockLaptop(String laptopId, int quantity) {
        Laptop laptop = laptopRepository.findById(laptopId).orElseThrow(() -> new RuntimeException("Laptop not found"));
        laptop.setQuantity(laptop.getQuantity() + quantity);
        laptop.setStatus(LaptopStatus.AVAILABLE); // Update status to AVAILABLE
        return laptopRepository.save(laptop);
    }

    public Laptop serviceLaptop(String laptopId) {
        Laptop laptop = laptopRepository.findById(laptopId).orElseThrow(() -> new RuntimeException("Laptop not found"));
        laptop.setStatus(LaptopStatus.UNDERSERVICE);
        return laptopRepository.save(laptop);
    }

    public Laptop completeService(String laptopId) {
        Laptop laptop = laptopRepository.findById(laptopId).orElseThrow(() -> new RuntimeException("Laptop not found"));
        laptop.setStatus(LaptopStatus.AVAILABLE);
        return laptopRepository.save(laptop);
    }

    public Laptop getLaptopById(String laptopId) {
        return laptopRepository.findById(laptopId)
                .orElseThrow(() -> new RuntimeException("Laptop not found for ID: " + laptopId));
    }
}