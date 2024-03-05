package id.ac.ui.cs.advprog.eshop.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.payment.PaymentRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class PaymentRepositoryTest {

    @Mock
    private PaymentRepository paymentRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSavePayment() {
        // Arrange
        Payment payment = new Payment();
        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);

        // Act
        Payment result = paymentRepository.save(payment);

        // Assert
        assertNotNull(result);
        verify(paymentRepository).save(payment);
    }

    @Test
    public void testFindPaymentById() {
        // Arrange
        Payment payment = new Payment("1", "Voucher", "PENDING", new HashMap<>());
        when(paymentRepository.findById("1")).thenReturn(Optional.of(payment));

        // Act
        Payment result = paymentRepository.findById("1");

        // Assert
        assertTrue(result.isPresent());
        assertEquals(payment.getId(), result.get().getId());
        assertEquals(payment.getMethod(), result.get().getMethod());
        assertEquals(payment.getStatus(), result.get().getStatus());
        assertEquals(payment.getPaymentData(), result.get().getPaymentData());
    }

    @Test
    public void testFindAllPayments() {
        // Arrange
        List<Payment> payments = new ArrayList<>();
        Payment payment1 = new Payment("1", "Voucher", "PENDING", new HashMap<>());
        Payment payment2 = new Payment("2", "Cash on Delivery", "SUCCESS", new HashMap<>());
        payments.add(payment1);
        payments.add(payment2);

        when(paymentRepository.findAll()).thenReturn(payments);

        // Act
        List<Payment> result = paymentRepository.findAll();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(payments, result);
    }
}
