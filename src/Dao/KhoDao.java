/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.KHO;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class KhoDao {
    public boolean insert(KHO kho) throws Exception{
        String sql = "INSERT INTO KHO(id_kho,ten_kho,loai_kho,dia_chi) VALUES(?,?,?,?)";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, kho.getId_kho());
            pstmt.setString(2, kho.getTen_kho());
            pstmt.setString(3, kho.getLoai_kho());
            pstmt.setString(4, kho.getDia_chi());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; 
    }
    
    public boolean update(KHO kho) throws Exception{
        String sql = "UPDATE KHO SET ten_kho = ? , loai_kho = ? , dia_chi = ? WHERE id_kho = ?";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(4, kho.getId_kho());
            pstmt.setString(1, kho.getTen_kho());
            pstmt.setString(2, kho.getLoai_kho());
            pstmt.setString(3, kho.getDia_chi());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; 
    }
    
    public boolean delete(String id_kho) throws Exception{
        String sql = "DELETE FROM dbo.KHO WHERE id_kho = ? AND id_kho NOT IN (SELECT id_kho FROM dbo.VATTU)";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id_kho);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public KHO findByID(String id){
        String sql = "SELECT * FROM KHO WHERE id_kho = ?";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                KHO kho = new KHO();
                kho.setId_kho(rs.getString("id_kho"));
                kho.setTen_kho(rs.getString("ten_kho"));
                kho.setLoai_kho(rs.getString("loai_kho"));
                kho.setDia_chi(rs.getString("dia_chi"));
                return kho;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<KHO> findAll() throws Exception{
        String sql = "SELECT * FROM KHO";
        List<KHO> list = new ArrayList<>();
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                KHO kho = new KHO();
                kho.setId_kho(rs.getString("id_kho"));
                kho.setTen_kho(rs.getString("ten_kho"));
                kho.setLoai_kho(rs.getString("loai_kho"));
                kho.setDia_chi(rs.getString("dia_chi"));
                
                list.add(kho);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
