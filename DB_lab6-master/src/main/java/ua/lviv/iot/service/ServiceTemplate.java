package ua.lviv.iot.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.SQLException;
import java.util.List;

public interface ServiceTemplate<T, ID> {

    void create(T entity) throws SQLException;

    List<T> findAll() throws SQLException;

    T findBy(ID id) throws SQLException;

    void update(T entity) throws SQLException;

    void deleteBy(ID id) throws SQLException;

    JpaRepository<T, ID> getRepository();

}
