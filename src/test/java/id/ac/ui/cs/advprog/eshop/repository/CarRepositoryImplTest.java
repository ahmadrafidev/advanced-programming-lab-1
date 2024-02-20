package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.car.CarRepositoryImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarRepositoryImplTest {

    @Autowired
    private CarRepositoryImpl carRepository;

    private Car testCar;

    @BeforeEach
    void setUp() {
        // Setup a test car
        testCar = new Car();
        testCar.setCarName("Test Car");
        testCar.setCarColor("Red");
        testCar.setCarQuantity(1);
        // Create the car in the repository
        carRepository.create(testCar);
    }

    @Test
    void testCreateCar() {
        assertNotNull(testCar.getCarId());
        assertEquals("Test Car", testCar.getCarName());
        assertEquals("Red", testCar.getCarColor());
        assertEquals(1, testCar.getCarQuantity());
    }

    @Test
    void testFindAllCars() {
        List<Car> cars = carRepository.findAll();
        assertFalse(cars.isEmpty());
    }

    @Test
    void testFindById() {
        Car foundCar = carRepository.findById(testCar.getCarId());
        assertNotNull(foundCar);
        assertEquals(testCar.getCarId(), foundCar.getCarId());
    }

    @Test
    void testUpdateCar() {
        Car updatedCar = new Car();
        updatedCar.setCarName("Updated Car");
        updatedCar.setCarColor("Blue");
        updatedCar.setCarQuantity(2);
        Car result = carRepository.update(testCar.getCarId(), updatedCar);

        assertNotNull(result);
        assertEquals("Updated Car", result.getCarName());
        assertEquals("Blue", result.getCarColor());
        assertEquals(2, result.getCarQuantity());
    }

    @Test
    void testDeleteCar() {
        carRepository.delete(testCar.getCarId());
        assertNull(carRepository.findById(testCar.getCarId()));
    }

    @Test
    void testCreateCarWithNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            carRepository.create(null);
        });
        assertEquals("Cannot create a null car.", exception.getMessage());
    }
}
