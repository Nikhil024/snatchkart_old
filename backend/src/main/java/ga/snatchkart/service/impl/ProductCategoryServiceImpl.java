package ga.snatchkart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ga.snatchkart.model.ProductCategory;
import ga.snatchkart.repository.ProductCategoryRepository;
import ga.snatchkart.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	@Override
	public void saveAllProductCategories(List<ProductCategory> productCategories) {
		productCategoryRepository.saveAll(productCategories);
	}

}
