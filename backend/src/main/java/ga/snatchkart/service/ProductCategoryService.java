package ga.snatchkart.service;

import java.util.List;

import ga.snatchkart.model.ProductCategory;

public interface ProductCategoryService {
	void saveAllProductCategories(List<ProductCategory> productCategories);
}
