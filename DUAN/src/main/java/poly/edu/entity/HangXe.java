/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.entity;

/**
 *
 * @author pdo18
 */
public class HangXe {
    private String MaHang, TenHang, thongtinhang;

    @Override
    public String toString() {
        return this.TenHang;
    }

    
    public String getMaHang() {
        return MaHang;
    }

    public void setMaHang(String MaHang) {
        this.MaHang = MaHang;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }

    public String getThongtinhang() {
        return thongtinhang;
    }

    public void setThongtinhang(String thongtinhang) {
        this.thongtinhang = thongtinhang;
    }
}
