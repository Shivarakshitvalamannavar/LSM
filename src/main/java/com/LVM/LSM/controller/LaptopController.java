package com.LVM.LSM.controller;

import com.LVM.LSM.model.Laptop;
import com.LVM.LSM.model.LaptopStatus;
import com.LVM.LSM.service.LaptopService;
import com.LVM.LSM.util.LaptopIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laptops")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @PostMapping("/add")
    public Laptop addLaptop(@RequestParam String model, @RequestParam String status, @RequestParam int quantity) {
        Laptop laptop = new Laptop();
        laptop.setModel(model);
        laptop.setLaptopId(LaptopIdGenerator.getInstance().generateId());
        laptop.setStatus(LaptopStatus.valueOf(status));
        laptop.setQuantity(quantity);
        return laptopService.addLaptop(laptop);
    }

    @PostMapping("/buy/{laptopId}")
    public Laptop buyLaptop(@PathVariable String laptopId) {
        return laptopService.buyLaptop(laptopId);
    }

    @PutMapping("/restock/{laptopId}")
    public Laptop restockLaptop(@PathVariable String laptopId, @RequestParam int quantity) {
        return laptopService.restockLaptop(laptopId, quantity);
    }

    @GetMapping("/available")
    public List<Laptop> getAvailableLaptops() {
        return laptopService.getAvailableLaptops();
    }

    @GetMapping("/out-of-stock")
    public List<Laptop> getOutOfStockLaptops() {
        return laptopService.getOutOfStockLaptops();
    }
}