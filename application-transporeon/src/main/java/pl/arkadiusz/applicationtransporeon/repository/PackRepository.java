package pl.arkadiusz.applicationtransporeon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arkadiusz.applicationtransporeon.model.entity.Pack;

@Repository
public interface PackRepository extends JpaRepository<Pack, Long> {
}
