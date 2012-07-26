/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ratingconnect;

import java.sql.Date;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

/**
 *
 * @author Nimil
 */
public class RatedCdrHelper {
    
    Session session = null;

    public RatedCdrHelper() {
        this.session = NewHibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    
    
    public ArrayList<RatedCdr> getEvents(String msn, Date eventMonth){
       
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("SELECT rCdr.id, rCdr.startTimestamp, rCdr.user, rCdr.destination, rCdr.caller, "
                + "rCdr.duration FROM RatedCdr as rCdr WHERE rCdr.msn = '" + msn + "'").setResultTransformer(Transformers.aliasToBean(RatedCdr.class));    
        return (ArrayList<RatedCdr>)q.list(); 
    }
}
