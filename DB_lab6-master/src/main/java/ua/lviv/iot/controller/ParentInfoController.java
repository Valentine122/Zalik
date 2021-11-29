package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.domain.ParentInfo;
import ua.lviv.iot.service.ParentInfoService;
import ua.lviv.iot.service.ServiceTemplate;

@RestController
@RequestMapping("/parent-info")
public class ParentInfoController extends BaseController<ParentInfo, Integer> {

    @Autowired
    ParentInfoService parentInfoService;

    @Override
    public ServiceTemplate<ParentInfo, Integer> getService() {
        return parentInfoService;
    }
}
