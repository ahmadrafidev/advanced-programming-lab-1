package id.ac.ui.cs.advprog.eshop.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.payment.PaymentRepository;

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
        Payment payment = new Payment(null, null, null, null);
        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);

        // Act
        Payment result = paymentRepository.save(payment);

        // Assert
        assertNotNull(result);
        verify(paymentRepository).save(payment);
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

    @Test
    public void testFindPaymentById() {
        // Arrange
        Payment payment1 = new Payment("1", "Voucher", "PENDING", null);
        Payment payment2 = new Payment("2", "Cash on Delivery", "SUCCESS", null);
        List<Payment> payments = new ArrayList<>();
        payments.add(payment1);
        payments.add(payment2);

        // Stubbing the findById method
        when(paymentRepository.findById("1")).thenReturn(payment1);
        when(paymentRepository.findById("2")).thenReturn(payment2);
        when(paymentRepository.findById("3")).thenReturn(null); // Non-existent payment

        // Act
        Payment result1 = paymentRepository.findById("1");
        Payment result2 = paymentRepository.findById("2");
        Payment result3 = paymentRepository.findById("3");

        // Assert
        assertNotNull(result1);
        assertNotNull(result2);
        assertNull(result3); // Payment with ID "3" does not exist
        assertEquals("Voucher", result1.getMethod());
        assertEquals("Cash on Delivery", result2.getMethod());
    }
}