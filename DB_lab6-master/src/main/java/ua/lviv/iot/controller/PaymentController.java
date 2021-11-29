package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.domain.Payment;
import ua.lviv.iot.service.PaymentService;
import ua.lviv.iot.service.ServiceTemplate;

@RestController
@RequestMapping("/payment")
public class PaymentController extends BaseController<Payment, Integer> {

    @Autowired
    PaymentService paymentService;

    @Override
    public ServiceTemplate<Payment, Integer> getService() {
        return paymentService;
    }
}
