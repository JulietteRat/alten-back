package alten.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import alten.back.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
