/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gsm;
import java.io.IOException;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ews
 */
public class tread_gsm {
    @SuppressWarnings("SleepWhileInLoop")
    ProcessBuilder cmd  = new ProcessBuilder();
    private DBAdmin db;
    private Connection conn;
    private ResultSet rs;
    private String query;
    
    
    public void run() throws IOException, InterruptedException {
        
        String Pimsi = "n",Pfreq = "n",Progress,Pband = null;
        
        while(true){
            try {
                db = new DBAdmin();
                //db.makeConnection();
                query = "select * from player";
                rs = db.getRS(query);
                while (rs.next()) {
                Pimsi    = rs.getString("imsi");
                Pfreq    = rs.getString("freq");
                Progress = rs.getString("progress");
                Pband    = rs.getString("band");
                }
                rs.close();
                
                switch (Pfreq) {
                    case "y":
                        System.err.println("Proses scan frequency \n");
                        cmd.command("sh", "-c", "kal -s "+Pband+";");
                        cmd.start();
                        query = "UPDATE player SET freq='n'";
                        db.executeRS(query);
                        break;
                    case "c":
                        System.err.println("Proses clear frequency \n");
                        cmd.command("sh", "-c", "killall -TERM kal;killall -TERM sh;");
                        cmd.start();
                        query = "UPDATE player SET freq='n'";
                        db.executeRS(query);
                        break;
                }
                
                Thread.sleep(100);
                switch (Pimsi) {
                    case "y":
                        System.err.println("Proses scan IMSI \n");
                        cmd.command("sh", "-c", "/media/Data/Documents/DATA_KANTOR/GNU_RADIO/GSM_SNIPPER/gnuradio/gsm_rtl0.py;");
                        cmd.start();
                        query = "UPDATE player SET imsi='n'";
                        db.executeRS(query);
                        break;
                    case "c":
                        System.err.println("Proses clear IMSI \n");
                        cmd.command("sh", "-c", "killall -TERM python2;killall -TERM sh;");
                        cmd.start();
                        query = "UPDATE player SET imsi='n'";
                        db.executeRS(query);
                        break;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(tread_gsm.class.getName()).log(Level.SEVERE, null, ex);
            }
            // proses loop data
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                //Logger.getLogger(ews_generate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
