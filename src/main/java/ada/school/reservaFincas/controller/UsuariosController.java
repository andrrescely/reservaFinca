package ada.school.reservaFincas.controller;

import ada.school.reservaFincas.entity.Usuarios;
import ada.school.reservaFincas.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("usuarios")
public class UsuariosController {
    @Autowired
    private UsuariosService usuariosService;

    @GetMapping
    public List<Usuarios> listar() {
        return usuariosService.listar();
    }

    @PostMapping
    public Usuarios insertar(@RequestBody Usuarios usu) {
        return usuariosService.insertar(usu);
    }

    @PutMapping
    public Usuarios actualizar(@RequestBody Usuarios usu) {
        return usuariosService.actualizar(usu);
    }

    @DeleteMapping
    public void eliminar(@RequestBody Usuarios usu) {
        usuariosService.eliminar(usu);
    }
}
