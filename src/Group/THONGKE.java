/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Group;

/**
 *
 * @author Admin
 */
public class THONGKE extends TONGVATTU{
    private String loai_vt;
    private String don_vi_tinh;
    private long tong_tn;
    private long tong_tb;
    private long tong_tht;

    public THONGKE() {
    }

    public THONGKE(String loai_vt, String don_vi_tinh, long tong_tn, long tong_tb, long tong_tht, String id_vt, String ten_vt, int tong_sln, int tong_slx, int tong_slt) {
        super(id_vt, ten_vt, tong_sln, tong_slx, tong_slt);
        this.loai_vt = loai_vt;
        this.don_vi_tinh = don_vi_tinh;
        this.tong_tn = tong_tn;
        this.tong_tb = tong_tb;
        this.tong_tht = tong_tht;
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

    public long getTong_tn() {
        return tong_tn;
    }

    public void setTong_tn(long tong_tn) {
        this.tong_tn = tong_tn;
    }

    public long getTong_tb() {
        return tong_tb;
    }

    public void setTong_tb(long tong_tb) {
        this.tong_tb = tong_tb;
    }

    public long getTong_tht() {
        return tong_tht;
    }

    public void setTong_tht(long tong_tht) {
        this.tong_tht = tong_tht;
    }
    
}