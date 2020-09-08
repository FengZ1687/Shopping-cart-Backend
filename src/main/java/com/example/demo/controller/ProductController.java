package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;
@CrossOrigin(origins="http://localhost:3000")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private JavaMailSender javaMailSender;
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return productService.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }

    @PutMapping("/updatequantity/{id}/{quantity}")
    public Product updateQuantity(@PathVariable int id, @PathVariable Integer quantity) {
        return productService.updateQuantity(id,quantity);
    }
         //this is the api my app is using important
        // @CrossOrigin
    @PutMapping("/updateProducts")
    public String updateProducts(@RequestBody List<Product> products) {
        return productService.updateProducts(products);
    }


    //Receive user email and send it
    @CrossOrigin
    @PutMapping("/order/{email}")
    public void send(@PathVariable String email){

        sendEmail(email.toString());
        System.out.println("OrderEmailSent");
    }

      void sendEmail(String emailAddr) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(emailAddr);

        msg.setSubject("Thank you for Shopping in ACME!");
        msg.setText("Your order is confirmed proceeded, items will be shipped soon.");

        javaMailSender.send(msg);

    }


}
