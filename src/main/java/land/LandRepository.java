package land;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LandRepository extends JpaRepository<Land, Long>{
	Optional<Land> findAll(String landName, String city, String town, String neighborhood, int area);
}
