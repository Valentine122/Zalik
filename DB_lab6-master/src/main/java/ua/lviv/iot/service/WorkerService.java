package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Worker;
import ua.lviv.iot.repository.WorkerRepository;

@Service
public class WorkerService extends BaseService<Worker, Integer> {

    @Autowired
    WorkerRepository workerRepository;

    @Override
    public JpaRepository<Worker, Integer> getRepository() {
        return workerRepository;
    }
}
