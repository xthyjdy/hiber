package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

import org.hibernate.annotations.Loader;

@NamedNativeQuery(
		name = "get_ms_by_id",
		query = "{call get_ms_by_id(?)}",
		resultClass = Ms.class
)
@Loader(namedQuery = "get_ms_by_id")
@Entity
public class Ms {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	
	@Column
	protected String text;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getId() {
		return id;
	}
	

}
