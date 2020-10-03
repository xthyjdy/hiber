package manager;

import static help.MyLog.l;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.Tuple;
import javax.persistence.TupleElement;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Filter;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.internal.IteratorImpl;

import classes.ItSummury;
import entities.Bid;
import entities.It;
import entities.Us;

public class M {
	public static void main(String[] args) {M m=new M();m.setup();m.t();m.exit();}
	protected SessionFactory sessionFactory;
	private long n = 8, id = 3;
	
	public void t() {
		Session s = sessionFactory.openSession();		
		EntityManager em = s.getEntityManagerFactory().createEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<It> criteria = cb.createQuery(It.class);
		Root<It> i = criteria.from(It.class);		
		criteria.select(i).distinct(true).orderBy(cb.asc(i.get("id")));
		
		i.fetch("bids", JoinType.LEFT);
		
		TypedQuery<It> q = em.createQuery(criteria);
		
		List<It> it = q.getResultList();
		
		for (It it2 : it) {
			l(it2.getBids());
		}
		
//		s.beginTransaction(); s.getTransaction().commit();
		s.close();
	}
	
	
	
	protected void setup() {
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    	        .configure() // configures settings from hibernate.cfg.xml
    	        .build();
    	try {
    	    sessionFactory = new MetadataSources(registry)
    	    		.addResource("queries/q.hbm.xml")
    	    		.addResource("queries/p.hbm.xml")
    	    		.buildMetadata().buildSessionFactory();
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	    StandardServiceRegistryBuilder.destroy(registry);
    	}
    }
	
	protected void exit() {
        sessionFactory.close();
    }
}
