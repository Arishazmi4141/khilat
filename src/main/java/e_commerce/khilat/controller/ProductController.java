package e_commerce.khilat.controller;

import org.springframework.web.bind.annotation.RestController;

import e_commerce.khilat.service.ProductService;

import java.util.List;

import e_commerce.khilat.dtomodels.ProductRequest;
import e_commerce.khilat.entity.Product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/product")
@CrossOrigin

public class ProductController {
	
	@Autowired
	private ProductService productService;

	
	 @GetMapping("/latest")
	    public ResponseEntity<?> getLatestProducts(
	            @RequestParam(defaultValue = "8") int limit) {

	        try {
	            return ResponseEntity.ok(productService.getLatestProducts(limit));
	        } catch (Exception ex) {
	            return ResponseEntity
	                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Failed to fetch latest products");
	        }
	    }
	 
	 

	 @GetMapping("/trending")
	 public ResponseEntity<?> getTrendingProducts(
	         @RequestParam(defaultValue = "8") int limit) {

	     try {
	         List<Product> trendingProducts = productService.getTrendingProducts(limit);
	         return ResponseEntity.ok(trendingProducts);
	     } catch (Exception ex) {
	         ex.printStackTrace();
	         return ResponseEntity
	                 .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                 .body("Failed to fetch trending products");
	     }
	 } 
	 
	 

	  @PostMapping("/add")
	    public ResponseEntity<?> addProduct(@RequestBody ProductRequest request) {
	        try {
	            Product savedProduct = productService.createProduct(request);
	            return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add product: " + ex.getMessage());
	        }
	    }
}
