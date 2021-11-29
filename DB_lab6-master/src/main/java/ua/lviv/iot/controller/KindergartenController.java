package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.domain.Kindergarten;
import ua.lviv.iot.service.KindergartenService;
import ua.lviv.iot.service.ServiceTemplate;

@RestController
@RequestMapping("/kindergarten")
public class KindergartenController extends BaseController<Kindergarten, Integer> {

    @Autowired
    KindergartenService kindergartenService;

    @Override
    public ServiceTemplate<Kindergarten, Integer> getService() {
        return kindergartenService;
    }
}
