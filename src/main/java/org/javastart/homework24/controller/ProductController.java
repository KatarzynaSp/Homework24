package org.javastart.homework24.controller;

import org.javastart.homework24.model.Product;
import org.javastart.homework24.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    private ProductRepository productrepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productrepository = productRepository;
    }

    @GetMapping("/")
    public String AddProduct(Model model) {
        model.addAttribute("product", new Product());
        return "home";
    }

    @PostMapping("/")
    public String AddProductToDatabase(Product product) {
        productrepository.add(product);
        return "home";
    }

    @GetMapping("/lista")
    public String GetList(Model model) {
        List<Product> products = productrepository.findAll();
        model.addAttribute("products", products);
        double sum = productrepository.sum();
        model.addAttribute("sum", sum);
        return "list";
    }

    @GetMapping("/tabela")
    public String GetTable(Model model) {
        List<Product> products = productrepository.findAll();
        model.addAttribute("products", products);
        double sum = productrepository.sum();
        model.addAttribute("sum", sum);
        return "table";
    }
}