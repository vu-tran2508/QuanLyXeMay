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
import poly.edu.helper.JdbcHelper;

/**
 *
 * @author pdo18
 */
public class HoaDonDAO extends DAO<HoaDon, Object>{
    String INSERT_SQL="INSERT INTO HoaDon (MaNV,MaKH,NgayLap,TongTien) VALUES(?,?,?,?)";
    String UPDATE_SQL="UPDATE HoaDon SET MaNV=?,MaKH=?,NgayLap=? , TongTien=? WHERE MaHD = ? ";
    String DELETE_SQL =" DELETE FROM HoaDon WHERE MaHD=? ";
    String SELECT_ALL_SQL=" SELECT*FROM HoaDon";
    String SELECT_BY_ID_SQL=" SELECT * FROM HoaDon WHERE MaHD= ?";

    @Override
    public void insert(HoaDon entity) {
        JdbcHelper.update(INSERT_SQL,entity.getMaNV(),entity.getMaKH(),entity.getNgayLap()
        ,entity.getTongTien());
    }

    @Override
    public void update(HoaDon entity) {
    JdbcHelper.update(UPDATE_SQL,entity.getMaNV(),entity.getMaKH(),entity.getNgayLap()
        ,entity.getTongTien());  
    }

    @Override
    public void delete(Object id) {
        JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public HoaDon selectById(Object id) {
        List<HoaDon> list =this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDon> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<HoaDon> selectBySql(String sql, Object... args) {
     List<HoaDon> list = new ArrayList<HoaDon>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
              HoaDon entity = new HoaDon();
              entity.setMaHD(rs.getInt("MaHD"));
              entity.setMaNV(rs.getString("MaNV"));
              entity.setMaKH(rs.getString("MaKH"));
              entity.setNgayLap(rs.getDate("NgayLap"));
              entity.setTongTien(rs.getFloat("TongTien"));
              list.add(entity);
                
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
