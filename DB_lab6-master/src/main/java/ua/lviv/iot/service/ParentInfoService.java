package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.ParentInfo;
import ua.lviv.iot.repository.ParentInfoRepository;

@Service
public class ParentInfoService extends BaseService<ParentInfo, Integer> {

    @Autowired
    ParentInfoRepository parentInfoRepository;

    @Override
    public JpaRepository<ParentInfo, Integer> getRepository() {
        return parentInfoRepository;
    }
}
