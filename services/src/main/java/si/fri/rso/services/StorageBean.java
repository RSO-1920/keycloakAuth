package si.fri.rso.services;

import si.fri.rso.entitete.LoginSession;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class StorageBean {

    @PersistenceContext(unitName = "authService-JPA")
    private EntityManager em;

    @Transactional
    public void SaveLogin(LoginSession l){
        LoginSession lOld = em.find(LoginSession.class, l.getId());
        if(lOld != null){
            em.merge(l);
        }
        else{
            em.persist(l);
        }
    }

    @Transactional
    public String GetIdFromAuthToken(String authToken){
        System.out.println("DB: getting id from auth token");
        List<LoginSession> list = em.createNamedQuery("LoginSession.getID").setParameter(1, authToken).getResultList();
        System.out.println("List size: " + list.size());
        if(list.size() == 1)
            return ((LoginSession) list.get(0)).getId();
        return "";
    }

}
