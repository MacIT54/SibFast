package ru.cft.shift.intensive.template.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ProductDto {
    private String id;
    @NotEmpty(message = "validation.delivery.name.not-empty") private String name;
    @NotEmpty(message = "validation.delivery.owner.not-empty") private String shopName;
    private Address address;
    @Min(value =  1, message = "validation.delivery.cost.positive") private Float price;
    @Min(value =  1, message = "validation.delivery.cost.positive") private Integer weight;
    @Size(max = 280) private String description;
    
    public ProductDto() {
    }

    public ProductDto(String id, String name, String shopName, String address, Float price, Integer weight, String description) throws RuntimeException {
        Boolean isInputValid = false;
        for (Address district: Address.values()) {
            if (district.toString().equalsIgnoreCase(address)) {
                this.address = district;
                isInputValid = true;
                break;
            }
        }
        if (!isInputValid) throw new RuntimeException();

        this.id = id;
        this.name = name;
        this.shopName = shopName;
        this.price = price;
        this.weight = weight;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
