package szakdoga.Balatoni_szallas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import szakdoga.Balatoni_szallas.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{
	List<Review> findByApartmanId(Long apartmanId);
}
