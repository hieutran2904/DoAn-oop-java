/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Group.THONGKE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ThongKeDao {
    public List<THONGKE> findAll(String dateStart, String dateEnd) throws Exception{
//        String sql = "SELECT dbo.VATTU.id_vt, ten_vt , loai_vt,don_vi_tinh, \n" +
//"SUM(DISTINCT so_luong_nhap) AS sln, \n" +
//"SUM(DISTINCT so_luong_xuat) AS slx, \n" +
//"SUM(DISTINCT so_luong_tra) AS slt,\n" +
//"SUM(DISTINCT so_luong_nhap * don_gia_nhap) AS tongtiennhap,\n" +
//"SUM(DISTINCT so_luong_xuat * don_gia_xuat) AS tongtienban,\n" +
//"SUM(DISTINCT so_luong_tra * gia_tra) AS  tongtienhoantra\n" +
//"FROM dbo.PHIEUNHAP FULL JOIN dbo.VATTU ON VATTU.id_vt = PHIEUNHAP.id_vt\n" +
//"FULL JOIN dbo.PHIEUXUAT ON PHIEUXUAT.id_vt = VATTU.id_vt\n" +
//"FULL JOIN dbo.PHIEUTRA ON PHIEUTRA.id_vt = VATTU.id_vt\n" +
//"WHERE ngay_nhap BETWEEN '"+dateStart+"' AND '"+dateEnd+"'\n"+
//"GROUP BY dbo.VATTU.id_vt, ten_vt , loai_vt,don_vi_tinh";
//        String sql = "SELECT dbo.VATTU.id_vt, ten_vt , loai_vt,don_vi_tinh,\n" +
//"SUM(DISTINCT so_luong_nhap) AS sln,\n" +
//"SUM(DISTINCT so_luong_xuat) AS slx,\n" +
//"SUM(DISTINCT so_luong_tra) AS slt,\n" +
//"SUM(DISTINCT (so_luong_nhap * don_gia_nhap)) AS tongtiennhap,\n" +
//"SUM(DISTINCT (so_luong_xuat * don_gia_xuat)) AS tongtienban,\n" +
//"SUM(DISTINCT (so_luong_tra * gia_tra)) AS  tongtienhoantra\n" +
//"FROM dbo.PHIEUNHAP FULL JOIN dbo.VATTU ON VATTU.id_vt = PHIEUNHAP.id_vt\n" +
//"FULL JOIN dbo.PHIEUXUAT ON PHIEUXUAT.id_vt = VATTU.id_vt\n" +
//"FULL JOIN dbo.PHIEUTRA ON PHIEUTRA.id_vt = VATTU.id_vt\n" +
//"WHERE ngay_nhap BETWEEN '"+dateStart+"' AND '"+dateEnd+"'\n" +
//"GROUP BY dbo.VATTU.id_vt, ten_vt , loai_vt,don_vi_tinh\n" +
//"UNION\n" +
//"SELECT dbo.VATTU.id_vt, ten_vt , loai_vt,don_vi_tinh,\n" +
//"SUM(DISTINCT so_luong_nhap) AS sln,\n" +
//"SUM(DISTINCT so_luong_xuat) AS slx,\n" +
//"SUM(DISTINCT so_luong_tra) AS slt,\n" +
//"SUM(DISTINCT (so_luong_nhap * don_gia_nhap)) AS tongtiennhap,\n" +
//"SUM(DISTINCT (so_luong_xuat * don_gia_xuat)) AS tongtienban,\n" +
//"SUM(DISTINCT (so_luong_tra * gia_tra)) AS  tongtienhoantra\n" +
//"FROM dbo.PHIEUNHAP FULL JOIN dbo.VATTU ON VATTU.id_vt = PHIEUNHAP.id_vt\n" +
//"FULL JOIN dbo.PHIEUXUAT ON PHIEUXUAT.id_vt = VATTU.id_vt\n" +
//"FULL JOIN dbo.PHIEUTRA ON PHIEUTRA.id_vt = VATTU.id_vt\n" +
//"WHERE ngay_xuat BETWEEN '"+dateStart+"' AND '"+dateEnd+"'\n" +
//"GROUP BY dbo.VATTU.id_vt, ten_vt , loai_vt,don_vi_tinh\n" +
//"UNION\n" +
//"SELECT dbo.VATTU.id_vt, ten_vt , loai_vt,don_vi_tinh,\n" +
//"SUM(DISTINCT so_luong_nhap) AS sln,\n" +
//"SUM(DISTINCT so_luong_xuat) AS slx,\n" +
//"SUM(DISTINCT so_luong_tra) AS slt,\n" +
//"SUM(DISTINCT (so_luong_nhap * don_gia_nhap)) AS tongtiennhap,\n" +
//"SUM(DISTINCT (so_luong_xuat * don_gia_xuat)) AS tongtienban,\n" +
//"SUM(DISTINCT (so_luong_tra * gia_tra)) AS  tongtienhoantra\n" +
//"FROM dbo.PHIEUNHAP FULL JOIN dbo.VATTU ON VATTU.id_vt = PHIEUNHAP.id_vt\n" +
//"FULL JOIN dbo.PHIEUXUAT ON PHIEUXUAT.id_vt = VATTU.id_vt\n" +
//"FULL JOIN dbo.PHIEUTRA ON PHIEUTRA.id_vt = VATTU.id_vt\n" +
//"WHERE ngay_xuat BETWEEN '"+dateStart+"' AND '"+dateEnd+"'\n" +
//"GROUP BY dbo.VATTU.id_vt, ten_vt , loai_vt,don_vi_tinh";
//        String sql = "SELECT DISTINCT dbo.VATTU.id_vt,ten_vt,loai_vt,don_vi_tinh,\n" +
//"SUM(DISTINCT so_luong_nhap) AS sln,\n" +
//"SUM(DISTINCT so_luong_xuat) AS slx,\n" +
//"SUM(DISTINCT so_luong_tra) AS slt,\n" +
//"SUM(DISTINCT (so_luong_nhap*don_gia_nhap)) AS tongtiennhap,\n" +
//"SUM(DISTINCT (so_luong_xuat*don_gia_xuat)) AS tongtienban,\n" +
//"SUM(DISTINCT (so_luong_tra*gia_tra)) AS tongtienhoantra\n" +
//"FROM dbo.NHANVIEN FULL JOIN dbo.PHIEUNHAP ON PHIEUNHAP.id_nv = NHANVIEN.id_nv\n" +
//"FULL JOIN dbo.PHIEUXUAT ON PHIEUXUAT.id_nv = NHANVIEN.id_nv\n" +
//"FULL JOIN dbo.PHIEUTRA ON PHIEUTRA.id_nv = NHANVIEN.id_nv\n" +
//"FULL JOIN dbo.VATTU ON VATTU.id_vt = PHIEUNHAP.id_vt\n" +
//"WHERE ngay_nhap BETWEEN '"+dateStart+"' AND '"+dateEnd+"'\n" +
//"GROUP BY dbo.VATTU.id_vt,ten_vt,loai_vt,don_vi_tinh\n" +
//"UNION\n" +
//"SELECT DISTINCT dbo.VATTU.id_vt,ten_vt,loai_vt,don_vi_tinh,\n" +
//"SUM(DISTINCT so_luong_nhap) AS sln,\n" +
//"SUM(DISTINCT so_luong_xuat) AS slx,\n" +
//"SUM(DISTINCT so_luong_tra) AS slt,\n" +
//"SUM(DISTINCT (so_luong_nhap*don_gia_nhap)) AS tongtiennhap,\n" +
//"SUM(DISTINCT (so_luong_xuat*don_gia_xuat)) AS tongtienban,\n" +
//"SUM(DISTINCT (so_luong_tra*gia_tra)) AS tongtienhoantra\n" +
//"FROM dbo.NHANVIEN FULL JOIN dbo.PHIEUNHAP ON PHIEUNHAP.id_nv = NHANVIEN.id_nv\n" +
//"FULL JOIN dbo.PHIEUXUAT ON PHIEUXUAT.id_nv = NHANVIEN.id_nv\n" +
//"FULL JOIN dbo.PHIEUTRA ON PHIEUTRA.id_nv = NHANVIEN.id_nv\n" +
//"FULL JOIN dbo.VATTU ON VATTU.id_vt = PHIEUNHAP.id_vt\n" +
//"WHERE ngay_xuat BETWEEN '"+dateStart+"' AND '"+dateEnd+"'\n" +
//"GROUP BY dbo.VATTU.id_vt,ten_vt,loai_vt,don_vi_tinh\n" +
//"UNION\n" +
//"SELECT DISTINCT dbo.VATTU.id_vt,ten_vt,loai_vt,don_vi_tinh,\n" +
//"SUM(DISTINCT so_luong_nhap) AS sln,\n" +
//"SUM(DISTINCT so_luong_xuat) AS slx,\n" +
//"SUM(DISTINCT so_luong_tra) AS slt,\n" +
//"SUM(DISTINCT (so_luong_nhap*don_gia_nhap)) AS tongtiennhap,\n" +
//"SUM(DISTINCT (so_luong_xuat*don_gia_xuat)) AS tongtienban,\n" +
//"SUM(DISTINCT (so_luong_tra*gia_tra)) AS tongtienhoantra\n" +
//"FROM dbo.NHANVIEN FULL JOIN dbo.PHIEUNHAP ON PHIEUNHAP.id_nv = NHANVIEN.id_nv\n" +
//"FULL JOIN dbo.PHIEUXUAT ON PHIEUXUAT.id_nv = NHANVIEN.id_nv\n" +
//"FULL JOIN dbo.PHIEUTRA ON PHIEUTRA.id_nv = NHANVIEN.id_nv\n" +
//"FULL JOIN dbo.VATTU ON VATTU.id_vt = PHIEUNHAP.id_vt\n" +
//"WHERE ngay_tra BETWEEN '"+dateStart+"' AND '"+dateEnd+"'\n" +
//"GROUP BY dbo.VATTU.id_vt,ten_vt,loai_vt,don_vi_tinh";
        String sql = "SELECT dbo.VATTU.id_vt, ten_vt , loai_vt,don_vi_tinh,\n" +
"SUM(DISTINCT so_luong_nhap) AS sln,\n" +
"SUM(DISTINCT so_luong_xuat) AS slx,\n" +
"SUM(DISTINCT so_luong_tra) AS slt,\n" +
"SUM(DISTINCT so_luong_nhap * don_gia_nhap) AS tongtiennhap,\n" +
"SUM(DISTINCT so_luong_xuat * don_gia_xuat) AS tongtienban,\n" +
"SUM(DISTINCT so_luong_tra * gia_tra) AS  tongtienhoantra\n" +
"FROM dbo.PHIEUNHAP FULL JOIN dbo.VATTU ON VATTU.id_vt = PHIEUNHAP.id_vt\n" +
"FULL JOIN dbo.PHIEUXUAT ON PHIEUXUAT.id_vt = VATTU.id_vt\n" +
"FULL JOIN dbo.PHIEUTRA ON PHIEUTRA.id_vt = VATTU.id_vt\n" +
"WHERE ngay_nhap BETWEEN '"+dateStart+"' AND '"+dateEnd+"'\n" +
"GROUP BY dbo.VATTU.id_vt, ten_vt , loai_vt,don_vi_tinh\n" +
"UNION\n" +
"SELECT dbo.VATTU.id_vt, ten_vt , loai_vt,don_vi_tinh,\n" +
"SUM(DISTINCT so_luong_nhap) AS sln,\n" +
"SUM(DISTINCT so_luong_xuat) AS slx,\n" +
"SUM(DISTINCT so_luong_tra) AS slt,\n" +
"SUM(DISTINCT so_luong_nhap * don_gia_nhap) AS tongtiennhap,\n" +
"SUM(DISTINCT so_luong_xuat * don_gia_xuat) AS tongtienban,\n" +
"SUM(DISTINCT so_luong_tra * gia_tra) AS  tongtienhoantra\n" +
"FROM dbo.PHIEUNHAP FULL JOIN dbo.VATTU ON VATTU.id_vt = PHIEUNHAP.id_vt\n" +
"FULL JOIN dbo.PHIEUXUAT ON PHIEUXUAT.id_vt = VATTU.id_vt\n" +
"FULL JOIN dbo.PHIEUTRA ON PHIEUTRA.id_vt = VATTU.id_vt\n" +
"WHERE ngay_xuat BETWEEN '"+dateStart+"' AND '"+dateEnd+"'\n" +
"GROUP BY dbo.VATTU.id_vt, ten_vt , loai_vt,don_vi_tinh\n" +
"UNION\n" +
"SELECT dbo.VATTU.id_vt, ten_vt , loai_vt,don_vi_tinh,\n" +
"SUM(DISTINCT so_luong_nhap) AS sln,\n" +
"SUM(DISTINCT so_luong_xuat) AS slx,\n" +
"SUM(DISTINCT so_luong_tra) AS slt,\n" +
"SUM(DISTINCT so_luong_nhap * don_gia_nhap) AS tongtiennhap,\n" +
"SUM(DISTINCT so_luong_xuat * don_gia_xuat) AS tongtienban,\n" +
"SUM(DISTINCT so_luong_tra * gia_tra) AS  tongtienhoantra\n" +
"FROM dbo.PHIEUNHAP FULL JOIN dbo.VATTU ON VATTU.id_vt = PHIEUNHAP.id_vt\n" +
"FULL JOIN dbo.PHIEUXUAT ON PHIEUXUAT.id_vt = VATTU.id_vt\n" +
"FULL JOIN dbo.PHIEUTRA ON PHIEUTRA.id_vt = VATTU.id_vt\n" +
"WHERE ngay_tra BETWEEN '"+dateStart+"' AND '"+dateEnd+"'\n" +
"GROUP BY dbo.VATTU.id_vt, ten_vt , loai_vt,don_vi_tinh";
        List<THONGKE> list = new ArrayList<>();
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                THONGKE tk = new THONGKE();
                tk.setId_vt(rs.getString("id_vt"));
                tk.setTen_vt(rs.getString("ten_vt"));
                tk.setLoai_vt(rs.getString("loai_vt"));
                tk.setDon_vi_tinh(rs.getString("don_vi_tinh"));
                tk.setTong_sln(rs.getInt("sln"));
                tk.setTong_slx(rs.getInt("slx"));
                tk.setTong_slt(rs.getInt("slt"));
                tk.setTong_tn(rs.getLong("tongtiennhap"));
                tk.setTong_tb(rs.getLong("tongtienban"));
                tk.setTong_tht(rs.getLong("tongtienhoantra"));

                list.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
