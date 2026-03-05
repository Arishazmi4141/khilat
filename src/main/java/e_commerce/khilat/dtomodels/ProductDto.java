package e_commerce.khilat.dtomodels;

import java.math.BigDecimal;

public class ProductDto {
	
	private Long productId;
	
	private String firstImage;
	
	private String productName;
	
	private String productNameCategory;
	
	private BigDecimal minPrice; 
	
    private BigDecimal maxPrice;
	
	
	

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getFirstImage() {
		return firstImage;
	}

	public void setFirstImage(String firstImage) {
		this.firstImage = firstImage;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductNameCategory() {
		return productNameCategory;
	}

	public void setProductNameCategory(String productNameCategory) {
		this.productNameCategory = productNameCategory;
	}

	public BigDecimal getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}

	public BigDecimal getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}
	
	
	
	
	
	

}
