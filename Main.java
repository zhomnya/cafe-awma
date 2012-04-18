/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servercafe;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Taufik
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Thread tr = new Server();
            tr.start();
//            System.out.println("ip :" + InetAddress.getLocalHost().getHostAddress());
    }

}
