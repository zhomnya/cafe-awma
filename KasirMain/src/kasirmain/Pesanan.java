/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kasirmain;

/**
 *
 * @author Ahmad 'ANS' Syuhada
 */
public class Pesanan {
    //ini class pesanan per makanan, untuk transaksi
    private int id;
    private int type;
    private int qty;

    public Pesanan(int idx, int typx, int qtyx){
        id=idx;
        type=typx;
        qty=qtyx;
    }

    public int getID(){
        return id;
    }

    public int getType(){
        return type;
    }

    public int getQty(){
        return qty;
    }

    public void setAll(int a, int isi){
        if (a==1){
            id=isi;
        }else if(a==2){
            type=isi;
        }else{
            qty=isi;
        }
    }
}
