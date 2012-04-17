/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kasirmain;

/**
 *
 * @author Ahmad 'ANS' Syuhada
 */
//ClientThread.java
//© Usman Saleem, 2002 and Beyond
//usman_saleem@yahoo.com
import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Observable;

public class ClientThread extends Observable implements Runnable {
    /** For reading input from socket */
    private BufferedReader br;
    /** For writing output to socket. */
    private PrintWriter pw;

    /** Socket object representing client connection */

    private Socket socket;
    private boolean running;

    public ClientThread(Socket socket) throws IOException {
        this.socket = socket;
        running = false;
        //get I/O from socket
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        pw = new PrintWriter(socket.getOutputStream(), true);
        running = true; //set status
    }

    /**
     *Stops clients connection
     */

    public void stopClient()
    {
        try {
		this.socket.close();
        }catch(IOException ioe){ };
    }

    public void run() {
        String msg = ""; //will hold message sent from client
        System.out.println("Run Client");
	//sent out initial welcome message etc. if required...
            //pw.println("Welcome to Java based Server");
        try {
                msg = br.readLine();
                while ((msg = br.readLine()) != null && running) {
                    //provide your server's logic here//

                    //right now it is acting as an ECHO server//
                    
                    //pw.println(msg); //echo msg back to client//
                    System.out.println(msg);
                    msg = br.readLine();
                }
                running = false;
                System.out.println("Selesai");
            }
            catch (IOException ioe) {
                running = false;
            }
        //it's time to close the socket
        try {
            this.socket.close();
            System.out.println("Closing connection");
            System.out.println("running="+running);
        } catch (IOException ioe) { }

        //notify the observers for cleanup etc.
        this.setChanged();              //inherit from Observable
        this.notifyObservers(this);     //inherit from Observable
    }
}
