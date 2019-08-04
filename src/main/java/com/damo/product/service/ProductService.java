package com.damo.product.service;


import com.damo.product.model.Product;
import com.damo.product.repository.ProductReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    final
    ProductReposity productReposity;

    public ProductService(ProductReposity productReposity) {
        this.productReposity = productReposity;
    }

    public List<Product> getAll() {
        return (List<Product>) productReposity.findAll();
    }

    public Product getById(int id) {
        return productReposity.findOne(id);
    }

    public List<Product> getByName(String name) {
        return productReposity.findByName(name);
    }

    public boolean addProduct(Product product) {
        return productReposity.save(product) != null;
    }

    public boolean updateProduct(Product product) {
        return productReposity.save(product) != null;
    }

    public boolean deleteProduct(int id) {
        if (productReposity.exists(id)) {
            productReposity.delete(id);
            return true;
        } else {
            return false;
        }

    }
}
