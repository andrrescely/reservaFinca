package ada.school.reservaFincas.controller;

import ada.school.reservaFincas.entity.Finca;
import ada.school.reservaFincas.service.FincaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FincaControllerTest {

    @Mock
    private FincaService fincaService;

    @InjectMocks
    private FincaController fincaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listar() {

        List<Finca> expectedFincas = Arrays.asList(
                createFinca(1, "Finca 1", "Ubicación 1", 5),
                createFinca(2, "Finca 2", "Ubicación 2", 8)
        );

        when(fincaService.listar()).thenReturn(expectedFincas);


        List<Finca> actualFincas = fincaController.listar();


        assertEquals(expectedFincas, actualFincas);
        verify(fincaService, times(1)).listar();
    }

    @Test
    void insertar() {

        Finca expectedFinca = createFinca(1, "Nombre de la Finca", "Ubicación", 10);

        when(fincaService.insertar(any(Finca.class))).thenReturn(expectedFinca);


        Finca actualFinca = fincaController.insertar(new Finca());


        assertEquals(expectedFinca, actualFinca);
        verify(fincaService, times(1)).insertar(any(Finca.class));
    }

    @Test
    void actualizar() {

        Finca expectedFinca = createFinca(1, "Nombre de la Finca", "Ubicación", 10);

        when(fincaService.actualizar(any(Finca.class))).thenReturn(expectedFinca);


        Finca actualFinca = fincaController.actualizar(new Finca());


        assertEquals(expectedFinca, actualFinca);
        verify(fincaService, times(1)).actualizar(any(Finca.class));
    }

    @Test
    void eliminar() {

        Finca fincaToDelete = createFinca(1, "Nombre de la Finca", "Ubicación", 10);


        fincaController.eliminar(fincaToDelete);


        verify(fincaService, times(1)).eliminar(fincaToDelete);
    }

    private Finca createFinca(Integer id, String nombre, String direccion, Integer capacidad) {
        Finca finca = new Finca();
        finca.setId(id);
        finca.setNombre(nombre);
        finca.setDireccion(direccion);
        finca.setCapacidad(capacidad);
        return finca;
    }
}
