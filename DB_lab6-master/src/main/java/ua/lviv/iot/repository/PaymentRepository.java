package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
