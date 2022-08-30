/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Group.TKNV;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ThongKeNVDAO {
    public List<TKNV> findAll(String key,String dateStart, String dateEnd) throws Exception{
        String sql = "SELECT DISTINCT dbo.NHANVIEN.id_nv, CONCAT_WS(' ',ho_nv,ten_nv) AS hoten,\n" +
"COUNT(DISTINCT id_pn) AS pn,\n" +
"COUNT(DISTINCT id_px) AS px,\n" +
"COUNT(DISTINCT id_pt) AS pt\n" +
"FROM dbo.NHANVIEN FULL JOIN dbo.PHIEUNHAP ON PHIEUNHAP.id_nv = NHANVIEN.id_nv\n" +
"FULL JOIN dbo.PHIEUXUAT ON PHIEUXUAT.id_nv = NHANVIEN.id_nv\n" +
"FULL JOIN dbo.PHIEUTRA ON PHIEUTRA.id_nv = NHANVIEN.id_nv\n" +
//"WHERE ngay_nhap BETWEEN '"+dateStart+"' AND '"+dateEnd+"' \n" +
"WHERE ngay_nhap BETWEEN '"+dateStart+"' AND '"+dateEnd+"' AND NHANVIEN.id_nv LIKE'%"+key+"%'\n" +
"GROUP BY dbo.NHANVIEN.id_nv, CONCAT_WS(' ',ho_nv,ten_nv)\n" +
"UNION\n" +
"SELECT DISTINCT dbo.NHANVIEN.id_nv, CONCAT_WS(' ',ho_nv,ten_nv) AS hoten,\n" +
"COUNT(DISTINCT id_pn) AS pn,\n" +
"COUNT(DISTINCT id_px) AS px,\n" +
"COUNT(DISTINCT id_pt) AS pt\n" +
"FROM dbo.NHANVIEN FULL JOIN dbo.PHIEUNHAP ON PHIEUNHAP.id_nv = NHANVIEN.id_nv\n" +
"FULL JOIN dbo.PHIEUXUAT ON PHIEUXUAT.id_nv = NHANVIEN.id_nv\n" +
"FULL JOIN dbo.PHIEUTRA ON PHIEUTRA.id_nv = NHANVIEN.id_nv\n" +
"WHERE ngay_xuat BETWEEN '"+dateStart+"' AND '"+dateEnd+"' AND NHANVIEN.id_nv LIKE'%"+key+"%' \n" +
"GROUP BY dbo.NHANVIEN.id_nv, CONCAT_WS(' ',ho_nv,ten_nv)\n" +
"UNION\n" +
"SELECT DISTINCT dbo.NHANVIEN.id_nv, CONCAT_WS(' ',ho_nv,ten_nv) AS hoten,\n" +
"COUNT(DISTINCT id_pn) AS pn,\n" +
"COUNT(DISTINCT id_px) AS px,\n" +
"COUNT(DISTINCT id_pt) AS pt\n" +
"FROM dbo.NHANVIEN FULL JOIN dbo.PHIEUNHAP ON PHIEUNHAP.id_nv = NHANVIEN.id_nv\n" +
"FULL JOIN dbo.PHIEUXUAT ON PHIEUXUAT.id_nv = NHANVIEN.id_nv\n" +
"FULL JOIN dbo.PHIEUTRA ON PHIEUTRA.id_nv = NHANVIEN.id_nv\n" +
"WHERE ngay_tra BETWEEN '"+dateStart+"' AND '"+dateEnd+"' AND NHANVIEN.id_nv LIKE'%"+key+"%' \n" +
"GROUP BY dbo.NHANVIEN.id_nv, CONCAT_WS(' ',ho_nv,ten_nv)";

        List<TKNV> list = new ArrayList<>();
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                TKNV tknv = new TKNV();
                tknv.setId_nv(rs.getString("id_nv"));
                tknv.setHo_ten(rs.getString("hoten"));
                tknv.setSln(rs.getInt("pn"));
                tknv.setSlx(rs.getInt("px"));
                tknv.setSlt(rs.getInt("pt"));

                list.add(tknv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
