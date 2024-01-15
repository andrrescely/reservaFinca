package ada.school.reservaFincas.repo;


import java.util.Optional;

import ada.school.reservaFincas.user.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
    Optional<User> findUserByEmail(String email);


}