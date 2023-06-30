package com.ngoc.redis.demo;

import com.ngoc.redis.demo.entity.Product;
import com.ngoc.redis.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/product")
public class DemoApplication {

    @Autowired
    private ProductRepo repo;

    @PostMapping
    public Product save(@RequestBody Product product){
        return repo.save(product);
    }

    @GetMapping
    public List<Product> getAll(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Product findProduct(@PathVariable int id){
        return repo.findProductById(id);
    }

    @PostMapping("/{id}")
    public String remove(@PathVariable int id){
        return repo.deleteProduct(id);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
