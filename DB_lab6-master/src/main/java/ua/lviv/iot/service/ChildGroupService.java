package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.ChildGroup;
import ua.lviv.iot.repository.ChildGroupRepository;

@Service
public class ChildGroupService extends BaseService<ChildGroup, Integer> {

    @Autowired
    ChildGroupRepository childGroupRepository;

    @Override
    public JpaRepository<ChildGroup, Integer> getRepository() {
        return childGroupRepository;
    }
}
