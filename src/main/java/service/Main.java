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

// Creating a repository and service
        CountryRepository countryRepository = new CountryRepository(em);
        CountryService countryService = new CountryService(em);

// Creating objects to save to the database
//for myself
     // President president = em.find(President.class,1L);
     // System.out.println(  president.toString());
     // president.setName("BOB LOL");
     // president.setAge(50);
     // System.out.println("President: " + president.getName() + ", Age: " + president.getAge());


       President president = new President("Lili Royz", 50);
       President president1 = new President("Richi Smith", 55);
       President president2 = new President("Michael Green", 48);
       President president3 = new President("Petra Vong", 52);
       President president4 = new President("Billy Robinsoon ", 60);

        Country country1 = new Country("Wonderland", 1000000, president);
        Country country2 = new Country("Dreamland", 2000000, president1);
        Country country3 = new Country("Mystique Isle", 3000000, president2);
        Country country4 = new Country("Elysium", 1500000, president3);
        Country country5 = new Country("Fantasia", 2500000, president4);

// Saving objects to the database
        countryService.saveCountry(country1);
        countryService.saveCountry(country2);
        countryService.saveCountry(country3);
        countryService.saveCountry(country4);
        countryService.saveCountry(country5);

// Getting a list of all countries and displaying information about them
        List<Country> countries = countryService.getAllCountries();
        for (Country country : countries) {
            System.out.println("Retrieved Country: " + country);
        }

// Getting a country by name and displaying information about it
        Country retrievedCountry = countryService.getCountryByName("Wonderland");
        if (retrievedCountry != null) {
            System.out.println("Retrieved Country: " + retrievedCountry);
        }

// Removing a country from the database
        countryService.deleteCountry("Dreamland");

// Closing EntityManager and EntityManagerFactory
        em.close();
        emf.close();

// Close the connection to the database
        ConnectionConfig.close();
    }
}

