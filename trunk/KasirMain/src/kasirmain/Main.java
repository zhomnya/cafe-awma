/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kasirmain;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Ahmad 'ANS' Syuhada
 */
public final class Main {
    //PARAM
    public static ArrayList<Transaksi> resto = new ArrayList<Transaksi>();
    public static Server server;
    public static Tampilan utama = new Tampilan();

    public Main(){
        for (int i=0; i<10; i++){
            Transaksi tr = new Transaksi(i+1, false);
            resto.add(tr);
        }
        server = new Server();
        utama.setVisible(true);
    }
    @SuppressWarnings("static-access")
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        //INI CLASS UTAMA semua
        Main assik = new Main();
        assik.server.startServer();
    }

}
