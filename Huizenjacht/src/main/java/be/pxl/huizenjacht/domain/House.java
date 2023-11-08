package be.pxl.huizenjacht.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class House {

    @NotBlank
    private final String code;
    @NotBlank
    private String name;
    private Status status;
    @NotBlank
    private String city;

    @Min(value = 50, message = "minimum must exceed or equal 50")
    private int area;
    @NotNull
    private EPCScore epcScore;
    private double PRICE_PER_SQUARE_METER = 2356.76;

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @JsonProperty("EPCS")
    public EPCScore getEpcScore() {
        return epcScore;
    }

    public void setEpcScore(EPCScore epcScore) {
        this.epcScore = epcScore;
    }




    public String getCode() {
        return code;
    }

//    public void setCode(String code) {
//        this.code = code;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double calculatePrice() {
        double price = epcScore.getPercentage() * area * PRICE_PER_SQUARE_METER;
        if (city.toLowerCase().equals("hasselt") || city.toLowerCase().equals("genk")) {
            price *= 1.25;
        }
        return price;
    }

    public House(String code, String name, String city, int area, EPCScore epcScore) {
        this.code = code;
        this.name = name;
        this.city = city;
        this.area = area;
        this.epcScore = epcScore;
        status = Status.FOR_SALE;
    }

    public void markAsSold() {
        try {
            if (status == Status.SOLD) {
                throw new IllegalStateException("Dit huis is al verkocht");
            } else {
                status = Status.SOLD;
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
