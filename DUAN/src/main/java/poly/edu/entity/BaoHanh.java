/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.entity;

import java.util.Date;

/**
 *
 * @author pdo18
 */
public class BaoHanh {
    String MaBH,MaNV,MaKH;
    int MaXe;
    Date NgayMua, NgayHH;

    public String getMaBH() {
        return MaBH;
    }

    public void setMaBH(String MaBH) {
        this.MaBH = MaBH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public int getMaXe() {
        return MaXe;
    }

    public void setMaXe(int MaXe) {
        this.MaXe = MaXe;
    }

    public Date getNgayMua() {
        return NgayMua;
    }

    public void setNgayMua(Date NgayMua) {
        this.NgayMua = NgayMua;
    }

    public Date getNgayHH() {
        return NgayHH;
    }

    public void setNgayHH(Date NgayHH) {
        this.NgayHH = NgayHH;
    }
    
}
