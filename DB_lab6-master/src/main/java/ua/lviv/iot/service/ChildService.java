package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Child;
import ua.lviv.iot.repository.ChildRepository;

@Service
public class ChildService extends BaseService<Child, Integer> {

    @Autowired
    ChildRepository childRepository;

    @Override
    public JpaRepository<Child, Integer> getRepository() {
        return childRepository;
    }
}
