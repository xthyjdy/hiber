package manager;

import static help.MyLog.l;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.JPAIndexHolder;
import org.hibernate.cfg.annotations.QueryBinder;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.hibernate.transform.ToListResultTransformer;
import org.hibernate.type.StandardBasicTypes;

import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

import classes.ItSummary;
import classes.QueryItemWork;
import entities.Bid;
import entities.It;
import entities.Ms;
import entities.Us;

public class M {
	public static void main(String[] args) {M m=new M();m.setup();m.t();m.exit();}
	protected SessionFactory sessionFactory;
	private long n = 3, id = 5;
	private String name = "test_name", updatedName = "updated_test_name", desc = "test_desc";
	
	public void t() {
		Session s = sessionFactory.openSession();
//		StoredProcedureQuery q = s.createStoredProcedureQuery("get_items", It.class);
//		List<It> i = q.getResultList();
//		for (It o : i) {
//			l(o.getName());
//		}		
//		StoredProcedureQuery q = s.createStoredProcedureQuery("get_item", It.class);
//		q.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
//		q.setParameter(1, id); It i = (It)q.getSingleResult();
		
//		StoredProcedureQuery query = s.createStoredProcedureQuery("FIND_ITEM_TOTAL", It.class);
//		query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
//		query.registerStoredProcedureParameter(2, Long.class, ParameterMode.OUT);
//		query.setParameter(1, id);
//		List<It> result = query.getResultList();
//		for (It item : result) {
//			l(item.getId());
//		}
//		
//		Long totalNumberOfItems = (Long) query.getOutputParameterValue(2);
//		
//		l(totalNumberOfItems);
		
		
//		StoredProcedureQuery query = s.createStoredProcedureQuery("update_item", It.class);
//		query.registerStoredProcedureParameter("NEW_NAME", String.class, ParameterMode.IN);
//		query.registerStoredProcedureParameter("ITEM_ID", Long.class, ParameterMode.IN);
//		query.setParameter("ITEM_ID", 5L);
//		query.setParameter("NEW_NAME", "new_string4");
//		query.execute();
//		int i = query.getUpdateCount();
//		l(i);
		
//		org.hibernate.procedure.ProcedureCall call =
//				s.createStoredProcedureCall("update_item");
//		call.registerParameter(1, String.class, ParameterMode.IN)
//		 .bindValue("new_string7");
//		call.registerParameter(2, Long.class, ParameterMode.IN)
//		 .bindValue(5L);
//		org.hibernate.result.UpdateCountOutput updateCountOutput =
//				(org.hibernate.result.UpdateCountOutput) call.getOutputs().getCurrent();
//		int i = updateCountOutput.getUpdateCount();
//		
//		l(i);
		
		
		
		Ms m = s.find(Ms.class, id);
		
		l(m.getText());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		s.beginTransaction();s.getTransaction().commit();
		s.close();
	}
	
	
	
	protected void setup() {
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    	        .configure() // configures settings from hibernate.cfg.xml
    	        .build();
    	try {
    	    sessionFactory = new MetadataSources(registry)
    	    		.addResource("queries/Ms.hbm.xml")
//    	    		.addResource("queries/procedures.hbm.xml")
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
