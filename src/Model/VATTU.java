/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class VATTU {
    private String id_vt;
    private String ten_vt;
    private String loai_vt;
    private String don_vi_tinh;
    private String id_kho;

    public VATTU() {
    }

    public VATTU(String id_vt, String ten_vt, String loai_vt, String don_vi_tinh, String id_kho) {
        this.id_vt = id_vt;
        this.ten_vt = ten_vt;
        this.loai_vt = loai_vt;
        this.don_vi_tinh = don_vi_tinh;
        this.id_kho = id_kho;
    }

    public String getId_vt() {
        return id_vt;
    }

    public void setId_vt(String id_vt) {
        this.id_vt = id_vt;
    }

    public String getTen_vt() {
        return ten_vt;
    }

    public void setTen_vt(String ten_vt) {
        this.ten_vt = ten_vt;
    }

    public String getLoai_vt() {
        return loai_vt;
    }

    public void setLoai_vt(String loai_vt) {
        this.loai_vt = loai_vt;
    }

    public String getDon_vi_tinh() {
        return don_vi_tinh;
    }

    public void setDon_vi_tinh(String don_vi_tinh) {
        this.don_vi_tinh = don_vi_tinh;
    }

    public String getId_kho() {
        return id_kho;
    }

    public void setId_kho(String id_kho) {
        this.id_kho = id_kho;
    }
    
    
}
