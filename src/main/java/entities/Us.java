package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "us")
public class Us {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	
	@Column
	protected String name;
	
	@Version
	protected int version;
	
	public int getVersion() {
		return version;
	}

	@OneToMany(mappedBy = "user")
	protected List<It> items = new ArrayList<It>();
	
	@Column
	protected int z;
	
	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public List<It> getItems() {
		return items;
	}

	public void setItems(List<It> items) {
		this.items = items;
	}

	public Us() {}
	
	public Us(String n) { name = n; }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}
	
}
