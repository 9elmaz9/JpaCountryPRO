package be.intecbrussel.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionConfig {

    private static final String PERSISTENCE_UNIT_NAME = "CountryPersistenceUnit";
    private static EntityManagerFactory entityManagerFactory;


    public static void configure() {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        } catch (Throwable ex) {
            System.err.println("Initial EntityManagerFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void close() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}





//     static {
//         try {
//             entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//         } catch (Throwable ex) {
//             System.err.println("Initial EntityManagerFactory creation failed: " + ex);
//             throw new ExceptionInInitializerError(ex);
//         }
//     }

//     public static EntityManager getEntityManager() {
//         return entityManagerFactory.createEntityManager();
//     }

//     public static void close() {
//         entityManagerFactory.close();
//     }
// }
