package ar.edu.utn.frc.tup.lc.iv.clients.cargos;

import ar.edu.utn.frc.tup.lc.iv.clients.distritos.Distrito;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

class CargoDistritoTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        CargoDistrito cargoDistrito = new CargoDistrito();
        Distrito distrito = new Distrito();
        distrito.setDistritoId(1L);
        distrito.setDistritoNombre("Córdoba");

        Cargos cargo1 = new Cargos(1, "PRESUDENTE", 1);
        List<Cargos> cargos = Arrays.asList(cargo1);

        // Act
        cargoDistrito.setDistrito(distrito);
        cargoDistrito.setCargos(cargos);

        // Assert
        assertEquals(distrito, cargoDistrito.getDistrito());
        assertEquals(cargos, cargoDistrito.getCargos());
    }

    @Test
    void testEqualsAndHashCode() {
        // Arrange
        Distrito distrito = new Distrito(1L, "Test");

        Cargos cargo = new Cargos(1, "PRESUDENTE", 1);

        List<Cargos> cargos = Arrays.asList(cargo);

        CargoDistrito cargoDistrito1 = new CargoDistrito(distrito, cargos);
        CargoDistrito cargoDistrito2 = new CargoDistrito(distrito, cargos);
        CargoDistrito cargoDistrito3 = new CargoDistrito();

        // Assert
        assertEquals(cargoDistrito1, cargoDistrito2);
        assertNotEquals(cargoDistrito1, cargoDistrito3);
        assertEquals(cargoDistrito1.hashCode(), cargoDistrito2.hashCode());
    }

    @Test
    void testToString() {
        // Arrange
        Distrito distrito = new Distrito(1L, "Test");

        Cargos cargo = new Cargos(1, "PRESUDENTE", 1);

        List<Cargos> cargos = Arrays.asList(cargo);

        CargoDistrito cargoDistrito = new CargoDistrito(distrito, cargos);

        // Act
        String toString = cargoDistrito.toString();

        // Assert
        assertTrue(toString.contains("distrito"));
        assertTrue(toString.contains("cargos"));
    }

    @Test
    void testConstructors() {
        // Test NoArgsConstructor
        CargoDistrito cargoDistrito1 = new CargoDistrito();
        assertNull(cargoDistrito1.getDistrito());
        assertNull(cargoDistrito1.getCargos());

        // Test AllArgsConstructor
        Distrito distrito = new Distrito();
        List<Cargos> cargos = Arrays.asList(new Cargos(1, "Test", 1));
        CargoDistrito cargoDistrito2 = new CargoDistrito(distrito, cargos);
        assertEquals(distrito, cargoDistrito2.getDistrito());
        assertEquals(cargos, cargoDistrito2.getCargos());
    }
}