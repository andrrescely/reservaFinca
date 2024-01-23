package ada.school.reservaFincas.service;
import ada.school.reservaFincas.lasting.ERole;
import ada.school.reservaFincas.repo.UserRepository;
import ada.school.reservaFincas.service.UsuariosService;
import ada.school.reservaFincas.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UsuariosServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UsuariosService usuariosService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void insertar() {
        // Arrange
        User expectedUser = User.builder()
                .id(1)
                .name("John Doe")
                .email("john@example.com")
                .password("password")
                .enable(true)
                .role(ERole.USER)
                .build();

        when(userRepository.save(any(User.class))).thenReturn(expectedUser);


        User actualUser = usuariosService.insertar(expectedUser);


        assertEquals(expectedUser, actualUser);
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void actualizar() {

        User expectedUser = User.builder()
                .id(1)
                .name("John Doe")
                .email("john@example.com")
                .password("password")
                .enable(true)
                .role(ERole.USER)
                .build();

        when(userRepository.save(any(User.class))).thenReturn(expectedUser);


        User actualUser = usuariosService.actualizar(expectedUser);


        assertEquals(expectedUser, actualUser);
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void listar() {

        List<User> expectedUsers = Arrays.asList(
                User.builder().id(1).name("John Doe").email("john@example.com").password("password").enable(true).role(ERole.USER).build(),
                User.builder().id(2).name("Jane Doe").email("jane@example.com").password("password").enable(true).role(ERole.ADMIN).build()
        );

        when(userRepository.findAll()).thenReturn(expectedUsers);


        List<User> actualUsers = usuariosService.listar();


        assertEquals(expectedUsers, actualUsers);
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void eliminar() {

        User userToDelete = User.builder()
                .id(1)
                .name("John Doe")
                .email("john@example.com")
                .password("password")
                .enable(true)
                .role(ERole.USER)
                .build();


        usuariosService.eliminar(userToDelete);


        verify(userRepository, times(1)).delete(userToDelete);
    }
}
