package entities;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Embeddable
public class Im {
	@Column
	protected String name;
	
	@Column(name = "`it_id`")
	protected long itId;

	public long getItId() {
		return itId;
	}

	public void setItId(long itId) {
		this.itId = itId;
	}

	public Im() {}
	
	public Im(String n) { name = n; }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
