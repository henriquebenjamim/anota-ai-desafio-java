package com.henriquebenjamim.anotaaidesafio.config.mongo.repositories;

import com.henriquebenjamim.anotaaidesafio.config.mongo.domain.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}
