package szakdoga.Balatoni_szallas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import szakdoga.Balatoni_szallas.model.Apartman;

public interface ApartmanRepository extends JpaRepository<Apartman, Long>{
	List<Apartman> findByOwnerId(Long ownerId);

}
