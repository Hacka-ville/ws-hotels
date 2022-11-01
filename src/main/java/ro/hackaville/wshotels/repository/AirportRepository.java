package ro.hackaville.wshotels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.hackaville.wshotels.model.entity.Airport;

public interface AirportRepository extends JpaRepository<Airport, String> {
}
