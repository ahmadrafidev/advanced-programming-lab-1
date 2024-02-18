package id.ac.ui.cs.advprog.eshop.repository;
import id.ac.ui.cs.advprog.eshop.model.Car;
import org.springframework.stereotype.Repository;
import java.util.ArrayList; 
import java.util.List; 
import java.util.UUID;

/**
 * Car Repository Implementation
 */
@Repository
public class CarRepositoryImpl implements CarRepository {
    private final List<Car> carData = new ArrayList<>();

    @Override
    public Car create(Car car) { 
        if (car == null) {
            // Simple check for null input
            throw new IllegalArgumentException("Cannot create a null car.");
        }
        // Ensure the car has a unique ID
        if (car.getCarId() == null || car.getCarId().trim().isEmpty()) {
            car.setCarId(UUID.randomUUID().toString());
        }
        carData.add(car);
        return car;
    }

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(carData); 
    }

    @Override
    public Car findById(String id) {
        if (id == null || id.trim().isEmpty()) {
            // Simple check for invalid ID
            throw new IllegalArgumentException("Car ID must not be null or empty.");
        }
        for (Car car : carData) {
            if (id.equals(car.getCarId())) {
                return car;
            }
        }
        return null; 
    }

    @Override
    public Car update(String id, Car updatedCar) { 
        if (id == null || id.trim().isEmpty() || updatedCar == null) {
            // Check for invalid ID or car
            throw new IllegalArgumentException("Car ID and Car must not be null or empty.");
        }
        for (Car car : carData) {
            if (id.equals(car.getCarId())) {
                car.setCarName(updatedCar.getCarName());
                car.setCarColor(updatedCar.getCarColor());
                car.setCarQuantity(updatedCar.getCarQuantity());
                return car;
            }
        }
        return null; 
    }
    
    @Override
    public void delete(String id) { 
        if (id == null || id.trim().isEmpty()) {
            // Simple check for invalid ID
            throw new IllegalArgumentException("Car ID must not be null or empty.");
        }
        carData.removeIf(car -> id.equals(car.getCarId())); 
    }
}
