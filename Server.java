/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servercafe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Taufik
 */
public class Server extends Thread{
    @Override
    public void run() {
        ServerSocket srvr = null;
        try {
            srvr = new ServerSocket(4000);
            Socket skt = srvr.accept();
            BufferedReader in = new BufferedReader(new
            InputStreamReader(skt.getInputStream()));
            System.out.print("Received string: ");

            while (!in.ready()) {}
            System.out.println(in.readLine()); // Read one line and output it

            System.out.print("\n");
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("whoops");
        }
        
    }
}
