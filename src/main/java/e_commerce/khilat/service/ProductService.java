package e_commerce.khilat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import e_commerce.khilat.entity.Product;
import e_commerce.khilat.repository.ProductRepo;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	
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
}
