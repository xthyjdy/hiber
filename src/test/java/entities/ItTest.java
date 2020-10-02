package entities;

import java.util.List;
import java.util.Random;

import static help.MyLog.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hibernate.*;
import org.hibernate.query.*;
import org.junit.jupiter.api.*;

import utils.HibernateUtil;

public class ItTest {
	private static SessionFactory sessionFactory;
    private Session s;
    private long id = 1;
    private Random rand = new Random(0);
    private Us user;// = new Us(String.valueOf(rand.nextInt(100000)));
    private String name = "test_name", updatedName = "updated_test_name", desc = "test_desc";
    
    @Test
    public void testCreate() {
    	Us u = new Us("iui");
    	s.beginTransaction();
    	s.save(u);
    	s.getTransaction().commit();
		l(22);
    	
//    	It i = new It(name, this.user, desc);
//    	s.beginTransaction();
//    	s.save(this.user);
//    	s.save(i);
//    	s.getTransaction().commit();
    	
//    	List<It> its = s.createQuery("select i from It i").getResultList();
//    	l(its);
//    	assertTrue(its.size() == 1);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @BeforeAll
    public static void setUp() {
        try {
        	sessionFactory = HibernateUtil.getSessionFactory();
        	l("________SessionFactory created________");
		} catch (Exception e) {
			l(e.getMessage());
			e.printStackTrace();
		}
    }
     
    @AfterAll
    public static void tearDown() {
        if (sessionFactory != null) sessionFactory.close();
        l("SessionFactory destroyed");
    }

    @BeforeEach
    public void openSession() {
        s = sessionFactory.openSession();
        l("Session created");
    }
     
    @AfterEach
    public void closeSession() {
        if (s != null) s.close();
        l("Session closed\n");
    }
}
