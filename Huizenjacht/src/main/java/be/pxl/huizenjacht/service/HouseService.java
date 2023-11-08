package be.pxl.huizenjacht.service;

import be.pxl.huizenjacht.domain.House;
import be.pxl.huizenjacht.domain.Status;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HouseService {
    private List<House> houseList = new ArrayList<>();
    private Map<String, House> houseMap = new HashMap<>();

    public List<House> getHouses() {
        //return houseList;
        return houseMap.values().stream().toList();
    }
//    public Collection<House> mamaMia() {
//        //return houseList;
//        return houseMap.values();
//    }


    public void deleteHouse(String code) {
        houseMap.remove(code);
    }

    public void addHouse(House house) {
        houseMap.put(house.getCode(), house);
    }

    public void updateHouse(String code, House house) {
        var selectedHouse = houseMap.get(code);
        if (selectedHouse != null) {
            //selectedHouse.setPrice(house.getPrice());
            selectedHouse.setName(house.getName());
            selectedHouse.setCity(house.getCity());
            selectedHouse.setArea(house.getArea());
            selectedHouse.setEpcScore(house.getEpcScore());
        }
    }

    public void registerAsSold(String code) {
        var selectedHouse = houseMap.get(code);
        selectedHouse.markAsSold();
    }
}
