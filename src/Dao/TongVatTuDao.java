/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Group.TONGVATTU;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Admin
 */
public class TongVatTuDao {
    public List<TONGVATTU> findAll() throws Exception{
        String sql = "SELECT dbo.VATTU.id_vt, ten_vt, \n" +
"SUM(DISTINCT dbo.PHIEUNHAP.so_luong_nhap) AS sln, \n" +
"SUM(DISTINCT dbo.PHIEUXUAT.so_luong_xuat) AS slx, \n" +
"SUM(DISTINCT dbo.PHIEUTRA.so_luong_tra) AS slt\n" +
"FROM dbo.PHIEUNHAP FULL OUTER JOIN\n" +
"dbo.VATTU ON dbo.PHIEUNHAP.id_vt = dbo.VATTU.id_vt FULL OUTER JOIN\n" +
"dbo.PHIEUTRA ON dbo.VATTU.id_vt = dbo.PHIEUTRA.id_vt FULL OUTER JOIN\n" +
"dbo.PHIEUXUAT ON dbo.VATTU.id_vt = dbo.PHIEUXUAT.id_vt\n" +
"GROUP BY dbo.VATTU.id_vt, ten_vt\n" +
"ORDER BY dbo.VATTU.id_vt";
        List<TONGVATTU> list = new ArrayList<>();
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                TONGVATTU ttv = new TONGVATTU();
                ttv.setId_vt(rs.getString("id_vt"));
                ttv.setTen_vt(rs.getString("ten_vt"));
                ttv.setTong_sln(rs.getInt("sln"));
                ttv.setTong_slx(rs.getInt("slx"));
                ttv.setTong_slt(rs.getInt("slt"));
                list.add(ttv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public TONGVATTU checkSL(String id_vt) throws Exception{
        String sql = "SELECT dbo.VATTU.id_vt, ten_vt, \n" +
"SUM(DISTINCT dbo.PHIEUNHAP.so_luong_nhap) AS sln, \n" +
"SUM(DISTINCT dbo.PHIEUXUAT.so_luong_xuat) AS slx, \n" +
"SUM(DISTINCT dbo.PHIEUTRA.so_luong_tra) AS slt\n" +
"FROM dbo.PHIEUNHAP FULL OUTER JOIN\n" +
"dbo.VATTU ON dbo.PHIEUNHAP.id_vt = dbo.VATTU.id_vt FULL OUTER JOIN\n" +
"dbo.PHIEUTRA ON dbo.VATTU.id_vt = dbo.PHIEUTRA.id_vt FULL OUTER JOIN\n" +
"dbo.PHIEUXUAT ON dbo.VATTU.id_vt = dbo.PHIEUXUAT.id_vt\n" +
"WHERE VATTU.id_vt LIKE '%"+id_vt+"%'"+
"GROUP BY dbo.VATTU.id_vt, ten_vt\n" +
"ORDER BY dbo.VATTU.id_vt";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                TONGVATTU ttv = new TONGVATTU();
                ttv.setTong_sln(rs.getInt("sln"));
                ttv.setTong_slx(rs.getInt("slx"));
                ttv.setTong_slt(rs.getInt("slt"));
                return ttv;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
