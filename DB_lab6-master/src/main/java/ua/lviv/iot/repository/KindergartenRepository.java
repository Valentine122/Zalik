package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Kindergarten;

@Repository
public interface KindergartenRepository extends JpaRepository<Kindergarten, Integer> {
}
