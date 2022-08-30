/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class KHACHHANG {
    private String id_kh;
    private String ho_ten_hk;
    private String phai;
    private String std;

    public KHACHHANG() {
    }

    public KHACHHANG(String id_kh, String ho_ten_hk, String phai, String std) {
        this.id_kh = id_kh;
        this.ho_ten_hk = ho_ten_hk;
        this.phai = phai;
        this.std = std;
    }

    public String getId_kh() {
        return id_kh;
    }

    public void setId_kh(String id_kh) {
        this.id_kh = id_kh;
    }

    public String getHo_ten_hk() {
        return ho_ten_hk;
    }

    public void setHo_ten_hk(String ho_ten_hk) {
        this.ho_ten_hk = ho_ten_hk;
    }

    public String getPhai() {
        return phai;
    }

    public void setPhai(String phai) {
        this.phai = phai;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }
    
    
}
