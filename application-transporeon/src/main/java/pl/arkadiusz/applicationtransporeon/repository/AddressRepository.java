package pl.arkadiusz.applicationtransporeon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arkadiusz.applicationtransporeon.model.entity.customer.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
