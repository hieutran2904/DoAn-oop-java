/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class PHIEUNHAP {
    private String id_pn;
    private String id_vt;
    private String id_nhacc;
    private String id_nv;
    private String ngay_nhap;
    private int so_luong_nhap;
    private float don_gia_nhap;
    private String vi_tri_vat_tu;

    public PHIEUNHAP() {
    }

    public PHIEUNHAP(String id_pn, String id_vt, String id_nhacc, String id_nv, String ngay_nhap, int so_luong_nhap, float don_gia_nhap, String vi_tri_vat_tu) {
        this.id_pn = id_pn;
        this.id_vt = id_vt;
        this.id_nhacc = id_nhacc;
        this.id_nv = id_nv;
        this.ngay_nhap = ngay_nhap;
        this.so_luong_nhap = so_luong_nhap;
        this.don_gia_nhap = don_gia_nhap;
        this.vi_tri_vat_tu = vi_tri_vat_tu;
    }

    public String getId_pn() {
        return id_pn;
    }

    public void setId_pn(String id_pn) {
        this.id_pn = id_pn;
    }

    public String getId_vt() {
        return id_vt;
    }

    public void setId_vt(String id_vt) {
        this.id_vt = id_vt;
    }

    public String getId_nhacc() {
        return id_nhacc;
    }

    public void setId_nhacc(String id_nhacc) {
        this.id_nhacc = id_nhacc;
    }

    public String getId_nv() {
        return id_nv;
    }

    public void setId_nv(String id_nv) {
        this.id_nv = id_nv;
    }

    public String getNgay_nhap() {
        return ngay_nhap;
    }

    public void setNgay_nhap(String ngay_nhap) {
        this.ngay_nhap = ngay_nhap;
    }

    public int getSo_luong_nhap() {
        return so_luong_nhap;
    }

    public void setSo_luong_nhap(int so_luong_nhap) {
        this.so_luong_nhap = so_luong_nhap;
    }

    public float getDon_gia_nhap() {
        return don_gia_nhap;
    }

    public void setDon_gia_nhap(float don_gia_nhap) {
        this.don_gia_nhap = don_gia_nhap;
    }

    public String getVi_tri_vat_tu() {
        return vi_tri_vat_tu;
    }

    public void setVi_tri_vat_tu(String vi_tri_vat_tu) {
        this.vi_tri_vat_tu = vi_tri_vat_tu;
    }
    
}
