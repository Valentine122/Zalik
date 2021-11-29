package ua.lviv.iot.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.service.ServiceTemplate;

import java.sql.SQLException;
import java.util.List;

public abstract class BaseController<T, ID> implements ControllerTemplate<T, ID> {

    @Override
    public abstract ServiceTemplate<T, ID> getService();

    @Override
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public T create(final @RequestBody T entity) throws SQLException {
        getService().create(entity);
        return entity;
    }

    @Override
    @GetMapping
    public List<T> findAll() throws SQLException {
        return getService().findAll();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<T> findBy(final @PathVariable("id") ID id) throws SQLException {
        if (getService().findBy(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(getService().findBy(id));
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<T> update(final @PathVariable("id") ID id, final @RequestBody T entity) throws SQLException {
        if (getService().findBy(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            getService().update(entity);
            return ResponseEntity.ok(entity);
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<T> deleteBy(final @PathVariable("id") ID id) throws SQLException {
        if (getService().findBy(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            getService().deleteBy(id);
            return ResponseEntity.ok().build();
        }
    }
}
