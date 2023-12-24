package ada.school.reservaFincas.repo;

import ada.school.reservaFincas.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

//heredar metodos de la clase jpaRepository
public interface UsuarioRepo  extends JpaRepository<Usuarios,Integer> {
}
