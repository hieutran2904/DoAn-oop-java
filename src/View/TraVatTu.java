/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.NhanVienDao;
import Dao.PhieuTraDao;
import Dao.TongVatTuDao;
import Dao.VatTuDao;
import Group.TONGVATTU;
import Model.NHANVIEN;
import Model.PHIEUTRA;
import Model.VATTU;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class TraVatTu extends javax.swing.JPanel {

    /**
     * Creates new form TraVatTu
     */
    private DefaultTableModel tblModel;
    private DefaultComboBoxModel cbxModel;
    public TraVatTu() throws Exception {
        initComponents();
        initTable();
        loadDataToTable();
        initComboBox();
        if (Login.id.contains("ad")) {
            txtidnv.setText("");
        } else txtidnv.setText(Login.id);
    }

    private String CreateID() throws Exception{
        List<PHIEUTRA> list = new PhieuTraDao().findAll("");
        if (list.size()!=0) {
            int index = list.size()-1;
            PHIEUTRA pt = list.get(index);
            int idNumber = Integer.parseInt(pt.getId_pt().substring(2)) + 1; //id next        
            if (idNumber < 10) {
                return "pt00"+String.valueOf(idNumber);
            }
            else if (idNumber >= 10 && idNumber <100) {
                return "pt0"+String.valueOf(idNumber);
            }
            return "pt"+String.valueOf(idNumber);
        }
        return "pt001";
    }
    
    private void initTable(){
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(new String[]{"ID phieu tra","ID vat tu","ID nhan vien","Ngay tra","So luong tra","Don gia tra","Ghi chu"});
        tblPhieuTra.setModel(tblModel);
    }
    
    private void loadDataToTable(){
        try {
            String key = txttimkiem.getText();
            PhieuTraDao dao = new PhieuTraDao();
            List<PHIEUTRA> list = dao.findAll(key);
            tblModel.setRowCount(0);
            for(PHIEUTRA pt : list){
                if (pt.getId_nv().contains(Login.id)) {
                    tblModel.addRow(new Object[]{
                    pt.getId_pt(),
                    pt.getId_vt(),
                    pt.getId_nv(),
                    pt.getNgay_tra(),
                    pt.getSo_luong_tra(),
                    pt.getGia_tra(),
                    pt.getGhi_chu()
                    });
                }
                else if (Login.id.contains("ad")) {
                    tblModel.addRow(new Object[]{
                    pt.getId_pt(),
                    pt.getId_vt(),
                    pt.getId_nv(),
                    pt.getNgay_tra(),
                    pt.getSo_luong_tra(),
                    pt.getGia_tra(),
                    pt.getGhi_chu()
                    });
                }
            }
            tblModel.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    private void initComboBox() throws Exception{
        List<VATTU> listvt = new VatTuDao().findCBX();
        cbxidvt.removeAllItems();
        for(VATTU vt : listvt){
            cbxidvt.addItem(vt.getId_vt());
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
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtidpt = new javax.swing.JTextField();
        cbxidvt = new javax.swing.JComboBox<>();
        txtsoluongtra = new javax.swing.JTextField();
        txtgiatra = new javax.swing.JTextField();
        jdcngaytra = new com.toedter.calendar.JDateChooser();
        txtghichu = new javax.swing.JTextField();
        btnMoi = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        txtidnv = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuTra = new javax.swing.JTable();
        btnTimKiem = new javax.swing.JButton();
        txttimkiem = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));

        jLabel6.setText("ID phieu tra");

        jLabel7.setText("ID vat tu");

        jLabel8.setText("ID nhan vien");

        jLabel9.setText("Ngay tra");

        jLabel10.setText("So luong tra");

        jLabel11.setText("Gia tra");

        jLabel12.setText("Ghi chu");

        txtidpt.setEditable(false);
        txtidpt.setBackground(new java.awt.Color(204, 204, 204));

        cbxidvt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jdcngaytra.setDateFormatString("yyyy-MM-dd");

        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/new-document.png"))); // NOI18N
        btnMoi.setText("Lam moi");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/floppy-disk.png"))); // NOI18N
        btnLuu.setText("Luu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/update.png"))); // NOI18N
        btnCapNhat.setText("Cap nhat");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/delete.png"))); // NOI18N
        btnXoa.setText("Xoa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        txtidnv.setEditable(false);
        txtidnv.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(161, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtidpt)
                            .addComponent(cbxidvt, 0, 90, Short.MAX_VALUE)
                            .addComponent(txtidnv))
                        .addGap(215, 215, 215)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jdcngaytra, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(txtsoluongtra)
                            .addComponent(txtgiatra)
                            .addComponent(txtghichu)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnMoi)
                        .addGap(18, 18, 18)
                        .addComponent(btnLuu)
                        .addGap(18, 18, 18)
                        .addComponent(btnCapNhat)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel9)
                        .addComponent(txtidpt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jdcngaytra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(cbxidvt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsoluongtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtgiatra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtidnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtghichu))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMoi)
                    .addComponent(btnLuu)
                    .addComponent(btnCapNhat)
                    .addComponent(btnXoa))
                .addGap(18, 18, 18))
        );

        tblPhieuTra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhieuTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuTraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhieuTra);

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/seo.png"))); // NOI18N
        btnTimKiem.setText("Tim kiem");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiem)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiem)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        try {
            // TODO add your handling code here:
            txtidpt.setText(CreateID());
        } catch (Exception ex) {
            Logger.getLogger(TraVatTu.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtidnv.setText(Login.id);
        txtsoluongtra.setText("");
        txtgiatra.setText("");
        jdcngaytra.setDate(null);
        txtghichu.setText("");
        
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if (txtsoluongtra.getText().equals("")) {
            sb.append("Ban chua nhap so luong tra");
        }
        else if (txtgiatra.getText().equals("")) {
            sb.append("Ban chua nhap don gia tra");
        }
        else if (new SimpleDateFormat("yyyy-MM-dd").format(jdcngaytra.getDate()).equals("")) {
            sb.append("Ban chua nhap ngay nhap kho");
        }
        if(sb.length()>0){
           JOptionPane.showMessageDialog(this, sb);
           return;
        }
        try {
            PHIEUTRA pt = new PHIEUTRA();
            String id_vt = (String) cbxidvt.getItemAt(cbxidvt.getSelectedIndex());
            pt.setId_pt(txtidpt.getText());
            pt.setId_vt(id_vt);
            pt.setId_nv(Login.id);
            pt.setNgay_tra(new SimpleDateFormat("yyyy-MM-dd").format(jdcngaytra.getDate()));
            pt.setSo_luong_tra(Integer.parseInt(txtsoluongtra.getText()));
            pt.setGia_tra(Float.parseFloat(txtgiatra.getText()));
            pt.setGhi_chu(txtghichu.getText());
            
            TONGVATTU ttv = new TongVatTuDao().checkSL(id_vt);
            int slmax = ttv.getTong_sln() - ttv.getTong_slx() - ttv.getTong_slt();
            
            if (Integer.parseInt(txtsoluongtra.getText()) > slmax) {
                JOptionPane.showMessageDialog(this,"so luong tra <=" + String.valueOf(slmax) ,"canh bao",JOptionPane.ERROR_MESSAGE);
            } else{
                if (new PhieuTraDao().insert(pt)) {
                JOptionPane.showMessageDialog(this,"Phieu tra da duoc them vao CSDL");
                loadDataToTable();
                }
                else{
                    JOptionPane.showMessageDialog(this,"Them khong thanh cong");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR: "+e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this,"Ban co muon cap nhat phieu tra khong?") == JOptionPane.NO_OPTION){
            return;
        }
        try {
            PHIEUTRA pt = new PHIEUTRA();
            String id_vt = (String) cbxidvt.getItemAt(cbxidvt.getSelectedIndex());
            pt.setId_pt(txtidpt.getText());
            pt.setId_vt(id_vt);
            pt.setId_nv(Login.id);
            pt.setNgay_tra(new SimpleDateFormat("yyyy-MM-dd").format(jdcngaytra.getDate()));
            pt.setSo_luong_tra(Integer.parseInt(txtsoluongtra.getText()));
            pt.setGia_tra(Float.parseFloat(txtgiatra.getText()));
            pt.setGhi_chu(txtghichu.getText());
            
            TONGVATTU ttv = new TongVatTuDao().checkSL(id_vt);
            int slmax = ttv.getTong_sln() - ttv.getTong_slx() - ttv.getTong_slt();
            
            if (Integer.parseInt(txtsoluongtra.getText()) > slmax) {
                JOptionPane.showMessageDialog(this,"so luong tra <=" + String.valueOf(slmax) ,"canh bao",JOptionPane.ERROR_MESSAGE);
            } else{
                if (new PhieuTraDao().update(pt)) {
                JOptionPane.showMessageDialog(this,"Phieu tra da duoc cap nhat vao CSDL");
                loadDataToTable();
                }
                else{
                    JOptionPane.showMessageDialog(this,"cap nhat khong thanh cong");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR: "+e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this,"Ban co muon xoa phieu nhap khong?") == JOptionPane.NO_OPTION){
            return;
        }
        try {
            if (new PhieuTraDao().delete(txtidpt.getText())) {
                JOptionPane.showMessageDialog(this,"Phieu tra da duoc xoa khoi CSDL");
                btnMoiActionPerformed(evt);
                loadDataToTable();
            }
            else{
                JOptionPane.showMessageDialog(this,"Xoa khong thanh cong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblPhieuTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuTraMouseClicked
        // TODO add your handling code here:
        try {
            int row = tblPhieuTra.getSelectedRow();
            int count_vt = cbxidvt.getItemCount();

            if (row >= 0) {
                String id = (String) tblPhieuTra.getValueAt(row, 0);
                PHIEUTRA pt = new PhieuTraDao().findByID(id);
                if (pt != null) {
                    txtidpt.setText(pt.getId_pt());
                    for(int i = 0; i < count_vt; i++){
                        if(pt.getId_vt() == null ? cbxidvt.getItemAt(i) == null : pt.getId_vt().equals(cbxidvt.getItemAt(i))){
                            cbxidvt.setSelectedIndex(i);
                        }
                    }
                    txtidnv.setText(pt.getId_nv());
                    jdcngaytra.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(pt.getNgay_tra()));
                    txtsoluongtra.setText(String.valueOf(pt.getSo_luong_tra()));
                    txtgiatra.setText(String.valueOf(pt.getGia_tra()));
                    txtghichu.setText(pt.getGhi_chu());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblPhieuTraMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        loadDataToTable();
    }//GEN-LAST:event_btnTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbxidvt;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcngaytra;
    private javax.swing.JTable tblPhieuTra;
    private javax.swing.JTextField txtghichu;
    private javax.swing.JTextField txtgiatra;
    private javax.swing.JTextField txtidnv;
    private javax.swing.JTextField txtidpt;
    private javax.swing.JTextField txtsoluongtra;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}
