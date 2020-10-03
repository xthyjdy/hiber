package dao;

import entities.It;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.*;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

@Stateless
public class ItemDAOImpl extends GenericDAOImpl<It, Long> implements ItemDAO{
	public ItemDAOImpl() {
		super(It.class);
	}
	
	@Override
	public List<It> findAll(boolean withBids) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<It> criteria = cb.createQuery(It.class);
		Root<It> i = criteria.from(It.class);		
		criteria.select(i).distinct(true).orderBy(cb.asc(i.get("id")));
		if (withBids)
			i.fetch("bids", JoinType.LEFT);
		
		return em.createQuery(criteria).getResultList();
	}

    @Override
    public List<It> findByName(String name, boolean substring) {
        return em.createNamedQuery(
            substring ? "getItemsByNameSubstring" : "getItemsByName"
        ).setParameter(
            "itemName",
            substring ? ("%" + name + "%") : name
        ).getResultList();
    }

//    @Override
//    public List<ItemBidSummary> findItemBidSummaries() {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<ItemBidSummary> criteria =
//            cb.createQuery(ItemBidSummary.class);
//        Root<Item> i = criteria.from(Item.class);
//        Join<Item, Bid> b = i.join("bids", JoinType.LEFT);
//        criteria.select(
//            cb.construct(
//                ItemBidSummary.class,
//                i.get("id"), i.get("name"), i.get("auctionEnd"),
//                cb.max(b.<BigDecimal>get("amount"))
//            )
//        );
//        criteria.orderBy(cb.asc(i.get("auctionEnd")));
//        criteria.groupBy(i.get("id"), i.get("name"), i.get("auctionEnd"));
//        return em.createQuery(criteria).getResultList();
//    }
}
