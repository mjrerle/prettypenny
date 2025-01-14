package p2.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Interests")
public class Interest {

	@Id
	@SequenceGenerator(sequenceName = "interests_seq", name = "i_seq")
	@GeneratedValue(generator = "i_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "interest_id", unique = true, nullable = false)
	private int interestId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	private int quantity;

	public Interest() {
		super();
	}

	public Interest(int id) {
		super();
		this.interestId = id;
	}

	public Interest(User user, Product product, int quantity) {
		this.user = user;
		this.product = product;
		this.quantity = quantity;
	}

	public Interest(int id, User user, Product product, int quantity) {
		this.interestId = id;
		this.user = user;
		this.product = product;
		this.quantity = quantity;
	}

	public int getInterestId() {
		return this.interestId;
	}

	public void setInterestId(int id) {
		this.interestId = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Interest)) {
			return false;
		}
		Interest interest = (Interest) o;
		return interestId == interest.interestId && Objects.equals(user, interest.user)
				&& Objects.equals(product, interest.product) && quantity == interest.quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(interestId, user, product, quantity);
	}

	@Override
	public String toString() {
		return "{" + " id='" + getInterestId() + "'" + ", user='" + getUser() + "'" + ", product='" + getProduct() + "'"
				+ ", quantity='" + getQuantity() + "'" + "}";
	}

}
