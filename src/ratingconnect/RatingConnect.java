/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ratingconnect;

/**
 *
 * @author Nimil
 */
public class RatingConnect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RatedCdrHelper rch = new RatedCdrHelper();
        rch.getEvents("LN29752443", null);
    }
}
