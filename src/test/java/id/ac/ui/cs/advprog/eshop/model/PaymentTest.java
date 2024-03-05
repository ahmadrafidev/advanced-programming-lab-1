package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PaymentTest {
    private Map<String, String> paymentData;

    @BeforeEach
    void setUp() {
        this.paymentData = new HashMap<>();
        this.paymentData.put("voucherCode", "ABC123");
    }

    @Test
    void testCreatePaymentWithVoucherCode() {
        Payment payment = new Payment("1", "Voucher", "PENDING", paymentData);
        assertEquals("1", payment.getId());
        assertEquals("Voucher", payment.getMethod());
        assertEquals("PENDING", payment.getStatus());
        assertEquals("ABC123", payment.getPaymentData().get("voucherCode"));
    }

    @Test
    void testCreatePaymentWithInvalidStatus() {
        assertThrows(IllegalArgumentException.class, () -> new Payment("1", "Voucher", "INVALID", paymentData));
    }

    @Test
    void testCreatePaymentWithoutVoucherCode() {
        paymentData.clear();
        assertThrows(IllegalArgumentException.class, () -> new Payment("1", "Voucher", "PENDING", paymentData));
    }
}