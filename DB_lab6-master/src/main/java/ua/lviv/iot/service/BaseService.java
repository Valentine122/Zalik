package ua.lviv.iot.service;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseService<T, ID> implements ServiceTemplate<T, ID> {

    @Override
    public abstract JpaRepository<T, ID> getRepository();

    @Override
    @Transactional
    public void create(T entity) throws SQLException {
        getRepository().save(entity);
    }

    @Override
    @Transactional
    public List<T> findAll() throws SQLException {
        return getRepository().findAll();
    }

    @Override
    @Transactional
    public T findBy(ID id) throws SQLException {
        return (T) getRepository().findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void update(T entity) throws SQLException {
        getRepository().save(entity);
    }

    @Override
    @Transactional
    public void deleteBy(ID id) throws SQLException {
        getRepository().deleteById(id);
    }
}
