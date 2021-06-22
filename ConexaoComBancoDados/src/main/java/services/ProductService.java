package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Product;
import repositories.ProductRepository;

public class ProductService {

	ProductRepository repository;
	
	public ProductService() {
		this.repository = new ProductRepository();
	}
	
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product instantiateProduct(ResultSet result) throws SQLException {
		
		Product product = new Product();
		
		product.setId(result.getLong("id"));
		product.setName(result.getString("name"));
		product.setPrice(result.getDouble("price"));
		product.setImageUri(result.getString("image_uri"));
		product.setDescription(result.getString("description"));
		
		return product;
	}
}
