/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kasirmain;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ahmad 'ANS' Syuhada
 */
public class Transaksi {
    //ini class transaksi per meja
    private int meja;
    private Boolean ljt;
    private String notrans;
    private Date tgltrans;
    private ArrayList<Pesanan> jpesan;

    public Transaksi(){}

    public Transaksi(int mmeja, Boolean lljt){
        meja=mmeja;
        lljt=ljt;
        jpesan = new ArrayList<Pesanan>();
        tgltrans = new Date();
        notrans = "BARU";
    }

    public int getMeja(){
        return meja;
    }

    public String getDate(){
        return tgltrans.toString();
    }

    public void chDate(){
        tgltrans = new Date();
    }

    public String getNotrans(){
        return notrans;
    }

    public Boolean getLjt(){
        return ljt;
    }

    public void setLjt(Boolean lljt){
        ljt = lljt;
    }

    public void addPesanan(int id, int type, int qty){
        Pesanan psn = new Pesanan(id, type, qty);
        jpesan.add(psn);
    }

    public void delPesanan(int no){
        jpesan.remove(no);
    }

    public void resetPesanan(){
        jpesan.clear();
    }

    public ArrayList<Pesanan> getPesanan(){
        return jpesan;
    }
}
