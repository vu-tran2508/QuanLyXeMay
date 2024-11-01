/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.entity;

/**
 *
 * @author pdo18
 */
public class LoaiXe {
    private String MaLoai, TenLoai, thongtinloai;

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(String TenLoai) {
        this.TenLoai = TenLoai;
    }

    public String getThongtinloai() {
        return thongtinloai;
    }

    public void setThongtinloai(String thongtinloai) {
        this.thongtinloai = thongtinloai;
    }

    @Override
    public String toString() {
        return this.TenLoai;
    }
    
}
