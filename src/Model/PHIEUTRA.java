/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class PHIEUTRA {
    private String id_pt;
    private String id_vt;
    private String id_nv;
    private String ngay_tra;
    private int so_luong_tra;
    private float gia_tra;
    private String ghi_chu;

    public PHIEUTRA() {
    }

    public PHIEUTRA(String id_pt, String id_vt, String id_nv, String ngay_tra, int so_luong_tra, float gia_tra, String ghi_chu) {
        this.id_pt = id_pt;
        this.id_vt = id_vt;
        this.id_nv = id_nv;
        this.ngay_tra = ngay_tra;
        this.so_luong_tra = so_luong_tra;
        this.gia_tra = gia_tra;
        this.ghi_chu = ghi_chu;
    }

    public String getId_pt() {
        return id_pt;
    }

    public void setId_pt(String id_pt) {
        this.id_pt = id_pt;
    }

    public String getId_vt() {
        return id_vt;
    }

    public void setId_vt(String id_vt) {
        this.id_vt = id_vt;
    }

    public String getId_nv() {
        return id_nv;
    }

    public void setId_nv(String id_nv) {
        this.id_nv = id_nv;
    }

    public String getNgay_tra() {
        return ngay_tra;
    }

    public void setNgay_tra(String ngay_tra) {
        this.ngay_tra = ngay_tra;
    }

    public int getSo_luong_tra() {
        return so_luong_tra;
    }

    public void setSo_luong_tra(int so_luong_tra) {
        this.so_luong_tra = so_luong_tra;
    }

    public float getGia_tra() {
        return gia_tra;
    }

    public void setGia_tra(float gia_tra) {
        this.gia_tra = gia_tra;
    }

    public String getGhi_chu() {
        return ghi_chu;
    }

    public void setGhi_chu(String ghi_chu) {
        this.ghi_chu = ghi_chu;
    }
    
}
