package xgu.myproject.easybill.rest.security.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SessionId implements Serializable {

    @Column(name = "user_id")
    private long userId;

    @Column(name = "token")
    private String token;

    public SessionId(long userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public SessionId() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
