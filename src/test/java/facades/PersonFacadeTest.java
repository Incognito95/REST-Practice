package facades;

import dtomappers.PersonDTO;
import dtomappers.PersonsDTO;
import utils.EMF_Creator;
import entities.Person;

import javax.persistence.EntityManagerFactory;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class PersonFacadeTest {

    private static EntityManagerFactory emf;
    private static PersonFacade facade;
    private static Person p1, p2, p3;

    public PersonFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = PersonFacade.getFacadeExample(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class


    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }


    @Test
    public void testGetFacadeExample() {
        System.out.println("getFacadeExample");
        EntityManagerFactory _emf = null;
        PersonFacade expResult = null;
        PersonFacade result = PersonFacade.getFacadeExample(_emf);
        assertNotEquals(expResult, result);
    }



    @Test
    public void testGetAllPersons() {
        System.out.println("getAllPersons");
        EntityManagerFactory _emf = null;
        PersonFacade instance = PersonFacade.getFacadeExample(_emf);
        int expResult = 3;
        PersonsDTO result = instance.getAllPersons();
        assertEquals(expResult, result.getAll().size());
        PersonDTO p1DTO = new PersonDTO(p1);
        PersonDTO p2DTO = new PersonDTO(p2);
        PersonDTO p3DTO = new PersonDTO(p3);
        assertThat(result.getAll(), containsInAnyOrder(p1DTO, p2DTO, p3DTO));
    }



}
