package com.javatechie.crud.example.service;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }
    public List<Product> getProductByDate(){
        return repository.findAll(Sort.by(Sort.Direction.ASC,"date"));
    }

    public Product getProductByName(String name) {
        return repository.findByName(name);

    }
    public List<Product> getProductByPrice(int price){
        return repository.findByprice(price);
    }
    public List<Product> listAll(String keyword){
        if(keyword!=null){
            return repository.search(keyword);
        }
        return  repository.findAll();
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }

   public Product addProductByDate(Product product){
       return repository.save(product);
    }

}