package com.damo.product.repository;

import com.damo.product.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReposity extends CrudRepository<Product, Integer> {
    List<Product> findByName(String name);

}
