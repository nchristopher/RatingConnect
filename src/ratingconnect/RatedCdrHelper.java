/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ratingconnect;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
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
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTimeInMillis(eventMonth.getTime());
        System.out.println("Maximum : " + calendar.getActualMaximum(calendar.DAY_OF_MONTH));
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("FROM RatedCdr as rCdr WHERE rCdr.msn = '" + msn + "' AND rCdr.startTimestamp > " + getMinimum(calendar) +"AND rCdr.startTimestamp <" + getMaximum(calendar)).setResultTransformer(Transformers.aliasToBean(RatedCdr.class));    
        return (ArrayList<RatedCdr>)q.list(); 
    }

    private String getMinimum(Calendar calendar) {
        
        return calendar.getTime().getYear() + "-" + calendar.getTime().getMonth() + "-" + calendar.getActualMinimum(calendar.DAY_OF_MONTH);
    }

    private String getMaximum(Calendar calendar) {
        return calendar.YEAR + "-" + calendar.MONTH + "-" +calendar.getActualMaximum(calendar.DAY_OF_MONTH);
    }
}
