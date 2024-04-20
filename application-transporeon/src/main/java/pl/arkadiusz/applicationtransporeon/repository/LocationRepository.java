package pl.arkadiusz.applicationtransporeon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arkadiusz.applicationtransporeon.model.entity.BaseLocation;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<BaseLocation, Long> {

    List<BaseLocation> findByCountryName(final String countryName);
    Optional<BaseLocation> findByCityName(final String cityName);
}
