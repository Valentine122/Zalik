package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.domain.Child;
import ua.lviv.iot.service.ChildService;
import ua.lviv.iot.service.ServiceTemplate;

@RestController
@RequestMapping("/child")
public class ChildController extends BaseController<Child, Integer> {

    @Autowired
    ChildService childService;

    @Override
    public ServiceTemplate<Child, Integer> getService() {
        return childService;
    }

}
