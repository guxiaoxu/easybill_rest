package xgu.myproject.easybill.rest.bill.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "eb_card")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "user_id", updatable = false)
    private long userId;

    @Column(name = "card_id")
    private long cardId;

    @Column(name = "type")
    private String type;

    @Column(name = "category")
    private String category;

    @Column(name = "amount")
    private double amount;

    @Column(name = "bill_time")
    private Timestamp billTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getBillTime() {
        return billTime;
    }

    public void setBillTime(Timestamp billTime) {
        this.billTime = billTime;
    }
}
