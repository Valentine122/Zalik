package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Vaccination;
import ua.lviv.iot.repository.VaccinationRepository;

@Service
public class VaccinationService extends BaseService<Vaccination, Integer> {

    @Autowired
    VaccinationRepository vaccinationRepository;

    @Override
    public JpaRepository<Vaccination, Integer> getRepository() {
        return vaccinationRepository;
    }
}
