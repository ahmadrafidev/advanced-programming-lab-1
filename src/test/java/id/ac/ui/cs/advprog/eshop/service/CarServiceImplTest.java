package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CarServiceImplTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarServiceImpl carService;

    private Car testCar;

    @BeforeEach
    void setUp() {
        // Initialize a test car object
        testCar = new Car();
        testCar.setCarId("1");
        testCar.setCarName("Test Car");
        testCar.setCarColor("Blue");
        testCar.setCarQuantity(1);
    }

    @Test
    void testCreateCar() {
        when(carRepository.create(any(Car.class))).thenReturn(testCar);

        Car createdCar = carService.create(testCar);
        assertNotNull(createdCar);
        assertEquals(testCar.getCarName(), createdCar.getCarName());
        assertEquals(testCar.getCarColor(), createdCar.getCarColor());
        assertEquals(testCar.getCarQuantity(), createdCar.getCarQuantity());

        verify(carRepository).create(any(Car.class));
    }

    @Test
    void testFindAllCars() {
        when(carRepository.findAll()).thenReturn(Collections.singletonList(testCar));

        List<Car> cars = carService.findAll();
        assertFalse(cars.isEmpty());
        assertEquals(1, cars.size());
        assertEquals(testCar, cars.get(0));

        verify(carRepository).findAll();
    }

    @Test
    void testFindById() {
        when(carRepository.findById(anyString())).thenReturn(testCar);

        Car foundCar = carService.findById("1");
        assertNotNull(foundCar);
        assertEquals(testCar.getCarId(), foundCar.getCarId());

        verify(carRepository).findById(anyString());
    }

    @Test
    void testUpdateCar() {
        when(carRepository.update(anyString(), any(Car.class))).thenReturn(testCar);

        assertDoesNotThrow(() -> carService.update("1", testCar));
        verify(carRepository).update(anyString(), any(Car.class));
    }

    @Test
    void testDeleteCarById() {
        doNothing().when(carRepository).delete(anyString());

        assertDoesNotThrow(() -> carService.deleteCarById("1"));
        verify(carRepository).delete(anyString());
    }

    @Test
    void testCreateCarWithNullValues() {
        assertThrows(IllegalArgumentException.class, () -> carService.create(null));

        Car invalidCar = new Car();
        assertThrows(IllegalArgumentException.class, () -> carService.create(invalidCar));
    }

    @Test
    void testFindByIdWithInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> carService.findById(null));
        assertThrows(IllegalArgumentException.class, () -> carService.findById(""));
        assertThrows(RuntimeException.class, () -> carService.findById("nonexistent"));
    }

    @Test
    void testUpdateCarWithInvalidValues() {
        assertThrows(IllegalArgumentException.class, () -> carService.update(null, testCar));
        assertThrows(IllegalArgumentException.class, () -> carService.update("1", null));
        when(carRepository.update(anyString(), any(Car.class))).thenReturn(null);
        assertThrows(IllegalArgumentException.class, () -> carService.update("1", testCar));
    }
}
