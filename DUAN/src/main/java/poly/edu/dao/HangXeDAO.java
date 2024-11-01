/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import poly.edu.entity.HangXe;
import poly.edu.helper.JdbcHelper;

/**
 *
 * @author pdo18
 */
public class HangXeDAO extends DAO<HangXe, Object>{

String INSERT_SQL="INSERT INTO HangXe(MaHang,TenHang,ThongTinHang) VALUES(?,?,?)";
    String UPDATE_SQL="UPDATE HangXe SET TenHang=?,ThongTinHang = ? WHERE MaHang = ? ";
    String DELETE_SQL =" DELETE FROM HangXe WHERE MaHang=? ";
    String SELECT_ALL_SQL=" SELECT*FROM HangXe";
    String SELECT_BY_ID_SQL=" SELECT * FROM HangXe WHERE MaHang=?";

    @Override
    public void insert(HangXe entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaHang(),entity.getTenHang(),entity.getThongtinhang());
    }

    @Override
    public void update(HangXe entity) {
    JdbcHelper.update(UPDATE_SQL,entity.getTenHang(),entity.getThongtinhang(), entity.getMaHang());
    }

    @Override
    public void delete(Object id) {
        JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public HangXe selectById(Object id) {
        List<HangXe> list =this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HangXe> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<HangXe> selectBySql(String sql, Object... args) {
     List<HangXe> list = new ArrayList<HangXe>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
              HangXe entity = new HangXe();
              entity.setMaHang(rs.getString("MaHang"));
              entity.setTenHang(rs.getString("TenHang"));
              entity.setThongtinhang(rs.getString("ThongTinHang"));
              list.add(entity);
                
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }    
}