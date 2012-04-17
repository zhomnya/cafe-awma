/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kasirmain;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmad 'ANS' Syuhada
 */
public class Server implements Runnable {
    //ini buat listening
    private int port;
    private String host;
    ServerSocket serv;
    Socket sock;
    PrintWriter send;
    BufferedReader get;

    public Server(String hst){
        port=4444;
        host=hst;
    }

    public void setPort(int prt){
        port = prt;
    }

    public void setHost(String hst){
        host = hst;
    }

    public int getPort(){
        return port;
    }

    public String getHost(){
        return host;
    }

    public void init() throws IOException{
        serv = new ServerSocket(port);
        sock = serv.accept();
        System.out.print("Server has connected!\n");
        send = new PrintWriter(sock.getOutputStream(), true);
        get = new BufferedReader(new InputStreamReader(sock.getInputStream()));
    }

    public void run() {
        try {
            while (!get.ready()) {}
            System.out.println(get.readLine());
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void close(){
        try {
            get.close();
            send.close();
            sock.close();
            serv.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
