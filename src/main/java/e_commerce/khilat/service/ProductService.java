package e_commerce.khilat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import e_commerce.khilat.dtomodels.ProductRequest;
import e_commerce.khilat.entity.Category;
import e_commerce.khilat.entity.Product;
import e_commerce.khilat.repository.CategoryRepo;
import e_commerce.khilat.repository.ProductRepo;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	 @Autowired
	    private CategoryRepo categoryRepo;
	
	
	@Transactional(readOnly = true)
    public List<Product> getLatestProducts(int limit) {

        if (limit <= 0 || limit > 50) {
            limit = 8; // safe default
        }

        Pageable pageable = PageRequest.of(
                0,
                limit,
                Sort.by(Sort.Direction.DESC, "createdAt")
        );

        return productRepo.findLatestProducts(pageable);
    }
	
	   
    public List<Product> getTrendingProducts(int limit) {
        Pageable pageable = PageRequest.of(0, limit, Sort.by(Sort.Direction.DESC, "createdAt"));
        return productRepo.findTrendingProducts(pageable);
    }
    
    // 🔹 Add product method
    public Product createProduct(ProductRequest request) {
        Category category = categoryRepo.findById(request.getCategoryId())
            .orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = new Product();
        product.setCategory(category);
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setIsActive(request.getIsActive() != null ? request.getIsActive() : true);
        product.setTrending(request.getTrending() != null ? request.getTrending() : "n");
        product.setCreatedAt(java.time.LocalDateTime.now());

        return productRepo.save(product);
    }
}
