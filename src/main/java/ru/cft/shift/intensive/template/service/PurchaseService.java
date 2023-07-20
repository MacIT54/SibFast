package ru.cft.shift.intensive.template.service;

import java.util.List;

import ru.cft.shift.intensive.template.dto.OrderDto;
import ru.cft.shift.intensive.template.dto.ProductDto;
import ru.cft.shift.intensive.template.dto.PurchaseDto;
import ru.cft.shift.intensive.template.repository.entity.PurchasesPrimaryKeyClass;

public interface PurchaseService {
    List<String> PurchaseCartProducts(OrderDto order);
    
    List<PurchaseDto> ListAllPurchases();

    Void AddToCart(ProductDto product);

    Void RemovePurchase(String purchaseId);

    Void AddPurchase(String purchaseId);

    Void DeleteFromCart(String purchaseId);

    Float CalculateTotalCost();

    Integer CalculateDeliveryTime();
}
