/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class KHO {
    private String id_kho;
    private String ten_kho;
    private String loai_kho;
    private String dia_chi;

    public KHO() {
    }

    public KHO(String id_kho, String ten_kho, String loai_kho, String dia_chi) {
        this.id_kho = id_kho;
        this.ten_kho = ten_kho;
        this.loai_kho = loai_kho;
        this.dia_chi = dia_chi;
    }

    public String getId_kho() {
        return id_kho;
    }

    public void setId_kho(String id_kho) {
        this.id_kho = id_kho;
    }

    public String getTen_kho() {
        return ten_kho;
    }

    public void setTen_kho(String ten_kho) {
        this.ten_kho = ten_kho;
    }

    public String getLoai_kho() {
        return loai_kho;
    }

    public void setLoai_kho(String loai_kho) {
        this.loai_kho = loai_kho;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }
}
