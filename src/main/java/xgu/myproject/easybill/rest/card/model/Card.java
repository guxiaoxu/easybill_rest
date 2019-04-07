package xgu.myproject.easybill.rest.card.model;

import xgu.myproject.easybill.rest.util.StringUtil;

import javax.persistence.*;

@Entity
@Table(name = "eb_card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "type")
    private String type;

    @Column(name = "last_digits")
    private String lastDigits;

    @Column(name = "alias")
    private String alias;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLastDigits() {
        return lastDigits;
    }

    public void setLastDigits(String lastDigits) {
        this.lastDigits = lastDigits;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Transient
    public String getDisplayAlias() {
        if (StringUtil.isEmpty(this.alias)){
            return "Ends in " + this.lastDigits;
        }
        return this.alias;
    }
}
