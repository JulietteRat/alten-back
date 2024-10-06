package alten.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import alten.back.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByUsername(String username);
}
