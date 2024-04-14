package szakdoga.Balatoni_szallas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import szakdoga.Balatoni_szallas.model.Role;
import szakdoga.Balatoni_szallas.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);
	
	Optional<User> findByEmail(String email);
	
	User  findByRole(Role role);
}