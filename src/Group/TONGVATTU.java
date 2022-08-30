/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Group;

/**
 *
 * @author Admin
 */
//trang chu
public class TONGVATTU {
    private String id_vt;
    private String ten_vt;
    private int tong_sln;
    private int tong_slx;
    private int tong_slt;

    public TONGVATTU() {
    }

    public TONGVATTU(String id_vt, String ten_vt, int tong_sln, int tong_slx, int tong_slt) {
        this.id_vt = id_vt;
        this.ten_vt = ten_vt;
        this.tong_sln = tong_sln;
        this.tong_slx = tong_slx;
        this.tong_slt = tong_slt;
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

    public int getTong_sln() {
        return tong_sln;
    }

    public void setTong_sln(int tong_sln) {
        this.tong_sln = tong_sln;
    }

    public int getTong_slx() {
        return tong_slx;
    }

    public void setTong_slx(int tong_slx) {
        this.tong_slx = tong_slx;
    }

    public int getTong_slt() {
        return tong_slt;
    }

    public void setTong_slt(int tong_slt) {
        this.tong_slt = tong_slt;
    }
    
}
