package xgu.myproject.easybill.rest.security.modal;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "eb_session")
public class Session{

    @EmbeddedId
    private SessionId sessionId;

    @Column(name="expire", updatable = false)
    private Timestamp expire;

    public Session(long userId, String token) {
        this.sessionId = new SessionId(userId, token);
        this.expire = new Timestamp(System.currentTimeMillis());
    }

    public Session() {
    }

    public Timestamp getExpire() {
        return expire;
    }

    public void setExpire(Timestamp expire) {
        this.expire = expire;
    }

    public SessionId getSessionId() {
        return sessionId;
    }

    public void setSessionId(SessionId sessionId) {
        this.sessionId = sessionId;
    }
}
