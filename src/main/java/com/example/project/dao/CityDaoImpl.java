package com.example.project.dao;

import com.example.project.model.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityDaoImpl implements CityDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public CityDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveCity(City city) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<City> listCityByCountryId(int countryId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from City where country.id = :countryId", City.class)
                    .setParameter("countryId", countryId)
                    .list();
        }
    }

    @Override
    public City getCityById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(City.class, id);
        }
    }

    @Override
    public void updateCity(City city) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCity(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            City city = session.get(City.class, id);
            if (city != null) {
                session.delete(city);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
