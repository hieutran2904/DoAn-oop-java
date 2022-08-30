/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Dao.KhachHangDao;
import Dao.VatTuDao;
import Model.KHACHHANG;
import Model.VATTU;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class testdate {
    String CreateID() throws Exception{
        List<VATTU> list = new VatTuDao().findAll("");  
        int index = list.size()-1;
        VATTU vt = list.get(index);
        int idNumber = Integer.parseInt(vt.getId_kho().substring(2)) + 1; //id next        
        if (idNumber < 10) {
            return "vt"+String.valueOf(idNumber);
        }
        else if (idNumber >= 10 && idNumber <100) {
            return "vt"+String.valueOf(idNumber);
        }
        return "vt"+String.valueOf(idNumber);
    }
    public static void main(String[] args) throws Exception {
        List<KHACHHANG> list = new KhachHangDao().findAll();  
        int index = list.size()-1;
        KHACHHANG kh = list.get(index);
        int idNumber = Integer.parseInt(kh.getId_kh().substring(3)) + 1;
        System.out.println(idNumber);
        System.out.println("String: "+kh.getId_kh().substring(2));
    }
}
