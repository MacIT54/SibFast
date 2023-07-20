package ru.cft.shift.intensive.template.repository;

import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ru.cft.shift.intensive.template.dto.ProductDto;
import ru.cft.shift.intensive.template.repository.entity.Purchases;
import ru.cft.shift.intensive.template.repository.entity.PurchasesPrimaryKeyClass;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Repository
public interface PurchasesRepository extends CassandraRepository<Purchases, ru.cft.shift.intensive.template.repository.entity.PurchasesPrimaryKeyClass>{
    @Query("SELECT * FROM purchases WHERE user_id = :id")
    List<Purchases> findAllByUserId(@Param("id") String userId);

    @Query("SELECT u FROM purchases WHERE u.user_id = :user AND u.product_id = :product")
    Purchases findByUserAndKeyClassProductId(@Param("user") String userId, @Param("product") String productId);
}
