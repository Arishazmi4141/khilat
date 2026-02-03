package e_commerce.khilat.controller;

import org.springframework.web.bind.annotation.RestController;

import e_commerce.khilat.repository.ProductRepo;
import e_commerce.khilat.service.ProductService;

import java.util.List;
import e_commerce.khilat.entity.Product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/product")
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
	    public List<Product> getTrendingProducts() {
	        return productService.getTrendingProducts();
	    }
}
