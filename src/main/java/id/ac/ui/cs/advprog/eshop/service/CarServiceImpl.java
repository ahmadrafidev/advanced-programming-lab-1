package id.ac.ui.cs.advprog.eshop.service;
import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public Car create(Car car) {
        if (car == null || car.getCarName() == null || car.getCarColor() == null) {
            // Handle null car or essential attributes being null
            throw new IllegalArgumentException("Car and its essential attributes must not be null.");
        }
        return carRepository.create(car);
    }

    @Override
    public List<Car> findAll() {
        List<Car> cars = carRepository.findAll();
        if (cars == null) {
            return Collections.emptyList();
        }
        return cars;
    }

    @Override
    public Car findById(String carId){
        if (carId == null || carId.trim().isEmpty()) {
            throw new IllegalArgumentException("Car ID must not be null or empty.");
        }
        return Optional.ofNullable(carRepository.findById(carId))
                       .orElseThrow(() -> new RuntimeException("Car not found with ID: " + carId));
    }

    @Override
    public void update(String carId, Car car) {
        if (carId == null || carId.trim().isEmpty() || car == null) {
            throw new IllegalArgumentException("Car ID and Car must not be null or empty.");
        }
        if (carRepository.update(carId, car) == null) {
            throw new IllegalArgumentException("Failed to update. Car not found with ID: " + carId);
        }
    }

    @Override
    public void deleteCarById(String carId) {
        if (carId == null || carId.trim().isEmpty()) {
            throw new IllegalArgumentException("Car ID must not be null or empty.");
        }
        carRepository.delete(carId);
    }
}
