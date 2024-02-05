package com.henriquebenjamim.anotaaidesafio.services;

import com.henriquebenjamim.anotaaidesafio.domain.category.Category;
import com.henriquebenjamim.anotaaidesafio.domain.category.CategoryDTO;
import com.henriquebenjamim.anotaaidesafio.domain.category.exceptions.CategoryNotFoundException;
import com.henriquebenjamim.anotaaidesafio.domain.product.Product;
import com.henriquebenjamim.anotaaidesafio.domain.product.ProductDTO;
import com.henriquebenjamim.anotaaidesafio.repositories.CategoryRepository;
import com.henriquebenjamim.anotaaidesafio.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private CategoryService categoryService;
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }


    public Product insert(ProductDTO productData) {
        Product newProduct = new Product(productData);
        this.productRepository.save(newProduct);
        return newProduct;
    }

    public Product update(String id, ProductDTO productData) {
        Product product = this.productRepository
                .findById(id)
                .orElseThrow(CategoryNotFoundException::new);



        this.productRepository.save(product);
        return product;
    }

    public void delete(String id) {
        Product product = this.productRepository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);

        this.productRepository.delete(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
