/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author Admin
 */
import Model.VATTU;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class VatTuDao {
    public boolean insert(VATTU vattu) throws Exception{
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "INSERT INTO VATTU(id_vt,ten_vt,loai_vt,don_vi_tinh,id_kho) VALUES(?,?,?,?,?)";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vattu.getId_vt());
            pstmt.setString(2, vattu.getTen_vt());
            pstmt.setString(3, vattu.getLoai_vt());
            pstmt.setString(4, vattu.getDon_vi_tinh());
            pstmt.setString(5, vattu.getId_kho());

            
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; 
    }
    
    public boolean update(VATTU vattu) throws Exception{
        String sql = "UPDATE VATTU SET ten_vt = ?,loai_vt = ?,don_vi_tinh = ?, id_kho = ? WHERE id_vt = ?";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(5, vattu.getId_vt());
            pstmt.setString(1, vattu.getTen_vt());
            pstmt.setString(2, vattu.getLoai_vt());
            pstmt.setString(3, vattu.getDon_vi_tinh());
            pstmt.setString(4, vattu.getId_kho());
            return pstmt.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; 
    }
    
    public boolean delete(String id_vt) throws Exception{
        String sql = "DELETE FROM dbo.VATTU WHERE id_vt = ? AND id_vt NOT IN (SELECT id_vt FROM dbo.PHIEUTRA UNION SELECT id_vt FROM dbo.PHIEUNHAP UNION SELECT id_vt FROM dbo.PHIEUXUAT)";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id_vt);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public VATTU findByID(String id){
        String sql = "SELECT * FROM dbo.VATTU WHERE id_vt = ?";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                VATTU vt = new VATTU();
                vt.setId_vt(rs.getString("id_vt"));
                vt.setTen_vt(rs.getString("ten_vt"));
                vt.setLoai_vt(rs.getString("loai_vt"));
                vt.setDon_vi_tinh(rs.getString("don_vi_tinh"));
                vt.setId_kho(rs.getString("id_kho"));
                
                return vt;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<VATTU> findAll(String key) throws Exception{
        String sql = "SELECT * FROM VATTU WHERE id_vt LIKE'%"+key+"%' OR ten_vt LIKE N'%"+key+"%' OR don_vi_tinh LIKE N'%"+key+"%'";
        List<VATTU> list = new ArrayList<>();
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                VATTU vt = new VATTU();
                vt.setId_vt(rs.getString("id_vt"));
                vt.setTen_vt(rs.getString("ten_vt"));
                vt.setLoai_vt(rs.getString("loai_vt"));
                vt.setDon_vi_tinh(rs.getString("don_vi_tinh"));
                vt.setId_kho(rs.getString("id_kho"));
                
                list.add(vt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    // view phieu xuat, phieu tra
    public List<VATTU> findCBX() throws Exception{
        String sql = "SELECT dbo.VATTU.id_vt,\n" +
"SUM(DISTINCT dbo.PHIEUNHAP.so_luong_nhap) AS sln, \n" +
"SUM(DISTINCT dbo.PHIEUXUAT.so_luong_xuat) AS slx, \n" +
"SUM(DISTINCT dbo.PHIEUTRA.so_luong_tra) AS slt\n" +
"FROM dbo.PHIEUNHAP FULL JOIN dbo.VATTU ON VATTU.id_vt = PHIEUNHAP.id_vt\n" +
"FULL JOIN dbo.PHIEUXUAT ON PHIEUXUAT.id_vt = VATTU.id_vt \n" +
"FULL JOIN dbo.PHIEUTRA ON PHIEUTRA.id_vt = VATTU.id_vt\n" +
"GROUP BY dbo.VATTU.id_vt";
        List<VATTU> list = new ArrayList<>();
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                if(rs.getInt("sln") - rs.getInt("slx") - rs.getInt("slt")>0){
                    VATTU vt = new VATTU();
                    vt.setId_vt(rs.getString("id_vt"));
                    list.add(vt);
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
