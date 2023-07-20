package ru.cft.shift.intensive.template.service;

import java.util.List;

import ru.cft.shift.intensive.template.dto.ProductDto;

public interface ProductService {
    List<ProductDto> all();

    ProductDto findByName(String name);

    List<ProductDto> add(String id, String name, String shopName, String address, Float price, Float weight, String description);
}
