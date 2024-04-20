package pl.arkadiusz.applicationtransporeon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arkadiusz.applicationtransporeon.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
