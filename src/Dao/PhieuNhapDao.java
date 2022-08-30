/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.PHIEUNHAP;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class PhieuNhapDao {
    public boolean insert(PHIEUNHAP pn) throws Exception{
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "INSERT INTO PHIEUNHAP(id_pn,id_vt,id_nhacc,id_nv,ngay_nhap,so_luong_nhap,don_gia_nhap,vi_tri_vat_tu) VALUES(?,?,?,?,?,?,?,?)";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pn.getId_pn());
            pstmt.setString(2, pn.getId_vt());
            pstmt.setString(3, pn.getId_nhacc());
            pstmt.setString(4, pn.getId_nv());
            pstmt.setString(5, pn.getNgay_nhap());
            pstmt.setInt(6, pn.getSo_luong_nhap());
            pstmt.setFloat(7, pn.getDon_gia_nhap());
            pstmt.setString(8, pn.getVi_tri_vat_tu());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; 
    }
    
    public boolean update(PHIEUNHAP pn) throws Exception{
        String sql = "UPDATE PHIEUNHAP SET id_vt = ?,id_nhacc = ?,id_nv = ?,ngay_nhap = ?,so_luong_nhap = ?,don_gia_nhap = ?,vi_tri_vat_tu = ? WHERE id_pn = ?";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(8, pn.getId_pn());
            pstmt.setString(1, pn.getId_vt());
            pstmt.setString(2, pn.getId_nhacc());
            pstmt.setString(3, pn.getId_nv());
            pstmt.setString(4, pn.getNgay_nhap());
            pstmt.setInt(5, pn.getSo_luong_nhap());
            pstmt.setFloat(6, pn.getDon_gia_nhap());
            pstmt.setString(7, pn.getVi_tri_vat_tu());
            return pstmt.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; 
    }
    
    public boolean delete(String id_pn) throws Exception{
        String sql = "DELETE FROM PHIEUNHAP WHERE id_pn = ?";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id_pn);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public PHIEUNHAP findByID(String id){
        String sql = "SELECT * FROM dbo.PHIEUNHAP WHERE id_pn LIKE ?";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                PHIEUNHAP pn = new PHIEUNHAP();
                pn.setId_pn(rs.getString("id_pn"));
                pn.setId_vt(rs.getString("id_vt"));
                pn.setId_nhacc(rs.getString("id_nhacc"));
                pn.setId_nv(rs.getString("id_nv"));
                pn.setNgay_nhap(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("ngay_nhap")));
                pn.setSo_luong_nhap(rs.getInt("so_luong_nhap"));
                pn.setDon_gia_nhap(rs.getFloat("don_gia_nhap"));
                pn.setVi_tri_vat_tu(rs.getString("vi_tri_vat_tu"));
                return pn;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<PHIEUNHAP> findAll(String key) throws Exception{
        String sql = "SELECT * FROM PHIEUNHAP WHERE id_pn LIKE'%"+key+"%' OR id_vt LIKE'%"+key+"%' OR id_nv LIKE '"+key+"' OR ngay_nhap LIKE '%"+key+"%'";
        List<PHIEUNHAP> list = new ArrayList<>();
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                PHIEUNHAP pn = new PHIEUNHAP();
                pn.setId_pn(rs.getString("id_pn"));
                pn.setId_vt(rs.getString("id_vt"));
                pn.setId_nhacc(rs.getString("id_nhacc"));
                pn.setId_nv(rs.getString("id_nv"));
                pn.setNgay_nhap(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("ngay_nhap")));
                pn.setSo_luong_nhap(rs.getInt("so_luong_nhap"));
                pn.setDon_gia_nhap(rs.getFloat("don_gia_nhap"));
                pn.setVi_tri_vat_tu(rs.getString("vi_tri_vat_tu"));
                list.add(pn);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
