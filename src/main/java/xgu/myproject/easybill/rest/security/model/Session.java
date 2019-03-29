package xgu.myproject.easybill.rest.security.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;

@Entity
@Table(name = "eb_session")
public class Session{

    @EmbeddedId
    private SessionId sessionId;

    @Column(name="expire", updatable = false)
    private Timestamp expire;

    public Session(long userId, String token) {
        this.sessionId = new SessionId(userId, token);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 24 * 10);
        this.expire = new Timestamp(calendar.getTime().getTime());
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
