package service;

import be.intecbrussel.model.Country;
import be.intecbrussel.repository.CountryRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(EntityManager entityManager) {
        this.countryRepository = new CountryRepository(entityManager);
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountryByName(String name) {
        return countryRepository.findById(name);
    }

    public void saveCountry(Country country) {
        countryRepository.save(country);
    }

    public void deleteCountry(String name) {
        Country country = countryRepository.findById(name);
        if (country != null) {
            countryRepository.delete(country);
        }
    }
}
