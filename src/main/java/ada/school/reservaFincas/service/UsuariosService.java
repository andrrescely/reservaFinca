package ada.school.reservaFincas.service;

import ada.school.reservaFincas.entity.Usuarios;
import ada.school.reservaFincas.repo.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuariosService  {
    @Autowired
    private UsuarioRepo usuarioRepo;
    public Usuarios insertar(Usuarios usu){
        return usuarioRepo.save(usu);
    }
    public Usuarios actualizar(Usuarios usu){
        return usuarioRepo.save(usu);
    }
    public List<Usuarios> listar(){
        return usuarioRepo.findAll();
    }
    public void eliminar (Usuarios usu){
        usuarioRepo.delete(usu);
    }
}
