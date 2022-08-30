/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.KHACHHANG;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class KhachHangDao {
    public boolean insert(KHACHHANG kh) throws Exception{
        String sql = "INSERT INTO KHACHHANG(id_kh,ho_ten_kh,phai,sdt) VALUES(?,?,?,?)";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, kh.getId_kh());
            pstmt.setString(2, kh.getHo_ten_hk());
            pstmt.setString(3, kh.getPhai());
            pstmt.setString(4, kh.getStd());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; 
    }
    
    public boolean update(KHACHHANG kh) throws Exception{
        String sql = "UPDATE KHACHHANG SET ho_ten_kh = ? , phai = ? , sdt = ? WHERE id_kh = ?";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(4, kh.getId_kh());
            pstmt.setString(1, kh.getHo_ten_hk());
            pstmt.setString(2, kh.getPhai());
            pstmt.setString(3, kh.getStd());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; 
    }
    
    public boolean delete(String id_kh) throws Exception{
        String sql = "DELETE FROM dbo.KHACHHANG WHERE id_kh = ? AND id_kh NOT IN (SELECT id_kh FROM dbo.PHIEUXUAT)";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id_kh);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public KHACHHANG findByID(String id){
        String sql = "SELECT * FROM KHACHHANG WHERE id_kh = ?";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                KHACHHANG kh = new KHACHHANG();
                kh.setId_kh(rs.getString("id_kh"));
                kh.setHo_ten_hk(rs.getString("ho_ten_kh"));
                kh.setPhai(rs.getString("phai"));
                kh.setStd(rs.getString("sdt"));
                return kh;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<KHACHHANG> findAll() throws Exception{
        String sql = "SELECT * FROM KHACHHANG";
        List<KHACHHANG> list = new ArrayList<>();
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                KHACHHANG kh = new KHACHHANG();
                kh.setId_kh(rs.getString("id_kh"));
                kh.setHo_ten_hk(rs.getString("ho_ten_kh"));
                kh.setPhai(rs.getString("phai"));
                kh.setStd(rs.getString("sdt"));
                
                list.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
