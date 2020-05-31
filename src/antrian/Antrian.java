/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antrian;

import antrian.connection.LocalConnection;

/**
 *
 * @author fuadz
 */
public class Antrian {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Homed main = new Homed();
        LocalConnection conect = new LocalConnection();
        conect.initial();
        
        
        main.getConnection(conect.getConnection());
        main.setVisible(true);
        
        View second = new View();
        second.getConnection(conect.getConnection());
        second.setVisible(true);
       
        
        customerservice service = new customerservice();
        service.getConnection(conect.getConnection());
        service.setVisible(true);
        service.setView(second);
        
        teller mTeller = new teller();
        mTeller.getConnection(conect.getConnection());
        mTeller.setVisible(true);
        mTeller.setView(second);
        
        main.setCustomerPage(service);
        main.setTellerPage(mTeller);
        
    }
    
}
