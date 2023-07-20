package ru.cft.shift.intensive.template.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

public class PurchaseDto {
    @NotEmpty private String orderId;
    private Address shopAddress;
    private PurchaseState state;
    @NotEmpty @Min(value = 1) private Integer weight;
    @NotEmpty private String shopName;
    @NotEmpty private String itemId;
    @NotEmpty private String itemName;
    @NotEmpty @Min(value = 0) private Integer quantity;
    @NotEmpty @Min(value = 1) private Float price;
    private Address customerAddress;
    @Max(value = 250) private String description;

    public PurchaseDto() {
    }

    public PurchaseDto(String orderId, String shopAddress, String state, Integer weight, String shopName, 
    String itemId, String itemName, Integer quantity, Float cost, String customerAddress, String description) throws RuntimeException {
        Boolean isInputValid = true;
        for (Address district: Address.values()) {
            if (district.toString().equalsIgnoreCase(shopAddress)) {
                this.shopAddress = district;
                break;
            }
            isInputValid = false;
        }

        for (PurchaseState purchaseState: PurchaseState.values()) {
            if (purchaseState.toString().equalsIgnoreCase(state)) {
                this.state = purchaseState;
                break;
            }
            isInputValid = false;
        }

        for (Address district: Address.values()) {
            if (district.toString().equalsIgnoreCase(customerAddress)) {
                this.customerAddress = district;
                break;
            }
            isInputValid = false;
        }

        if (!isInputValid) throw new RuntimeException();
        
        this.orderId = orderId;
        this.weight = weight;
        this.shopName = shopName;
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = cost;
        this.description = description;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Address getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(Address shopAddress) {
        this.shopAddress = shopAddress;
    }

    public PurchaseState getState() {
        return state;
    }

    public void setState(PurchaseState state) {
        this.state = state;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float cost) {
        this.price = cost;
    }

    public Address getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(Address customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
