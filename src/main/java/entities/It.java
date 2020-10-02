package entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Loader;
import org.hibernate.annotations.Where;

@NamedNativeQueries({
	@NamedNativeQuery(
	    name = "findItemByIdXXX",
	    query = "select id, name, us_id, version, cat_id, des from it where ID = ? and 1",
		resultClass = It.class
	)
})
@Loader(namedQuery = "findItemByIdXXX")
@Entity
public class It {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@Column
	protected String name;
	
	
	@OneToMany(
			mappedBy = "item", 
//			fetch = FetchType.LAZY,
			cascade = {CascadeType.DETACH, CascadeType.MERGE})
	protected Set<Bid> bids = new HashSet<Bid>();
	
	
	public Set<Bid> getBids() {
		return bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}

	@JoinColumn(name = "us_id", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	protected Us user;	
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(
			name = "`im`",
			joinColumns = @JoinColumn(name = "`it_id`"))
	@Column(name = "`name`")
	@Where(clause = "a = true")
	protected Set<String> images = new HashSet<String>();

	@Column(name = "des")
	protected String desc;
	
	@Version
	protected int version;

	public Set<String> getImages() {
		return images;
	}

	public void setImages(Set<String> images) {
		this.images = images;
	}
	
	public int getVersion() {
		return version;
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public Us getUser() {
		return user;
	}

	public void setUser(Us user) {
		this.user = user;
	}

	public It() {}
	
	public It(String name, Us user, String desc) {
		this.name = name;
		this.desc = desc;
		this.user = user; 
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
	
}
