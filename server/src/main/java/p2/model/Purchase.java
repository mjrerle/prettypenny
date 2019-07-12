package p2.model;

import java.sql.Date;
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
@Table(name = "Purchases")
public class Purchase {

  @Id
  @SequenceGenerator(sequenceName = "purchases_seq", name = "s_seq")
  @GeneratedValue(generator = "s_seq", strategy = GenerationType.SEQUENCE)
  private int id;

  @Column(name = "date_purchased")
  private Date datePurchased;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;


  public Purchase() {
  }

  public Purchase(int id) {
    this.id = id;
  }

  public Purchase(Date datePurchased, User user, Product product) {
    this.datePurchased = datePurchased;
    this.user = user;
    this.product = product;
  }

  public Purchase(int id, Date datePurchased, User user, Product product) {
    this.id = id;
    this.datePurchased = datePurchased;
    this.user = user;
    this.product = product;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getDatePurchased() {
    return this.datePurchased;
  }

  public void setDatePurchased(Date datePurchased) {
    this.datePurchased = datePurchased;
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

  public Purchase id(int id) {
    this.id = id;
    return this;
  }

  public Purchase datePurchased(Date datePurchased) {
    this.datePurchased = datePurchased;
    return this;
  }

  public Purchase user(User user) {
    this.user = user;
    return this;
  }

  public Purchase product(Product product) {
    this.product = product;
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) o;
        return id == purchase.id && Objects.equals(datePurchased, purchase.datePurchased) && Objects.equals(user, purchase.user) && Objects.equals(product, purchase.product);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, datePurchased, user, product);
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", datePurchased='" + getDatePurchased() + "'" +
      ", user='" + getUser() + "'" +
      ", product='" + getProduct() + "'" +
      "}";
  }

}
