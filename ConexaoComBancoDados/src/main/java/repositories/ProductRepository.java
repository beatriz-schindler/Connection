package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionFactory;
import model.Product;
import services.ProductService;

public class ProductRepository {

	private Connection conn;
	private ProductService service;
	
	public ProductRepository() {
		this.conn = ConnectionFactory.getConnection();
	}
	 
	public List<Product> findAll() {
		
		service = new ProductService();
		
		PreparedStatement stmt;
		List<Product> products = new ArrayList<Product>();
		
		try {
			
			stmt = conn.prepareStatement("SELECT * FROM tb_product");
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				Product product = service.instantiateProduct(result);
				products.add(product);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		
		return products;
	}
}
