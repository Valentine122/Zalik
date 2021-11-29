package ua.lviv.iot.controller;

import org.springframework.http.ResponseEntity;
import ua.lviv.iot.service.ServiceTemplate;

import java.sql.SQLException;
import java.util.List;

public interface ControllerTemplate<T, ID> {

    T create(T entity) throws SQLException;

    List<T> findAll() throws SQLException;

    ResponseEntity<T> findBy(ID id) throws SQLException;

    ResponseEntity<T> update(ID id, T entity) throws SQLException;

    ResponseEntity<T> deleteBy(ID id) throws SQLException;

    ServiceTemplate<T, ID> getService();

}
