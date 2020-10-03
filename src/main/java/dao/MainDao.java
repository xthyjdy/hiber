package dao;

import java.util.ArrayList;
import static help.MyLog.l;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class MainDao<Bean> {
	protected final Class<Bean> type;
	protected SessionFactory sessionFactory;
	
	public MainDao(Class<Bean> classType) {
		type = classType;
		setup();
	}
	
	public Bean getById(long id) {
		Session s = sessionFactory.openSession();
		
		Bean b = (Bean)s.get(type, id);
		
		if (s.isOpen()) s.close();
		return b;
	}
	
	public List<Bean> getAll() {
		Session s = sessionFactory.openSession();
		String hql = String.format("from %s", type.getCanonicalName());
		Query<Bean> q = s.createQuery(hql);
		ArrayList<Bean> list = (ArrayList<Bean>)q.list();

		if (s.isOpen()) s.close();
		return list;
	}
	
	public void delete() {
		SessionFactory s = (SessionFactory) sessionFactory.openSession();
	}
	
	protected void setup() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    	        .configure() // configures settings from hibernate.cfg.xml
    	        .build();
    	try {
    	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    	} catch (Exception ex) {
    	    StandardServiceRegistryBuilder.destroy(registry);
    	}
	}
}
