package alten.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import alten.back.service.ProductService;
import alten.back.service.UserService;

@Component
public class AppRunner implements CommandLineRunner {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userServiceImp;

	@Override
	public void run(String... args) throws Exception {
		
//		Product p1 = new Product(1000, "f230fh0g3", "Bamboo Watch", "Product Description", 
//		                "bamboo-watch.jpg", "Accessories", 65f, 1, 
//		                "REF-123-456", 15, InventoryStatus.INSTOCK, 5.0f, 
//		                1718114215761L, 1718114215761L);
//		
//		Product p2 = new Product(1001, "nvklal433", "Black Watch", "Product Description", 
//		                "black-watch.jpg", "Accessories", 72f, 1, 
//		                "REF-123-456", 15, InventoryStatus.INSTOCK, 4.0f, 
//		                1718114215761L, 1718114215761L);
//		
//		Product p3 = new Product(1002, "zz21cz3c1", "Blue Band", "Product Description", 
//		                "blue-band.jpg", "Fitness", 79f, 1, 
//		                "REF-123-456", 15, InventoryStatus.LOWSTOCK, 3.0f, 
//		                1718114215761L, 1718114215761L);
//		
//		Product p2 = new Product(9,"code","chatVivant","desc","image","cat",10000000f,1,"ir",1000,InventoryStatus.INSTOCK,5.0f,11,11);
//		productService.createProduct(p1);
//		productService.createProduct(p2);
//		productService.createProduct(p3);
//		
//		List<Product> products = productService.getAllProducts();
//		products.forEach((p) -> System.out.println(p.getId()+ " " + p.getCode()));
		
//		User u1 = new User();
//		u1.setUsername("admin");
//		u1.setPassword("password");
//		u1.setRole(UserRole.ADMIN);
//		userServiceImp.saveUser(u1);
		
		
//		System.out.println(u1.getRole());
		
	}

}
