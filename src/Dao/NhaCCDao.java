/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.NHACC;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class NhaCCDao {
    public boolean insert(NHACC nhacc) throws Exception{
        String sql = "INSERT INTO NHACUNGCAP(id_nhacc,ten_nhacc,dia_chi,sdt) VALUES(?,?,?,?)";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nhacc.getId_nhacc());
            pstmt.setString(2, nhacc.getTen_nhacc());
            pstmt.setString(3, nhacc.getDia_chi());
            pstmt.setString(4, nhacc.getSdt());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; 
    }
    
    public boolean update(NHACC nhacc) throws Exception{
        String sql = "UPDATE NHACUNGCAP SET ten_nhacc = ? , dia_chi = ? , sdt = ? WHERE id_nhacc = ?";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(4, nhacc.getId_nhacc());
            pstmt.setString(1, nhacc.getTen_nhacc());
            pstmt.setString(2, nhacc.getDia_chi());
            pstmt.setString(3, nhacc.getSdt());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; 
    }
    
    public boolean delete(String id_nhacc) throws Exception{
        String sql = "DELETE FROM dbo.NHACUNGCAP WHERE id_nhacc = ? AND id_nhacc NOT IN (SELECT id_nhacc FROM dbo.PHIEUNHAP)";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id_nhacc);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public NHACC findByID(String id){
        String sql = "SELECT * FROM NHACUNGCAP WHERE id_NHACC = ?";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                NHACC nhacc = new NHACC();
                nhacc.setId_nhacc(rs.getString("id_nhacc"));
                nhacc.setTen_nhacc(rs.getString("ten_nhacc"));
                nhacc.setDia_chi(rs.getString("dia_chi"));
                nhacc.setSdt(rs.getString("sdt"));
                return nhacc;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<NHACC> findAll() throws Exception{
        String sql = "SELECT * FROM NHACUNGCAP";
        List<NHACC> list = new ArrayList<>();
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                NHACC nhacc = new NHACC();
                nhacc.setId_nhacc(rs.getString("id_nhacc"));
                nhacc.setTen_nhacc(rs.getString("ten_nhacc"));
                nhacc.setDia_chi(rs.getString("dia_chi"));
                nhacc.setSdt(rs.getString("sdt"));
                
                list.add(nhacc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
