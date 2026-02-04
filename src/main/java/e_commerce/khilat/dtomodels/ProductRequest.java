package e_commerce.khilat.dtomodels;

import java.math.BigDecimal;

public class ProductRequest {

    private Long categoryId;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private Boolean isActive;
    private String trending; // "y" or "n"

    // Getters & Setters
    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public String getTrending() { return trending; }
    public void setTrending(String trending) { this.trending = trending; }
}
