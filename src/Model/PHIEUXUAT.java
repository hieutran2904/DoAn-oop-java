/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class PHIEUXUAT {
    private String id_px;
    private String id_vt;
    private String id_nv;
    private String id_kh;
    private String ngay_xuat;
    private int so_luong_xuat;
    private float don_gia_xuat;

    public PHIEUXUAT() {
    }

    public PHIEUXUAT(String id_px, String id_vt, String id_nv, String id_kh, String ngay_xuat, int so_luong_xuat, float don_gia_xuat) {
        this.id_px = id_px;
        this.id_vt = id_vt;
        this.id_nv = id_nv;
        this.id_kh = id_kh;
        this.ngay_xuat = ngay_xuat;
        this.so_luong_xuat = so_luong_xuat;
        this.don_gia_xuat = don_gia_xuat;
    }

    public String getId_px() {
        return id_px;
    }

    public void setId_px(String id_px) {
        this.id_px = id_px;
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

    public String getId_kh() {
        return id_kh;
    }

    public void setId_kh(String id_kh) {
        this.id_kh = id_kh;
    }

    public String getNgay_xuat() {
        return ngay_xuat;
    }

    public void setNgay_xuat(String ngay_xuat) {
        this.ngay_xuat = ngay_xuat;
    }

    public int getSo_luong_xuat() {
        return so_luong_xuat;
    }

    public void setSo_luong_xuat(int so_luong_xuat) {
        this.so_luong_xuat = so_luong_xuat;
    }

    public float getDon_gia_xuat() {
        return don_gia_xuat;
    }

    public void setDon_gia_xuat(float don_gia_xuat) {
        this.don_gia_xuat = don_gia_xuat;
    }
    
    
    
}
