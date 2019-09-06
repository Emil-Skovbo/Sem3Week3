package facades;

import utils.EMF_Creator;
import entities.Movie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import utils.Settings;
import utils.EMF_Creator.DbSelector;
import utils.EMF_Creator.Strategy;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class MovieFacadeTest {

    private static EntityManagerFactory emf;
    private static MovieFacade facade;

    public MovieFacadeTest() {
    }

    //@BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/startcode_test",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
        facade = MovieFacade.getFacadeExample(emf);
    }

    /*   **** HINT **** 
        A better way to handle configuration values, compared to the UNUSED example above, is to store those values
        ONE COMMON place accessible from anywhere.
        The file config.properties and the corresponding helper class utils.Settings is added just to do that. 
        See below for how to use these files. This is our RECOMENDED strategy
     */
    @BeforeAll
    public static void setUpClassV2() {
        emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST, Strategy.DROP_AND_CREATE);
        facade = MovieFacade.getFacadeExample(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Movie.deleteAllRows").executeUpdate();
            em.persist(new Movie(1, "Some txt", "More text"));
            em.persist(new Movie(2, "aaa", "bbb"));

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    // TODO: Delete or change this method 
    @Test
    public void testMovieCountMethod() {
        assertEquals(2, facade.getMovieCount(), "Expects two rows in the database");
    }

    @Test
    public void testGetAllMovies() {

        List<Movie> movies = facade.getAllMovies();
        int amount = movies.size();
        // movies.forEach(m->{System.out.println(m);});
        Movie movie = facade.getMovieById(2);
        assertEquals(amount, 2);
        //  assertThat(movies, CoreMatchers.hasItems(movie));
//        assertThat(movies, everyItem(hasProperty("name")));
    }

    @Test
    public void testMovieHasActors() {
        Movie movie = facade.getMovieById(2);
        assertEquals(movie.getActors(), ("More text"));
    }

//    @Test
//    public void testGetMovieByName() {
//        Movie movie = facade.getMovieById(1);
//        assertEquals(movie, facade.getMovieByName("Some txt"));
//    }
    
//    @Test
//    public void testMovieNameNotNull() {
//        Movie movie = facade.getMovieById(1);
//        assertNotEquals(movie.getName(), null);
//    }
    
}
