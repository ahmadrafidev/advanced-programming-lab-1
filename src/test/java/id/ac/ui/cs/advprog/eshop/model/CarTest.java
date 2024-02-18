package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        // Initialize car with test data
        car = new Car();
        car.setCarId("ID123");
        car.setCarName("Toyota Camry");
        car.setCarColor("Black");
        car.setCarQuantity(5);
    }

    @Test
    void testGetCarId() {
        assertEquals("ID123", car.getCarId(), "Car ID did not match the expected value.");
    }

    @Test
    void testGetCarName() {
        assertEquals("Toyota Camry", car.getCarName(), "Car Name did not match the expected value.");
    }

    @Test
    void testGetCarColor() {
        assertEquals("Black", car.getCarColor(), "Car Color did not match the expected value.");
    }

    @Test
    void testGetCarQuantity() {
        assertEquals(5, car.getCarQuantity(), "Car Quantity did not match the expected value.");
    }
}
