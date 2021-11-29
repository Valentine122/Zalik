package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Payment;
import ua.lviv.iot.repository.PaymentRepository;

@Service
public class PaymentService extends BaseService<Payment, Integer> {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public JpaRepository<Payment, Integer> getRepository() {
        return paymentRepository;
    }
}
