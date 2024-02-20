package ada.school.reservaFincas.service;


import ada.school.reservaFincas.repo.UserRepository;
import ada.school.reservaFincas.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuariosService  {
    @Autowired
    private UserRepository userRepository;
    public User insertar(User usu){
        return userRepository.save(usu);
    }
    public User actualizar(User usu){
        return userRepository.save(usu);
    }
    public List<User> listar(){
        return this.userRepository.findAll();
    }
    public void eliminar (User usu){
        userRepository.delete(usu);
    }
}
