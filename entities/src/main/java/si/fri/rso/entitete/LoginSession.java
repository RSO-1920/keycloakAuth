package si.fri.rso.entitete;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "login_session")
@Table(name="id_auth_token_pairs", schema="public")
@NamedQueries(value =
        {
                @NamedQuery(name = "LoginSession.getID", query = "SELECT o FROM login_session o WHERE o.authToken = ?1"),
        })
public class LoginSession {

    @Id
    @Column(name="id")
    private String id;

    @Column(name="auth_token", length = 2024)
    private String authToken;

    public LoginSession(){

    }

    public LoginSession(String id, String authToken){
        this.id = id;
        this.authToken = authToken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

}
