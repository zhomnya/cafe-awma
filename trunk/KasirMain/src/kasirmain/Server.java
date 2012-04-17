/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kasirmain;

/*
 *
 * @author Ahmad 'ANS' Syuhada*/

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observer;
import java.util.Vector;
import java.util.Observable;
import java.io.IOException;
import java.io.*;

public class Server implements Observer {
//public class Server{
    private Socket socket;
    private Vector clients;
    private ServerSocket ssocket;  //Server Socket
    private StartServerThread sst; //inner class
    private ClientThread clientThread;
    ///** Port number of Server.
    private int port;
    private boolean listening; //status for listening

    public Server() {
        this.clients = new Vector();
        this.port = 5555; //default port
        this.listening = false;
    }

    public void startServer() {
        if (!listening) {
            this.sst = new StartServerThread();
            this.sst.start();
            this.listening = true;
            System.out.println("Started SERVER");
        }
    }

    public void stopServer() {
        if (this.listening) {
            this.sst.stopServerThread();
		//close all connected clients//
            java.util.Enumeration e = this.clients.elements();
            while(e.hasMoreElements())
            {
		ClientThread ct = (ClientThread)e.nextElement();
                ct.stopClient();
            }
            this.listening = false;
        }
    }

    //observer interface//
    public void update(Observable observable, Object object) {
        //notified by observables, do cleanup here//
        this.clients.removeElement(observable);
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

  private class StartServerThread extends Thread {
        private boolean listen;

        public StartServerThread() {
            this.listen = false;
        }

        public void run() {
            this.listen = true;
            try {
                Server.this.ssocket = new ServerSocket(Server.this.port);
                while (this.listen) {
			//wait for client to connect//
                    Server.this.socket = Server.this.ssocket.accept();
                    System.out.println("Client connected");
                    try {
                        Server.this.clientThread = new ClientThread(Server.this.socket);
                        Thread t = new Thread(Server.this.clientThread);
                        Server.this.clientThread.addObserver(Server.this);
                        Server.this.clients.addElement(Server.this.clientThread);
                        t.start();
                        System.out.println("Client ran");
                    } catch (IOException ioe) {
                        //some error occured in ClientThread //
                    }
                }
            } catch (IOException ioe) {
                //I/O error in ServerSocket//
                this.stopServerThread();
            }
        }

        public void stopServerThread() {
            try {
                Server.this.ssocket.close();
            }
            catch (IOException ioe) {
                //unable to close ServerSocket
            }
            this.listen = false;
        }
    }
    //-------------------------------------------------------------------------------------
  /*
  public Server(){
        System.out.println("### TRACKER START ###");
    }

    public void Run(){
        ServerSocket serversocket = null;
        int port = 4444;
        try{
            System.out.print("Trying to bind to localhost on port 4444...");
            serversocket = new ServerSocket(port);
        }
        catch(Exception e){
            System.out.append("Connection error!");
        }
        System.out.println("OK!");
        while (true) {
            try{
                Thread.sleep(3000);
            }
            catch(InterruptedException e){
            }
            System.out.println("Tracker ready, Waiting for requests...");
            try {
                //bikin socket
                Socket connectionsocket = serversocket.accept();
                //jalankan THREAAAD DI SINIIIIIIII
                Thread t = new Thread(new ClientThread(connectionsocket));
                t.start();
            }
            catch (Exception e) {
                System.out.println("Server Error!");
            }
            //loop terus, nunggu request lain
        }
    }
   */
}

