package szakdoga.Balatoni_szallas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import szakdoga.Balatoni_szallas.model.Apartman;
import szakdoga.Balatoni_szallas.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	List<Reservation> findByUserId(Long userId);
	List<Reservation> findByApartman(Apartman apartman);
}
