package com.learning.liquibase.Services;

import com.learning.liquibase.Models.Product;
import com.learning.liquibase.Repo.ProductRepo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @CachePut(value = "products", key = "#result.id")
    public Product create(Product product){
        return productRepo.save(product);
    }

    // Cache this method's result using product ID as key
    @Cacheable(value = "products", key = "#id")
    public Optional<Product> findById(Integer id){
        return productRepo.findById(id);
    }

    // No cache here, but you could add caching if needed
    public List<Product> findAll(){
        return productRepo.findAll();
    }

    // Evict cache entry when deleting
    @CacheEvict(value = "products", key = "#id")
    public void deleteById(Integer id){
        productRepo.deleteById(id);
    }

    // Update both DB and cache
    @CachePut(value = "products", key = "#product.id")
    public Product update(Product product){
        return productRepo.save(product);
    }
}
