package id.ac.ui.cs.advprog.eshop.service.payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.order.OrderRepository;
import id.ac.ui.cs.advprog.eshop.repository.payment.PaymentRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Payment addPayment(Order order, String method, Map<String, String> paymentData) {
        if (order == null || order.getProducts().isEmpty()) {
            throw new IllegalArgumentException("Order must have at least one product.");
        }

        Payment payment = new Payment();
        payment.setMethod(method);
        payment.setStatus("PENDING");
        payment.setPaymentData(paymentData);

        Payment savedPayment = paymentRepository.save(payment);
        return savedPayment;
    }

    @Override
    public Payment setStatus(Payment payment, String status) {
        if (!isValidStatus(status)) {
            throw new IllegalArgumentException("Invalid payment status.");
        }

        payment.setStatus(status);
        paymentRepository.save(payment);

        // Update related order status
        Optional<Order> optionalOrder = orderRepository.findByPaymentId(payment.getId());
        optionalOrder.ifPresent(order -> {
            order.setStatus(status.equals("SUCCESS") ? OrderStatus.SUCCESS : OrderStatus.FAILED);
            orderRepository.save(order);
        });

        return payment;
    }

    @Override
    public Payment getPayment(String paymentId) {
        Optional<Payment> optionalPayment = paymentRepository.findById(paymentId);
        return optionalPayment.orElse(null);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    private boolean isValidStatus(String status) {
        return status.equals("SUCCESS") || status.equals("REJECTED") || status.equals("PENDING");
    }
}

