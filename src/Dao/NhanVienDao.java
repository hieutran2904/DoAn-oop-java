
package Dao;

import Model.NHANVIEN;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;


/**
 *
 * @author Admin
 */
public class NhanVienDao {
    public boolean insert(NHANVIEN nhanvien) throws Exception{
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "INSERT INTO NHANVIEN(id_nv,ho_nv,ten_nv,ngay_sinh,phai,sdt,tai_khoan,mat_khau) VALUES(?,?,?,?,?,?,?,?)";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nhanvien.getId_nv());
            pstmt.setString(2, nhanvien.getHo_nv());
            pstmt.setString(3, nhanvien.getTen_nv());
            pstmt.setString(4, nhanvien.getNgay_sinh());
            pstmt.setString(5, nhanvien.getPhai());
            pstmt.setString(6, nhanvien.getStd());
            pstmt.setString(7, nhanvien.getTai_khoan());
            pstmt.setString(8, nhanvien.getMat_khau());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; 
    }
    
    public boolean update(NHANVIEN nhanvien) throws Exception{
        String sql = "UPDATE NHANVIEN SET ho_nv = ?,ten_nv = ?,ngay_sinh = ?, phai = ?, sdt = ? WHERE id_nv = ?";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(6, nhanvien.getId_nv());
            pstmt.setString(1, nhanvien.getHo_nv());
            pstmt.setString(2, nhanvien.getTen_nv());
            pstmt.setString(3, nhanvien.getNgay_sinh());
            pstmt.setString(4, nhanvien.getPhai());
            pstmt.setString(5, nhanvien.getStd());
            return pstmt.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; 
    }
    
    public boolean delete(String id_nv) throws Exception{
        String sql = "DELETE FROM NHANVIEN WHERE id_nv = ?  AND id_nv NOT IN (SELECT id_nv FROM dbo.PHIEUTRA UNION SELECT id_nv FROM dbo.PHIEUNHAP UNION SELECT id_nv FROM dbo.PHIEUXUAT) AND id_nv NOT LIKE 'ad%'";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id_nv);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public NHANVIEN findByID(String id){
        String sql = "SELECT * FROM dbo.NHANVIEN WHERE id_nv = ?";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                NHANVIEN nhanvien = new NHANVIEN();
                nhanvien.setId_nv(rs.getString("id_nv"));
                nhanvien.setHo_nv(rs.getString("ho_nv"));
                nhanvien.setTen_nv(rs.getString("ten_nv"));
                nhanvien.setNgay_sinh(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("ngay_sinh")));
                nhanvien.setPhai(rs.getString("phai"));
                nhanvien.setStd(rs.getString("sdt"));
                nhanvien.setTai_khoan(rs.getString("tai_khoan"));
                nhanvien.setMat_khau(rs.getString("mat_khau"));
                return nhanvien;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<NHANVIEN> findAll(String key) throws Exception{
        String sql = "SELECT * FROM NHANVIEN WHERE id_nv LIKE'%"+key+"%' OR ten_nv LIKE N'%"+key+"%'";
        List<NHANVIEN> list = new ArrayList<>();
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                NHANVIEN nhanvien = new NHANVIEN();
                nhanvien.setId_nv(rs.getString("id_nv"));
                nhanvien.setHo_nv(rs.getString("ho_nv"));
                nhanvien.setTen_nv(rs.getString("ten_nv"));
                nhanvien.setNgay_sinh(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("ngay_sinh")));
                nhanvien.setPhai(rs.getString("phai"));
                nhanvien.setStd(rs.getString("sdt"));
                nhanvien.setTai_khoan(rs.getString("tai_khoan"));
                nhanvien.setMat_khau(rs.getString("mat_khau"));
                
                list.add(nhanvien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public NHANVIEN Login(String tk, String mk){
        String sql = "SELECT * FROM dbo.NHANVIEN WHERE tai_khoan LIKE '"+tk+"' AND mat_khau LIKE '"+mk+"'";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                NHANVIEN nhanvien = new NHANVIEN();
                nhanvien.setId_nv(rs.getString("id_nv"));
                nhanvien.setHo_nv(rs.getString("ho_nv"));
                nhanvien.setTen_nv(rs.getString("ten_nv"));
                nhanvien.setTai_khoan(rs.getString("tai_khoan"));
                nhanvien.setMat_khau(rs.getString("mat_khau"));
                return nhanvien;
            }
        } catch (Exception e) {
        }
        return null;
    }
    public boolean changePassword(NHANVIEN nhanvien) throws Exception{
        String sql = "UPDATE NHANVIEN SET mat_khau = ? WHERE id_nv = ?";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nhanvien.getMat_khau());            
            pstmt.setString(2, nhanvien.getId_nv());
            return pstmt.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; 
    }
}
