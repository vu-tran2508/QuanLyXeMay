/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import poly.edu.entity.SanPham;
import poly.edu.helper.JdbcHelper;

/**
 *
 * @author pdo18
 */
public class SanPhamDAO extends DAO<SanPham, Object>{
    String INSERT_SQL="INSERT INTO ThongTinXe(TenXe,TenHang,TenMau,SoMay,Gia,TenLoai,SoKhung,DungTich,SoLuong,Hinh) VALUES(?,?,?,?,?,?,?,?,?,?)";
    String UPDATE_SQL="UPDATE ThongTinXe SET TenXe=?,TenHang=?,TenMau=? ,SoMay =? ,Gia= ?,TenLoai = ?,SoKhung = ?,DungTich = ?,SoLuong=?,Hinh=? WHERE MaXe = ? ";
    String DELETE_SQL =" DELETE FROM ThongTinXe WHERE MaXe=? ";
    String SELECT_ALL_SQL=" SELECT*FROM ThongTinXe";
    String SELECT_BY_ID_SQL=" SELECT * FROM ThongTinXe WHERE MaXe=?";
    @Override
    public void insert(SanPham entity) {
    JdbcHelper.update(INSERT_SQL,entity.getTenXe(),entity.getTenHang(),entity.getTenMau(),
            entity.getSoMay(),entity.getGia(),entity.getLoaiXe(),entity.getSoKhung(),entity.getDungTich(),entity.getSoLuong(),entity.getHinh());
    }

    @Override
    public void update(SanPham entity) {
    JdbcHelper.update(UPDATE_SQL,entity.getTenXe(),entity.getTenHang(),entity.getTenMau(),
            entity.getSoMay(),entity.getGia(),entity.getLoaiXe(),entity.getSoKhung(),entity.getDungTich(),entity.getSoLuong(),entity.getHinh(),entity.getMaXe());
    }

    @Override
    public void delete(Object id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public SanPham selectById(Object id) {
        List<SanPham> list =this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<SanPham> selectAll() {
     return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<SanPham> selectBySql(String sql, Object... args) {
    List<SanPham> list = new ArrayList<SanPham>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
              SanPham entity = new SanPham();
              entity.setMaXe(rs.getInt("MaXe"));
              entity.setTenXe(rs.getString("TenXe"));
              entity.setTenHang(rs.getString("TenHang"));
              entity.setTenMau(rs.getString("TenMau"));
              entity.setSoMay(rs.getString("SoMay"));
              entity.setGia(rs.getFloat("Gia"));
              entity.setLoaiXe(rs.getString("TenLoai"));
              entity.setSoKhung(rs.getString("SoKhung"));
              entity.setDungTich(rs.getString("DungTich"));
              entity.setSoLuong(rs.getInt("SoLuong"));
              entity.setHinh(rs.getString("Hinh"));
              list.add(entity);
                
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
