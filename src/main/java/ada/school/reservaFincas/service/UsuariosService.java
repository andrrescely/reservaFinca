//package ada.school.reservaFincas.service;
//
//import ada.school.reservaFincas.entity.Usuarios;
//import ada.school.reservaFincas.repo.UserRepository;
//import ada.school.reservaFincas.user.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//
//@Service
//public class UsuariosService  {
//    @Autowired
//    private UserRepository userRepository;
//    public Usuarios insertar(Usuarios usu){
//        return userRepository.save(usu);
//    }
//    public Usuarios actualizar(Usuarios usu){
//        return userRepository.save();
//    }
//    public List<Usuarios> listar(){
//        return userRepository.findAll();
//    }
//    public void eliminar (Usuarios usu){
//        userRepository.delete(usu);
//    }
//}
