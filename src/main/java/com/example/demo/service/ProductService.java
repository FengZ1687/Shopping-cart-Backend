package com.example.demo.service;

import com.example.demo.Dao.ProductDao;
import com.example.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public Product saveProduct(Product product){
       return productDao.save(product);
    }
    public List<Product> saveProducts(List<Product> products){
        return productDao.saveAll(products);
    }

    public List<Product> getProducts(){
        return productDao.findAll();
    }

    public Product getProductById(int id){
        return productDao.findById(id).orElse(null);
    }
    public Product getProductByName(String name){
        return productDao.findByName(name);
    }

    public String deleteProduct(int id){
        productDao.deleteById(id);
        return "product removed!" + id;
    }

    public Product updateProduct(Product product){
        Product existingProduct = productDao.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setInventory(product.getInventory());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setProductDesc(product.getProductDesc());
        existingProduct.setImg(product.getImg());
        return productDao.save(existingProduct);
    }
    public String updateProducts(List<Product> products){
        for (Product current : products) {
            Product existingProduct = productDao.findById(current.getId()).orElse(null);
            existingProduct.setName(current.getName());
            existingProduct.setInventory(current.getInventory());
            existingProduct.setPrice(current.getPrice());
            existingProduct.setProductDesc(current.getProductDesc());
            existingProduct.setImg(current.getImg());
            productDao.save(existingProduct);
        }
        return "Add success!";
    }
//this is the key function
    public Product updateQuantity(int id, int newquantity){
        Product existingProduct = productDao.findById(id).orElse(null);
        existingProduct.setInventory(newquantity);
        return productDao.save(existingProduct);
    }
}
