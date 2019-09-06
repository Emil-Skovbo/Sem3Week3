package facades;

import entities.Movie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class MovieFacade {

    private static MovieFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private MovieFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static MovieFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //TODO Remove/Change this before use
    public long getMovieCount() {
        EntityManager em = emf.createEntityManager();
        try {
            long MovieCount = (long) em.createQuery("SELECT COUNT(r) FROM Movie r").getSingleResult();
            return MovieCount;
        } finally {
            em.close();
        }

    }

    public List<Movie> getAllMovies() {
        EntityManager em = emf.createEntityManager();
        try {
            List AllMovies = (List) em.createQuery("SELECT r FROM Movie r").getResultList();
            return AllMovies;
        } finally {
            em.close();
        }

    }

    public List<Movie> getMovieByName(String Title) {
        EntityManager em = getEntityManager();
        try {
            List<Movie> emp = em.createQuery("select b from Movie b WHERE b.name = '" + Title + "'").getResultList();
            return emp;
        } finally {
            em.close();
        }
    }

    public Movie getMovieById(int i) {
        EntityManager em = getEntityManager();
        try {
            List<Movie> id = em.createQuery("select b from Movie b").getResultList();
            if (id.size() >= i) {
                return id.get(i - 1);
            } else {
                return null;
            }
        } finally {
            em.close();
        }
    }
}
