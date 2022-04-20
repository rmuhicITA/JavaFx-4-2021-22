package com.example.sceneproject.dao;

import com.example.sceneproject.model.Show;

import java.sql.SQLException;
import java.util.List;

/**
 * CRUD operations
 *
 * @param <E>
 */
public interface Dao<E> {

    public Show create(E entity) throws SQLException;

    public E retrieve(int id) throws SQLException;

    public List<E> retrieveAll() throws SQLException;

    public void update(E entity) throws SQLException;

    public void delete(E entity) throws SQLException;
}
