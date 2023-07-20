package ru.cft.shift.intensive.template.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import ru.cft.shift.intensive.template.repository.entity.Products;

@Repository
public interface ProductsRepository extends CassandraRepository<Products, String> { 
    @Query("SELECT * FROM products")
    List<Products> findAll();

    Products findByName(String name);
}
