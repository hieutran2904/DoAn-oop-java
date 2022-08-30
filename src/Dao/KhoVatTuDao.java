/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Group.KHOVT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KhoVatTuDao {
    public List<KHOVT> findAll(String key) throws Exception{
        String sql = "SELECT DISTINCT dbo.VATTU.id_vt , ten_kho, vi_tri_vat_tu, ten_nhacc FROM dbo.VATTU FULL JOIN dbo.KHO ON KHO.id_kho = VATTU.id_kho\n" +
"FULL JOIN dbo.PHIEUNHAP ON PHIEUNHAP.id_vt = VATTU.id_vt\n" +
"FULL JOIN dbo.NHACUNGCAP ON NHACUNGCAP.id_nhacc = PHIEUNHAP.id_nhacc\n" +
"WHERE vi_tri_vat_tu IS NOT NULL AND (VATTU.id_vt LIKE '%"+key+"%' OR vi_tri_vat_tu LIKE '%"+key+"%')";
        List<KHOVT> list = new ArrayList<>();
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                KHOVT khovt = new KHOVT();
                khovt.setId_vt(rs.getString("id_vt"));
                khovt.setTen_kho(rs.getString("ten_kho"));
                khovt.setVi_tri(rs.getString("vi_tri_vat_tu"));
                khovt.setTen_nhacc(rs.getString("ten_nhacc"));

                list.add(khovt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
