import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Map;

public class Tester {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        try {

        } finally {
            em.close(); // closing entitymanager
        }
        System.out.println("qwepqe[pqo");

    }
}
