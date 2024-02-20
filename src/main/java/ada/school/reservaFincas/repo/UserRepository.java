package ada.school.reservaFincas.repo;


import java.util.Optional;

import ada.school.reservaFincas.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    //Optional<User> findByUsername(String name);
    Optional<User> findUserByEmail(String email);


}