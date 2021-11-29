package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.domain.Worker;
import ua.lviv.iot.service.ServiceTemplate;
import ua.lviv.iot.service.WorkerService;

@RestController
@RequestMapping("/worker")
public class WorkerController extends BaseController<Worker, Integer> {

    @Autowired
    WorkerService workerService;

    @Override
    public ServiceTemplate<Worker, Integer> getService() {
        return workerService;
    }
}
