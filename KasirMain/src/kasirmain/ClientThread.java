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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientThread implements Runnable {
//public class ClientThread extends Observable implements Runnable {
/*  private BufferedReader br;
    private PrintWriter pw;
    private Socket skt;
    private boolean running;

    public ClientThread(Socket socket) throws IOException {
        this.skt = socket;
        running = false;
        //get I/O from socket
        br = new BufferedReader(new InputStreamReader(skt.getInputStream()));
        pw = new PrintWriter(skt.getOutputStream(), true);
        running = true; //set status
        System.out.println("created conn");
    }

    public void stopClient()
    {
        try {
            this.skt.close();
        }catch(IOException ioe){ };
    }

    public void run() {
        String msg = ""; //will hold message sent from client
        System.out.println("Run Client");
	//sent out initial welcome message etc. if required...
        //pw.println("Welcome to Java based Server");
        try {
            if (br.ready()){
                msg = br.readLine();
                while (msg != null && running) {
                //provide your server's logic here//

                //right now it is acting as an ECHO server//
                    
                //pw.println(msg); //echo msg back to client//
                    System.out.println(msg);
                    msg = br.readLine();
                }
            }else{
                running = false;
                System.out.println("Selesai");
            }
       }catch (IOException ioe) {
            System.out.println(ioe);
            running = false;
       }
        //it's time to close the socket
       try {
            this.skt.close();
            System.out.println("Closing connection");
            System.out.println("running="+running);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        //notify the observers for cleanup etc.
        this.setChanged();              //inherit from Observable
        this.notifyObservers(this);     //inherit from Observable
    }*/
    //---------------------------------------------------------------------------
    Socket connectionsocket = null;
    ObjectInputStream input = null;
    ObjectOutputStream output = null;

    public ClientThread(Socket incomingSocket) throws IOException{
        connectionsocket = incomingSocket;
    }

    public void run(){
        try{
            System.out.println("\nSTART THREAD");
            InetAddress client = connectionsocket.getInetAddress();
            String clientip = client.getHostAddress();
            int clientport = connectionsocket.getPort();
            //PeerData newclient = new PeerData(clientip,clientport);

            System.out.println(clientip + ":" + clientport + " send request to Tracker.");
            //buat i/o stream
            ObjectInputStream inputs = new ObjectInputStream(connectionsocket.getInputStream());
            ObjectOutputStream outputs = new ObjectOutputStream(connectionsocket.getOutputStream());
            //BufferedReader inputs = new BufferedReader(new InputStreamReader(connectionsocket.getInputStream()));
            //PrintWriter outputs = new PrintWriter(new OutputStreamWriter(connectionsocket.getOutputStream()));
            boolean stop = false;
            while(stop == false){
                //baca request
                //System.out.println("AAAAAAAAAAA");
                //printList();
                String req = (String)inputs.readObject();
                //String req = inputs.readLine();
                System.out.println("Request : " + req);
                //lakukan penanganan request (membuat response)
                //String reqdecoded = URLDecoder.decode(req,"UTF-8");
                //Request request = Request.translateString(reqdecoded);
                //Response respon = createResponse(request,clientip,request.port);
                //String _respon = respon.createString();
                //System.out.println("kirim -->\n" + _respon + "\n");
                //if(request.event != 2){
                  //  outputs.writeObject(_respon);
                //}
                //else{
                  //  stop = respon.stop;
                //}
                //outputs.write(_respon);
                //stop = respon.stop;
                //System.out.print("tes");
                stop = true;
            }
            inputs.close();
            outputs.close();
            connectionsocket.close();
            System.out.println("Connection stopped : execute stop request from client");
            System.out.println("END THREAD");
        }
        catch(Exception e){
            System.err.println("Connection stopped : client cut the connection");
            System.out.println("END THREAD");
        }
    }
}
