package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Kindergarten;
import ua.lviv.iot.repository.KindergartenRepository;

@Service
public class KindergartenService extends BaseService<Kindergarten, Integer> {

    @Autowired
    KindergartenRepository kindergartenRepository;

    @Override
    public JpaRepository<Kindergarten, Integer> getRepository() {
        return kindergartenRepository;
    }
}
