
package Dao;

import Model.PHIEUXUAT;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class PhieuXuatDao {
    public boolean insert(PHIEUXUAT px) throws Exception{
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "INSERT INTO PHIEUXUAT(id_px,id_vt,id_nv,id_kh,ngay_xuat,so_luong_xuat,don_gia_xuat) VALUES(?,?,?,?,?,?,?)";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, px.getId_px());
            pstmt.setString(2, px.getId_vt());
            pstmt.setString(3, px.getId_nv());
            pstmt.setString(4, px.getId_kh());
            pstmt.setString(5, px.getNgay_xuat());
            pstmt.setInt(6, px.getSo_luong_xuat());
            pstmt.setFloat(7, px.getDon_gia_xuat());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; 
    }
    
    public boolean update(PHIEUXUAT px) throws Exception{
        String sql = "UPDATE PHIEUXUAT SET id_vt = ?,id_nv = ?,id_kh = ?,ngay_xuat = ?,so_luong_xuat = ?,don_gia_xuat = ? WHERE id_px = ?";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(7, px.getId_px());
            pstmt.setString(1, px.getId_vt());
            pstmt.setString(2, px.getId_nv());
            pstmt.setString(3, px.getId_kh());
            pstmt.setString(4, px.getNgay_xuat());
            pstmt.setInt(5, px.getSo_luong_xuat());
            pstmt.setFloat(6, px.getDon_gia_xuat());
            return pstmt.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; 
    }
    
    public boolean delete(String id_px) throws Exception{
        String sql = "DELETE FROM PHIEUXUAT WHERE id_px = ?";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id_px);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public PHIEUXUAT findByID(String id){
        String sql = "SELECT * FROM dbo.PHIEUXUAT WHERE id_px LIKE ?";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                PHIEUXUAT px = new PHIEUXUAT();
                px.setId_px(rs.getString("id_px"));
                px.setId_vt(rs.getString("id_vt"));
                px.setId_nv(rs.getString("id_nv"));
                px.setId_kh(rs.getString("id_kh"));
                px.setNgay_xuat(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("ngay_xuat")));
                px.setSo_luong_xuat(rs.getInt("so_luong_xuat"));
                px.setDon_gia_xuat(rs.getFloat("don_gia_xuat"));
                return px;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<PHIEUXUAT> findAll(String key) throws Exception{
        String sql = "SELECT * FROM PHIEUXUAT WHERE id_px LIKE'%"+key+"%' OR id_vt LIKE'%"+key+"%' OR id_nv LIKE'%"+key+"%' OR ngay_xuat LIKE '%"+key+"%'";
        List<PHIEUXUAT> list = new ArrayList<>();
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                PHIEUXUAT px = new PHIEUXUAT();
                px.setId_px(rs.getString("id_px"));
                px.setId_vt(rs.getString("id_vt"));
                px.setId_nv(rs.getString("id_nv"));
                px.setId_kh(rs.getString("id_kh"));
                px.setNgay_xuat(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("ngay_xuat")));
                px.setSo_luong_xuat(rs.getInt("so_luong_xuat"));
                px.setDon_gia_xuat(rs.getFloat("don_gia_xuat"));
                list.add(px);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
