/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class NHACC {
    private String id_nhacc;
    private String ten_nhacc;
    private String dia_chi;
    private String sdt;

    public NHACC() {
    }

    public NHACC(String id_nhacc, String ten_nhacc, String dia_chi, String sdt) {
        this.id_nhacc = id_nhacc;
        this.ten_nhacc = ten_nhacc;
        this.dia_chi = dia_chi;
        this.sdt = sdt;
    }

    public String getId_nhacc() {
        return id_nhacc;
    }

    public void setId_nhacc(String id_nhacc) {
        this.id_nhacc = id_nhacc;
    }

    public String getTen_nhacc() {
        return ten_nhacc;
    }

    public void setTen_nhacc(String ten_nhacc) {
        this.ten_nhacc = ten_nhacc;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    
}
