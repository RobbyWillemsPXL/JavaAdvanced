package be.pxl.huizenjacht.controller;

import be.pxl.huizenjacht.domain.House;
import be.pxl.huizenjacht.domain.Status;
import be.pxl.huizenjacht.service.HouseService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/houses")
public class HouseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HouseController.class);

    private final HouseService HOUSESERVICE;

    @Autowired
    public HouseController(HouseService houseService) {
        this.HOUSESERVICE = houseService;
    }

    @GetMapping
    public List<House> getHouses() {
        return HOUSESERVICE.getHouses();
    }

//    @GetMapping
//    public Collection<House> getHouses() {
//        return HOUSESERVICE.mamaMia();
//    }



    //    @PostMapping
//    public void addHouse(@RequestParam String code, @RequestParam String name, @RequestParam String city, @RequestParam double price) {
//        HOUSESERVICE.addHouse(code, name, city, price);
//
//    }
    @PostMapping
    public void addHouse(@RequestBody @Valid House house) {
        HOUSESERVICE.addHouse(house);

    }

//    @PutMapping("/{code}")
//    public void updateHouse(@PathVariable String code, @RequestParam Status status, @RequestParam String name, @RequestParam String city, @RequestParam double price) {
//        HOUSESERVICE.updateHouse(code, name, status, city, price);
//
//    }
    @PutMapping("/{code}")
    public void updateHouse(@PathVariable @Valid String code, @RequestBody @Valid House house) {
        HOUSESERVICE.updateHouse(code, house);

    }

    @DeleteMapping("/{code}")
    public void deleteHouse(@PathVariable @Valid String code) {
        HOUSESERVICE.deleteHouse(code);
    }

    @PutMapping("/houses/{code}")
    public void registerAsSold(@PathVariable @Valid  String code) {
        HOUSESERVICE.registerAsSold(code);
    }

}
