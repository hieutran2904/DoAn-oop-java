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
public class TKNV {
    private String id_nv;
    private String ho_ten;
    private int sln;
    private int slx;
    private int slt;

    public TKNV() {
    }

    public TKNV(String id_nv, String ho_ten, int sln, int slx, int slt) {
        this.id_nv = id_nv;
        this.ho_ten = ho_ten;
        this.sln = sln;
        this.slx = slx;
        this.slt = slt;
    }

    public String getId_nv() {
        return id_nv;
    }

    public void setId_nv(String id_nv) {
        this.id_nv = id_nv;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public int getSln() {
        return sln;
    }

    public void setSln(int sln) {
        this.sln = sln;
    }

    public int getSlx() {
        return slx;
    }

    public void setSlx(int slx) {
        this.slx = slx;
    }

    public int getSlt() {
        return slt;
    }

    public void setSlt(int slt) {
        this.slt = slt;
    }
    
}
