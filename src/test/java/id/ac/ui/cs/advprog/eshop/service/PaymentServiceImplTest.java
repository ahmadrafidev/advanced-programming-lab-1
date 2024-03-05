package id.ac.ui.cs.advprog.eshop.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.order.OrderRepository;
import id.ac.ui.cs.advprog.eshop.repository.payment.PaymentRepository;
import id.ac.ui.cs.advprog.eshop.service.payment.PaymentServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PaymentServiceImplTest {

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddPayment() {
        // Arrange
        Order order = new Order();
        Map<String, String> paymentData = new HashMap<>();
        Payment payment = new Payment("1", "Voucher", "PENDING", paymentData);

        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);

        // Act
        Payment result = paymentService.addPayment(order, "Voucher", paymentData);

        // Assert
        assertNotNull(result);
        assertEquals(payment.getId(), result.getId());
        assertEquals(payment.getMethod(), result.getMethod());
        assertEquals(payment.getStatus(), result.getStatus());
        assertEquals(paymentData, result.getPaymentData());
        verify(paymentRepository).save(any(Payment.class));
    }

    @Test
    public void testSetStatus() {
        // Arrange
        Payment payment = new Payment("1", "Voucher", "PENDING", new HashMap<>());

        when(paymentRepository.findById(any(String.class))).thenReturn(Optional.of(payment));
        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);

        // Act
        Payment updatedPayment = paymentService.setStatus(payment, "SUCCESS");

        // Assert
        assertEquals("SUCCESS", updatedPayment.getStatus());
        verify(paymentRepository).save(payment);
    }

    @Test
    public void testGetPayment() {
        // Arrange
        Payment payment = new Payment("1", "Voucher", "PENDING", new HashMap<>());

        when(paymentRepository.findById(any(String.class))).thenReturn(Optional.of(payment));

        // Act
        Payment result = paymentService.getPayment("1");

        // Assert
        assertNotNull(result);
        assertEquals(payment.getId(), result.getId());
        assertEquals(payment.getMethod(), result.getMethod());
        assertEquals(payment.getStatus(), result.getStatus());
        assertEquals(payment.getPaymentData(), result.getPaymentData());
    }

    @Test
    public void testGetAllPayments() {
        // Arrange
        List<Payment> payments = new ArrayList<>();
        Payment payment1 = new Payment("1", "Voucher", "PENDING", new HashMap<>());
        Payment payment2 = new Payment("2", "Cash on Delivery", "SUCCESS", new HashMap<>());
        payments.add(payment1);
        payments.add(payment2);

        when(paymentRepository.findAll()).thenReturn(payments);

        // Act
        List<Payment> result = paymentService.getAllPayments();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(payments, result);
    }
}

