package ada.school.reservaFincas.controller;

import ada.school.reservaFincas.service.UsuariosService;
import ada.school.reservaFincas.entity.User;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("user")
public class UsuariosController {
    @Autowired
    private UsuariosService usuariosService;

    @GetMapping
    @SecurityRequirement(name = "bearerAuth")
    public List<User> listar() {
        return usuariosService.listar();
    }

    @PostMapping
    public User insertar(@RequestBody User usu) {
        return usuariosService.insertar(usu);
    }

    @PutMapping
    public User actualizar(@RequestBody User usu) {
        return usuariosService.actualizar(usu);
    }

    @DeleteMapping
    public void eliminar(@RequestBody User usu) {
        usuariosService.eliminar(usu);
    }
}
