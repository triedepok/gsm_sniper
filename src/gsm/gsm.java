/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gsm;

import java.io.IOException;

/**
 *
 * @author ews
 */
public class gsm {

    ProcessBuilder cmd  = new ProcessBuilder();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        tread_gsm gsm = new tread_gsm();
        try {
            gsm.run();
        } catch (IOException | InterruptedException ex) {
            //Logger.getLogger(gsm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
