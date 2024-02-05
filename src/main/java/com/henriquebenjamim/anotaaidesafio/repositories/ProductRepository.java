package com.henriquebenjamim.anotaaidesafio.repositories;

import com.henriquebenjamim.anotaaidesafio.domain.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface ProductRepository extends MongoRepository<Product, String> {
}
