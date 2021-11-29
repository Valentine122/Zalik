package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.domain.Vaccination;
import ua.lviv.iot.service.ServiceTemplate;
import ua.lviv.iot.service.VaccinationService;

@RestController
@RequestMapping("/vaccination")
public class VaccinationController extends BaseController<Vaccination, Integer> {

    @Autowired
    VaccinationService vaccinationService;

    @Override
    public ServiceTemplate<Vaccination, Integer> getService() {
        return vaccinationService;
    }
}
