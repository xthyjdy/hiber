package entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Parent;

@Entity
public class Bid {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	
	@JoinColumn(name = "it_id", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	protected It item;
	
	
	@Column(nullable = true)
	protected BigDecimal amount;
	
	public Bid() {}
	
	public Bid(BigDecimal amount) {
		this.amount = amount;
	}
	
	public Bid(BigDecimal amount, It item) {
		this.amount = amount;
		this.item = item;
	}

	public long getId() {
		return id;
	}

	public It getItem() {
		return item;
	}

	public void setItem(It item) {
		this.item = item;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	@Override
	public boolean equals(Object other) {
		if (this == other) return true;
		if (other == null) return false;
		if (!(other instanceof Bid)) return false;
		Bid that = (Bid) other;
		if (!this.getAmount().equals(that.getAmount()))
			return false;
		if (!this.getItem().getId().equals(that.getItem().getId()))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		int result = getAmount().hashCode();
		result = 31 * result + getItem().getId().hashCode();
		return result;
	}
	
}

