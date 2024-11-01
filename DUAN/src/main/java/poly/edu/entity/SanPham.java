/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.entity;

/**
 *
 * @author pdo18
 */
public class SanPham {
    private int MaXe;
    private String TenXe,TenHang,TenMau,SoMay,LoaiXe,SoKhung,DungTich,Hinh;
    private float Gia;
    private int SoLuong;

    @Override
    public String toString() {
        return this.TenXe;
    }



    public int getMaXe() {
        return MaXe;
    }

    public void setMaXe(int MaXe) {
        this.MaXe = MaXe;
    }

    public String getTenXe() {
        return TenXe;
    }

    public void setTenXe(String TenXe) {
        this.TenXe = TenXe;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }

    public String getTenMau() {
        return TenMau;
    }

    public void setTenMau(String TenMau) {
        this.TenMau = TenMau;
    }

    public String getSoMay() {
        return SoMay;
    }

    public void setSoMay(String SoMay) {
        this.SoMay = SoMay;
    }

    public String getLoaiXe() {
        return LoaiXe;
    }

    public void setLoaiXe(String LoaiXe) {
        this.LoaiXe = LoaiXe;
    }

    public String getSoKhung() {
        return SoKhung;
    }

    public void setSoKhung(String SoKhung) {
        this.SoKhung = SoKhung;
    }

    public String getDungTich() {
        return DungTich;
    }

    public void setDungTich(String DungTich) {
        this.DungTich = DungTich;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public float getGia() {
        return Gia;
    }

    public void setGia(float Gia) {
        this.Gia = Gia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getSoLuong(int SoLuongSP) {
        int SL;
       return SL = SoLuongSP - SoLuong; 
    }


}
