/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import poly.edu.entity.HoaDon;
import poly.edu.entity.HoaDonCT;
import poly.edu.helper.DiaLogHelper;
import poly.edu.helper.JdbcHelper;

/**
 *
 * @author pdo18
 */
public class HoaDonCTDAO extends DAO<HoaDonCT, Object>{
    String INSERT_SQL="INSERT INTO HoaDonCT (MaHD,MaXe,SoLuong,Gia,TenSP) VALUES((SELECT TOP 1  MaHD FROM HoaDon ORDER BY MaHD DESC),?,?,?,?)";
    String UPDATE_SQL="UPDATE HoaDonCT SET MaXe=?,SoLuong=?,Gia=? ,TenSP = ? WHERE MaHD = ? ";
    String DELETE_SQL =" DELETE FROM HoaDonCT WHERE MaHD=? ";
    String SELECT_ALL_SQL=" SELECT*FROM HoaDonCT";
    String SELECT_BY_ID_SQL=" SELECT * FROM HoaDonCT WHERE MaHD=?";

    @Override
    public void insert(HoaDonCT entity) {
        JdbcHelper.update(INSERT_SQL,entity.getMaSP(),entity.getSoLuong(),entity.getThanhTien(),entity.getTenSP());
    }

    @Override
    public void update(HoaDonCT entity) { 
    }

    @Override
    public void delete(Object id) {
        JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public HoaDonCT selectById(Object id) {

        return null;

    }

    @Override
    public List<HoaDonCT> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<HoaDonCT> selectBySql(String sql, Object... args) {
     List<HoaDonCT> list = new ArrayList<HoaDonCT>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
              HoaDonCT entity = new HoaDonCT();
              entity.setMaHD(rs.getInt("MaHD"));
              entity.setMaSP(rs.getInt("MaXe"));
              entity.setSoLuong(rs.getInt("SoLuong"));
              entity.setThanhTien(rs.getFloat("Gia"));
              entity.setTenSP(rs.getString("TenSP"));
              list.add(entity);
                
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
