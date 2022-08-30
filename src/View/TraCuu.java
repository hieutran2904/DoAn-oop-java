/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Dao.KhachHangDao;
import Dao.KhoDao;
import Dao.NhaCCDao;
import Dao.VatTuDao;
import Model.KHACHHANG;
import Model.KHO;
import Model.NHACC;
import Model.VATTU;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class TraCuu extends javax.swing.JFrame {

    /**
     * Creates new form TraCuu
     */
    private DefaultTableModel tblModel;
    public TraCuu() {
        initComponents();
        setLocationRelativeTo(null);
        jlbNameTable.setText(Home.tracuu);
        initTable();
        loadDataToTable();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    private void initTable() {
        tblModel = new DefaultTableModel();
        switch (Home.row) {
            case 0:
                tblModel.setColumnIdentifiers(new String[]{"ID nha cung cap","Ten nha cung cap","Dia chi","So dien thoai"});
                break;
            case 1:
                tblModel.setColumnIdentifiers(new String[]{"ID vat tu","Ten vat tu","Don vi tinh","ID kho"});
                break;
            case 2: 
                tblModel.setColumnIdentifiers(new String[]{"ID khach hang","Ho & ten","Phai","So dien thoai"});
                break;
            case 3:
                tblModel.setColumnIdentifiers(new String[]{"ID kho","Ten kho","Loai kho","Dia chi"});
                break;
            default:
                throw new AssertionError();
        }
        tblThongTin.setModel(tblModel);
    }
    private void loadDataToTable(){
        switch (Home.row) {
            case 0:
                try {
                    NhaCCDao dao = new NhaCCDao();
                    List<NHACC> list = dao.findAll();
                    tblModel.setRowCount(0);
                    for(NHACC nhacc : list){
                        tblModel.addRow(new Object[]{
                        nhacc.getId_nhacc(),
                        nhacc.getTen_nhacc(),
                        nhacc.getDia_chi(),
                        nhacc.getSdt()
                    });
                }
                tblModel.fireTableDataChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 1:
                try {
                    VatTuDao dao = new VatTuDao();
                    List<VATTU> list = dao.findAll("");
                    tblModel.setRowCount(0);
                    for(VATTU vt : list){
                        tblModel.addRow(new Object[]{
                        vt.getId_vt(),
                        vt.getTen_vt(),
                        vt.getDon_vi_tinh(),
                        vt.getId_kho()
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    KhachHangDao dao = new KhachHangDao();
                    List<KHACHHANG> list = dao.findAll();
                    tblModel.setRowCount(0);
                    for(KHACHHANG kh : list){
                        tblModel.addRow(new Object[]{
                        kh.getId_kh(),
                        kh.getHo_ten_hk(),
                        kh.getPhai(),
                        kh.getStd()
                        });
                    }
                    tblModel.fireTableDataChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    KhoDao dao = new KhoDao();
                    List<KHO> list = dao.findAll();
                    tblModel.setRowCount(0);
                    for(KHO kho : list){
                        tblModel.addRow(new Object[]{
                        kho.getId_kho(),
                        kho.getTen_kho(),
                        kho.getLoai_kho(),
                        kho.getDia_chi()
                    });
                }
                tblModel.fireTableDataChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                throw new AssertionError();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongTin = new javax.swing.JTable();
        jlbNameTable = new javax.swing.JLabel();
        btnThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        tblThongTin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblThongTin);

        jlbNameTable.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jlbNameTable.setForeground(new java.awt.Color(255, 51, 51));
        jlbNameTable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbNameTable.setText("jLabel1");

        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logout.png"))); // NOI18N
        btnThoat.setText("Thoat");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThoat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbNameTable, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlbNameTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnThoatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TraCuu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TraCuu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TraCuu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TraCuu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TraCuu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThoat;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbNameTable;
    private javax.swing.JTable tblThongTin;
    // End of variables declaration//GEN-END:variables
}