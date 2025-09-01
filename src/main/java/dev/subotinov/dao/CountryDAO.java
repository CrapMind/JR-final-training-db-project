package dev.subotinov.dao;

import dev.subotinov.domain.Country;
import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

@AllArgsConstructor
public class CountryDAO {
    private final SessionFactory sessionFactory;

    public List<Country> getAll() {
        Query<Country> query = sessionFactory.getCurrentSession().createQuery("select c from Country c join fetch c.languages", Country.class);
        return query.list();
    }
}
