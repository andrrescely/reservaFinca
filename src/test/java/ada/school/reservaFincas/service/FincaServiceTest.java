package ada.school.reservaFincas.service;

import ada.school.reservaFincas.entity.Finca;
import ada.school.reservaFincas.repo.FincaRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import java.util.Arrays;
import java.util.List;
class FincaServiceTest {

    @Mock
    private FincaRepo fincaRepo;

    @InjectMocks
    private FincaService fincaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void insertar() {

        Finca expectedFinca = new Finca();
        expectedFinca.setId(1);
        expectedFinca.setNombre("Nombre de la Finca");
        expectedFinca.setDireccion("Ubicación");
        expectedFinca.setCapacidad(10);
        expectedFinca.setPrecio("70.000");

        when(fincaRepo.save(any(Finca.class))).thenReturn(expectedFinca);


        Finca actualFinca = fincaService.insertar(new Finca());


        assertEquals(expectedFinca, actualFinca);
        verify(fincaRepo, times(1)).save(any(Finca.class));
    }

    @Test
    void actualizar() {

        Finca expectedFinca = new Finca();
        expectedFinca.setId(1);
        expectedFinca.setNombre("Nombre de la Finca");
        expectedFinca.setDireccion("Ubicación");
        expectedFinca.setCapacidad(10);
        expectedFinca.setPrecio("70.000");

        when(fincaRepo.save(any(Finca.class))).thenReturn(expectedFinca);


        Finca actualFinca = fincaService.actualizar(new Finca());


        assertEquals(expectedFinca, actualFinca);
        verify(fincaRepo, times(1)).save(any(Finca.class));
    }

    @Test
    void listar() {
        // Arrange
        List<Finca> expectedFincas = Arrays.asList(
                createFinca(1, "Finca 1", "Ubicación 1", 5, "70.000" ),
                createFinca(2, "Finca 2", "Ubicación 2", 8, "100.000")
        );

        when(fincaRepo.findAll()).thenReturn(expectedFincas);


        List<Finca> actualFincas = fincaService.listar();


        assertEquals(expectedFincas, actualFincas);
        verify(fincaRepo, times(1)).findAll();
    }

    @Test
    void eliminar() {

        Finca fincaToDelete = createFinca(1, "Nombre de la Finca", "Ubicación", 10, "70.000");


        fincaService.eliminar(fincaToDelete);


        verify(fincaRepo, times(1)).delete(fincaToDelete);
    }


    private Finca createFinca(Integer id, String nombre, String direccion, Integer capacidad, String precio) {
        Finca finca = new Finca();
        finca.setId(id);
        finca.setNombre(nombre);
        finca.setDireccion(direccion);
        finca.setCapacidad(capacidad);
        finca.setPrecio(precio);
        return finca;
    }
}