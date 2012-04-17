/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Tampilan.java
 *
 * Created on 18 Apr 12, 1:46:32
 */

package kasirmain;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Ahmad 'ANS' Syuhada
 */
public class Tampilan extends javax.swing.JFrame {

    /** Creates new form Tampilan */
    public Tampilan() {
        initComponents();
        btnCetak.setEnabled(false);
        btnTrans.setEnabled(false);
        btnHapus.setEnabled(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlUtama = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstMeja = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTrans = new javax.swing.JTable();
        lblTgl = new javax.swing.JLabel();
        lblNotrans = new javax.swing.JLabel();
        btnHapus = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        btnTrans = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lblNotif = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AWMA - CAFE");
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 830, 536));
        setResizable(false);

        lstMeja.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Meja 1", "Meja 2", "Meja 3", "Meja 4", "Meja 5", "Meja 6", "Meja 7", "Meja 8", "Meja 9", "Meja 10" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstMeja.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstMeja.setToolTipText("Pilih meja untuk dilihat");
        lstMeja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstMejaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstMeja);

        tblTrans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "Qty"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTrans.setColumnSelectionAllowed(true);
        tblTrans.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblTrans);
        tblTrans.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        lblTgl.setText("Tanggal :");

        lblNotrans.setText("No Transaksi :");

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnCetak.setText("Cetak Bon");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        btnTrans.setText("Transaksi");
        btnTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransActionPerformed(evt);
            }
        });

        lblNotif.setColumns(15);
        lblNotif.setRows(5);
        lblNotif.setEnabled(false);
        jScrollPane3.setViewportView(lblNotif);

        javax.swing.GroupLayout pnlUtamaLayout = new javax.swing.GroupLayout(pnlUtama);
        pnlUtama.setLayout(pnlUtamaLayout);
        pnlUtamaLayout.setHorizontalGroup(
            pnlUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUtamaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUtamaLayout.createSequentialGroup()
                        .addComponent(btnCetak)
                        .addGap(10, 10, 10)
                        .addComponent(btnTrans))
                    .addComponent(btnHapus)
                    .addComponent(lblTgl)
                    .addComponent(lblNotrans)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        pnlUtamaLayout.setVerticalGroup(
            pnlUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUtamaLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUtamaLayout.createSequentialGroup()
                        .addComponent(lblTgl)
                        .addGap(30, 30, 30)
                        .addComponent(lblNotrans)
                        .addGap(29, 29, 29)
                        .addComponent(btnHapus)
                        .addGap(56, 56, 56)
                        .addGroup(pnlUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCetak)
                            .addComponent(btnTrans))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
                .addGap(84, 84, 84))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstMejaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstMejaMouseClicked
        // TODO add your handling code here:
        //activate
        //get index
        int i = lstMeja.getSelectedIndex();
        System.out.println("klik-"+i);
        Transaksi temp = Main.resto.get(i);
        //set label
        lblNotrans.setText("No Transaksi : "+temp.getNotrans());
        lblTgl.setText("Tanggal : "+temp.getDate());
        //set tabel
        DefaultTableModel tempmo = (DefaultTableModel)tblTrans.getModel();
        int ctbl = tempmo.getRowCount();
        System.out.println("ctbl="+ctbl);
        ArrayList<Pesanan> temppes = temp.getPesanan();
        int cpes = temppes.size();
        System.out.println("cpes="+cpes);
        //add
        if (cpes==0){
            btnCetak.setEnabled(false);
            btnTrans.setEnabled(false);
        }else{
            btnCetak.setEnabled(true);
            btnTrans.setEnabled(true);
        }
        if (ctbl<cpes){
            for (int j=ctbl; j<cpes; j++){
                Pesanan tpes = temppes.get(j);
                tempmo.insertRow(ctbl, new Object[]{"","",""});
            }
        }else if (ctbl>cpes){   //del
            for (int j=ctbl; j>cpes; j--){
                tempmo.removeRow(j-1);
            }
        }
        //update
        for (int j=0; j<cpes; j++){
            Pesanan tpes = temppes.get(j);
            tempmo.setValueAt(tpes.getID(), j, 0);
            tempmo.setValueAt(tpes.getType(), j, 1);
            tempmo.setValueAt(tpes.getQty(), j, 2);
        }
        tblTrans.setModel(tempmo);
    }//GEN-LAST:event_lstMejaMouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        System.out.println("Hapus clicked");
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        System.out.println("cetak clicked");
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransActionPerformed
        // TODO add your handling code here:
        System.out.println("transaksi clicked");
        int i = lstMeja.getSelectedIndex();
        Transaksi temp = Main.resto.get(i);
        Nota nt = new Nota(temp);
        this.setEnabled(false);
        nt.setVisible(true);
    }//GEN-LAST:event_btnTransActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tampilan().setVisible(true);
            }
        });
    }

    public void setNotif(String psn){
        lblNotif.setText(psn);
    }

    public String getNotif(){
        return lblNotif.getText();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTrans;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea lblNotif;
    private javax.swing.JLabel lblNotrans;
    private javax.swing.JLabel lblTgl;
    private javax.swing.JList lstMeja;
    private javax.swing.JPanel pnlUtama;
    private javax.swing.JTable tblTrans;
    // End of variables declaration//GEN-END:variables

}
