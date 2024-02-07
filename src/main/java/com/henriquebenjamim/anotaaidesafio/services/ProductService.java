package com.henriquebenjamim.anotaaidesafio.services;

import com.henriquebenjamim.anotaaidesafio.domain.category.Category;
import com.henriquebenjamim.anotaaidesafio.domain.category.CategoryDTO;
import com.henriquebenjamim.anotaaidesafio.domain.category.exceptions.CategoryNotFoundException;
import com.henriquebenjamim.anotaaidesafio.domain.product.Product;
import com.henriquebenjamim.anotaaidesafio.domain.product.ProductDTO;
import com.henriquebenjamim.anotaaidesafio.domain.product.exceptions.ProductNotFoundException;
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
        Category category = this.categoryService.getById(productData.categoryId())
                .orElseThrow(CategoryNotFoundException::new);
        Product newProduct = new Product(productData);
        newProduct.setCategory(category);
        this.productRepository.save(newProduct);
        return newProduct;
    }

    public Product update(String id, ProductDTO productData) {
        Product product = this.productRepository
                .findById(id)
                .orElseThrow(ProductNotFoundException::new);

        if(productData.categoryId() != null) {
            this.categoryService.getById(productData.categoryId())
                    .ifPresent(product::setCategory);
        }

        if(!productData.title().isEmpty()) product.setTitle((productData.title()));
        if(!productData.description().isEmpty()) product.setDescription((productData.description()));
        if(!(productData.price() == null)) product.setPrice(productData.price());

        this.productRepository.save(product);
        return product;
    }

    public void delete(String id) {
        Product product = this.productRepository
            .findById(id)
            .orElseThrow(ProductNotFoundException::new);

        this.productRepository.delete(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

}
