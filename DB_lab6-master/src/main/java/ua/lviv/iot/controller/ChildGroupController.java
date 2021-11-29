package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.domain.ChildGroup;
import ua.lviv.iot.service.ChildGroupService;
import ua.lviv.iot.service.ServiceTemplate;

@RestController
@RequestMapping("/child-group")
public class ChildGroupController extends BaseController<ChildGroup, Integer> {

    @Autowired
    ChildGroupService childGroupService;

    @Override
    public ServiceTemplate<ChildGroup, Integer> getService() {
        return childGroupService;
    }
}
