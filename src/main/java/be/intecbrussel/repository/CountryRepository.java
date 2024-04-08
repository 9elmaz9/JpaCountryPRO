package be.intecbrussel.repository;

import be.intecbrussel.model.Country;

import javax.persistence.EntityManager;

public class CountryRepository {

    private final EntityManager entityManager;

    public CountryRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public  void add(Country country) {
        entityManager.getTransaction().begin();
        entityManager.persist(country);
        entityManager.getTransaction().commit();

    }
    public Country find(Long id) {
        return entityManager.find(Country.class, id);
    }

    public void update(Country country) {
        entityManager.getTransaction().begin();
        entityManager.merge(country);
        entityManager.getTransaction().commit();
    }

    public void delete(Country country) {
        entityManager.getTransaction().begin();
        entityManager.remove(country);
        entityManager.getTransaction().commit();
    }




}
