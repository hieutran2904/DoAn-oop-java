/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Group;

/**
 *
 * @author Admin
 */
//thong ke
public class KHOVT {
    private String id_vt;
    private String ten_kho;
    private String vi_tri;
    private String ten_nhacc;

    public KHOVT() {
    }

    public KHOVT(String id_vt, String ten_kho, String vi_tri, String ten_nhacc) {
        this.id_vt = id_vt;
        this.ten_kho = ten_kho;
        this.vi_tri = vi_tri;
        this.ten_nhacc = ten_nhacc;
    }

    public String getId_vt() {
        return id_vt;
    }

    public void setId_vt(String id_vt) {
        this.id_vt = id_vt;
    }

    public String getTen_kho() {
        return ten_kho;
    }

    public void setTen_kho(String ten_kho) {
        this.ten_kho = ten_kho;
    }

    public String getVi_tri() {
        return vi_tri;
    }

    public void setVi_tri(String vi_tri) {
        this.vi_tri = vi_tri;
    }

    public String getTen_nhacc() {
        return ten_nhacc;
    }

    public void setTen_nhacc(String ten_nhacc) {
        this.ten_nhacc = ten_nhacc;
    }
    
}
