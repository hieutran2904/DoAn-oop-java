
package Model;

/**
 *
 * @author Admin
 */
public class NHANVIEN {
    private String id_nv;
    private String ho_nv;
    private String ten_nv;
    private String ngay_sinh;
    private String phai;
    private String std;
    private String tai_khoan;
    private String mat_khau;

    public NHANVIEN() {
    }

    public NHANVIEN(String id_nv, String ho_nv, String ten_nv, String ngay_sinh, String phai, String std, String tai_khoan, String mat_khau) {
        this.id_nv = id_nv;
        this.ho_nv = ho_nv;
        this.ten_nv = ten_nv;
        this.ngay_sinh = ngay_sinh;
        this.phai = phai;
        this.std = std;
        this.tai_khoan = tai_khoan;
        this.mat_khau = mat_khau;
    }

    public String getId_nv() {
        return id_nv;
    }

    public void setId_nv(String id_nv) {
        this.id_nv = id_nv;
    }

    public String getHo_nv() {
        return ho_nv;
    }

    public void setHo_nv(String ho_nv) {
        this.ho_nv = ho_nv;
    }

    public String getTen_nv() {
        return ten_nv;
    }

    public void setTen_nv(String ten_nv) {
        this.ten_nv = ten_nv;
    }

    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
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

    public String getTai_khoan() {
        return tai_khoan;
    }

    public void setTai_khoan(String tai_khoan) {
        this.tai_khoan = tai_khoan;
    }

    public String getMat_khau() {
        return mat_khau;
    }

    public void setMat_khau(String mat_khau) {
        this.mat_khau = mat_khau;
    }

    
}

    