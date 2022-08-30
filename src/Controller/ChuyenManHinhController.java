/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;



import Bean.DanhMucBean;
import View.TrangChu;
import View.NhapKho;
import View.XuatKho;
import View.TraVatTu;
import View.NhaCC;
import View.VatTu;
import View.KhachHang;
import View.KhoBai;
import View.NhanVien;
import View.ThongKe;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class ChuyenManHinhController {
    private JPanel root;
    private String kindSelected = "";
    
    private List<DanhMucBean> listItem = null;

    public ChuyenManHinhController(JPanel root) {
        this.root = root;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem){
        kindSelected = "TrangChu";
        jpnItem.setBackground(new Color(250,250,250));
        jlbItem.setBackground(new Color(250,250,250));
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChu());
        root.validate();
        root.repaint();
    }
    
    public void setEvent(List<DanhMucBean> listItem){
        this.listItem = listItem;
        for(DanhMucBean item : listItem){
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    
    class LabelEvent implements MouseListener{
        
        private JPanel node;
        
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                switch(kind){
                    case "TrangChu":
                        node = new TrangChu();
                        break;
                    case "NhapKho":
                        node = new NhapKho();
                        break;
                    case "XuatKho":
                        node = new XuatKho();
                        break;
                    case "TraVatTu":
                        node = new TraVatTu();
                        break;
                    case "NhaCC":
                        node = new NhaCC();
                        break;
                    case "VatTu":
                        node = new VatTu();
                        break;
                    case "KhachHang":
                        node = new KhachHang();
                        break;
                    case "KhoBai":
                        node = new KhoBai();
                        break;
                    case "NhanVien":
                        node = new NhanVien();
                        break;
                    case "ThongKe":
                        node = new ThongKe();
                        break;
                    default:
                        node = new TrangChu();
                        break;
                }
                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(node);
                root.validate();
                root.repaint();
                setChangeBackground(kind);
            } catch (Exception ex) {
                Logger.getLogger(ChuyenManHinhController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(250,250,250));
            jlbItem.setBackground(new Color(250,250,250));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(250,250,250));
            jlbItem.setBackground(new Color(250,250,250));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindSelected.equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(209, 209, 209));
                jlbItem.setBackground(new Color(209, 209, 209));
            }
        }
    }
    private void setChangeBackground(String kind){
        for(DanhMucBean item : listItem){
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getJpn().setBackground(new Color(250,250,250));
                item.getJlb().setBackground(new Color(250,250,250));
            } else{
                item.getJpn().setBackground(new Color(209, 209, 209));
                item.getJlb().setBackground(new Color(209, 209, 209));
            }
        }
    }
}
