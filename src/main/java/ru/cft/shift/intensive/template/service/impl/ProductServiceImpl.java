package ru.cft.shift.intensive.template.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ru.cft.shift.intensive.template.dto.ProductDto;
import ru.cft.shift.intensive.template.repository.ProductsRepository;
import ru.cft.shift.intensive.template.repository.entity.Products;
import ru.cft.shift.intensive.template.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductsRepository repository;

    public ProductServiceImpl(ProductsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductDto> all() {
        return repository.findAll().stream()
            .map(product -> new ProductDto(product.getId().toString(), product.getName(), product.getShop(), product.getAddress(), product.getPrice(), product.getWeight(), product.getDescription())).toList();
    }

    @Override
    public ProductDto findByName(String name) {
        Products product = repository.findByName(name);
        if (product == null) throw new RuntimeException();
        return new ProductDto(product.getId().toString(), product.getName(), product.getShop(), product.getAddress(), product.getPrice(), product.getWeight(), product.getDescription());
    }

    @Override
    public List<ProductDto> add(String id, String name, String shopName, String address, Float price, Float weight, String description) {
        return null;
    }

}
