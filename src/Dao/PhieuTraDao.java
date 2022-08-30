
package Dao;

import Model.PHIEUTRA;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class PhieuTraDao {
    public boolean insert(PHIEUTRA pt) throws Exception{
        
        String sql = "INSERT INTO PHIEUTRA(id_pt,id_vt,id_nv,ngay_tra,so_luong_tra,gia_tra,ghi_chu) VALUES(?,?,?,?,?,?,?)";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pt.getId_pt());
            pstmt.setString(2, pt.getId_vt());
            pstmt.setString(3, pt.getId_nv());
            pstmt.setString(4, pt.getNgay_tra());
            pstmt.setInt(5, pt.getSo_luong_tra());
            pstmt.setFloat(6, pt.getGia_tra());
            pstmt.setString(7, pt.getGhi_chu());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; 
    }
    
    public boolean update(PHIEUTRA pt) throws Exception{
        String sql = "UPDATE PHIEUTRA SET id_vt = ?,id_nv = ?,ngay_tra = ?,so_luong_tra = ?,gia_tra = ?,ghi_chu = ? WHERE id_pt = ?";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(7, pt.getId_pt());
            pstmt.setString(1, pt.getId_vt());
            pstmt.setString(2, pt.getId_nv());
            pstmt.setString(3, pt.getNgay_tra());
            pstmt.setInt(4, pt.getSo_luong_tra());
            pstmt.setFloat(5, pt.getGia_tra());
            pstmt.setString(6, pt.getGhi_chu());

            return pstmt.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; 
    }
    
    public boolean delete(String id_pt) throws Exception{
        String sql = "DELETE FROM PHIEUTRA WHERE id_pt = ?";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id_pt);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public PHIEUTRA findByID(String id){
        String sql = "SELECT * FROM dbo.PHIEUTRA WHERE id_pt LIKE ?";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                PHIEUTRA pt = new PHIEUTRA();
                pt.setId_pt(rs.getString("id_pt"));
                pt.setId_vt(rs.getString("id_vt"));
                pt.setId_nv(rs.getString("id_nv"));
                pt.setNgay_tra(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("ngay_tra")));
                pt.setSo_luong_tra(rs.getInt("so_luong_tra"));
                pt.setGia_tra(rs.getFloat("gia_tra"));
                pt.setGhi_chu(rs.getString("ghi_chu"));
                return pt;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<PHIEUTRA> findAll(String key) throws Exception{
        String sql = "SELECT * FROM PHIEUTRA WHERE id_pt LIKE'%"+key+"%' OR id_vt LIKE'%"+key+"%' OR id_nv LIKE'%"+key+"%' OR ngay_tra LIKE '%"+key+"%'";
        List<PHIEUTRA> list = new ArrayList<>();
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                PHIEUTRA pt = new PHIEUTRA();
                pt.setId_pt(rs.getString("id_pt"));
                pt.setId_vt(rs.getString("id_vt"));
                pt.setId_nv(rs.getString("id_nv"));
                pt.setNgay_tra(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("ngay_tra")));
                pt.setSo_luong_tra(rs.getInt("so_luong_tra"));
                pt.setGia_tra(rs.getFloat("gia_tra"));
                pt.setGhi_chu(rs.getString("ghi_chu"));
                list.add(pt);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
