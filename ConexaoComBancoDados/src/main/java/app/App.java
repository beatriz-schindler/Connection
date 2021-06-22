package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import services.ProductService;

@WebServlet ("/app")
public class App extends HttpServlet{


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
			ProductService service = new ProductService();
			List<Product> products = new ArrayList<Product>();
			
			products = service.findAll();
			
			req.setAttribute("produto", products);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
			dispatcher.forward(req, resp);
		}
			
}
	

