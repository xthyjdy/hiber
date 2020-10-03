package dao;

import java.util.List;

import entities.It;

public interface ItemDAO extends GenericDAO<It, Long>{

//	List<It> findAll(boolean withBids);
	List<It> findAll(boolean withBids);

	List<It> findByName(String name, boolean substring);

}
