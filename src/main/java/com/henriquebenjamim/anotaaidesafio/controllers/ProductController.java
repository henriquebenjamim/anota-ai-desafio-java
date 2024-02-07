package com.henriquebenjamim.anotaaidesafio.controllers;

import com.henriquebenjamim.anotaaidesafio.domain.category.Category;
import com.henriquebenjamim.anotaaidesafio.domain.category.CategoryDTO;
import com.henriquebenjamim.anotaaidesafio.domain.product.Product;
import com.henriquebenjamim.anotaaidesafio.domain.product.ProductDTO;
import com.henriquebenjamim.anotaaidesafio.services.CategoryService;
import com.henriquebenjamim.anotaaidesafio.services.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {


    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody ProductDTO productData) {
        Product newProduct =  this.productService.insert(productData);
        return ResponseEntity.ok().body(newProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = this.productService.getAll();
        return ResponseEntity.ok().body(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") String id,
                                           @RequestBody ProductDTO productDTO) {
        Product updatedProduct = this.productService.update(id, productDTO);
        return ResponseEntity.ok().body(updatedProduct);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") String id) {
        this.productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
