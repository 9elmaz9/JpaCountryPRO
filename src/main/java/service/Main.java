package service;

import be.intecbrussel.model.Country;
import be.intecbrussel.repository.CountryRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


                EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("database-configuration");
                EntityManager entityManager = entityManagerFactory.createEntityManager();
                try {
                    Country country = new Country();
                    country.setName("Alan");
                    country.setPopulation("Red");
                    country.setPresident("Piter pen ");
                    CountryRepository studentRepository = new CountryRepository(entityManager);
// add
                    studentRepository.add(country);
                    System.out.println("Added student " + country.toString());
//search
                    country = studentRepository.find(country.g());
                    System.out.println("Found student " + country.toString());
//update
                    student.setLastName("Demir");
                    studentRepository.update(student);
                    System.out.println("Updated student " + student.toString());
//delete
//studentRepository.delete(student);
//System.out.println("Deleted student " + student.toString());
                } finally {
                    entityManager.close();
                    entityManagerFactory.close();
                }
            }
        }


    }
}
