package alten.back;

//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import alten.back.model.InventoryStatus;
//import alten.back.model.Product;
//import alten.back.service.ProductService;
//
//@Component
//public class AppRunner implements CommandLineRunner {
//	
//	@Autowired
//	ProductService productService;
//
//	@Override
//	public void run(String... args) throws Exception {
//		
//		Product p1 = new Product(9,"code","nom","desc","image","cat",9.99f,1,"ir",1000,InventoryStatus.INSTOCK,5.0f,11,11);
//		
//		productService.createProduct(p1);
//		
//		List<Product> products = productService.getAllProducts();
//		products.forEach((p) -> System.out.println(p.getId()+ " " + p.getCode()));
//		
//	}
//
//}
