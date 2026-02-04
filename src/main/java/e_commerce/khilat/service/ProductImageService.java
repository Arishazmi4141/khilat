package e_commerce.khilat.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import e_commerce.khilat.entity.Product;
import e_commerce.khilat.entity.ProductImage;
import e_commerce.khilat.repository.ProductImageRepo;
import e_commerce.khilat.repository.ProductRepo;

@Service
public class ProductImageService {

    private static final String UPLOAD_DIR = "uploads/products/";

    @Autowired
    private ProductImageRepo productImageRepo;

    @Autowired
    private ProductRepo productRepo;

    public List<ProductImage> getImagesByProduct(Long productId) {
        return productImageRepo.findByProduct_Id(productId);
    }

    public ProductImage uploadProductImage(Long productId, MultipartFile file) {

        if (file == null || file.isEmpty()) {
            throw new RuntimeException("Image is required");
        }

        try {
            Product product = productRepo.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);

            Files.write(filePath, file.getBytes());

            ProductImage image = new ProductImage();
            image.setProduct(product);
            image.setImageUrl("/uploads/products/" + fileName); // ✅ URL stored in DB

            return productImageRepo.save(image);

        } catch (Exception e) {
            throw new RuntimeException("Image upload failed", e);
        }
    }
}
