package service;

import be.intecbrussel.connection.ConnectionConfig;
import be.intecbrussel.model.Country;
import be.intecbrussel.model.President;
import be.intecbrussel.repository.CountryRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

// Configure EntityManagerFactory
        ConnectionConfig.configure();

// Create EntityManagerFactory and EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CountryPersistenceUnit");
        EntityManager em = emf.createEntityManager();

// Создание репозитория и сервиса
        CountryRepository countryRepository = new CountryRepository(em);
        CountryService countryService = new CountryService(em);

// Создание объектов для сохранения в базу данных

        President president = new President("John Doe", 50);
        President president1 = new President("Jane Smith", 55);
        President president2 = new President("Michael Johnson", 48);
        President president3 = new President("Emily Davis", 52);
        President president4 = new President("David Wilson", 60);

        Country country1 = new Country("Wonderland", 1000000, president);
        Country country2 = new Country("Dreamland", 2000000, president1);
        Country country3 = new Country("Mystique Isle", 3000000, president2);
        Country country4 = new Country("Elysium", 1500000, president3);
        Country country5 = new Country("Fantasia", 2500000, president4);

// Сохранение объектов в базу данных
        countryService.saveCountry(country1);
        countryService.saveCountry(country2);
        countryService.saveCountry(country3);
        countryService.saveCountry(country4);
        countryService.saveCountry(country5);

// Получение списка всех стран и вывод информации о них
        List<Country> countries = countryService.getAllCountries();
        for (Country country : countries) {
            System.out.println("Retrieved Country: " + country);
        }

// Получение страны по имени и вывод информации о ней
        Country retrievedCountry = countryService.getCountryByName("Wonderland");
        if (retrievedCountry != null) {
            System.out.println("Retrieved Country: " + retrievedCountry);
        }

// Удаление страны из базы данных
        countryService.deleteCountry("Dreamland");

// Закрытие EntityManager и EntityManagerFactory
        em.close();
        emf.close();

// Close the connection to the database
        ConnectionConfig.close();
    }
}

