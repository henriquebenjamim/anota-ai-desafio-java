package com.henriquebenjamim.anotaaidesafio.config.mongo.repositories;

import com.henriquebenjamim.anotaaidesafio.config.mongo.domain.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface ProductRepository extends MongoRepository<Product, String> {
}
