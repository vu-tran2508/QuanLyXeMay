/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import poly.edu.entity.LoaiXe;
import poly.edu.helper.JdbcHelper;

/**
 *
 * @author pdo18
 */
public class LoaiXeDAO extends DAO<LoaiXe, Object>{
    String INSERT_SQL="INSERT INTO LoaiXe(MaLoai,TenLoai,ThongTinLoai) VALUES(?,?,?)";
    String UPDATE_SQL="UPDATE LoaiXe SET TenLoai=?,ThongTinLoai=? WHERE MaLoai = ? ";
    String DELETE_SQL =" DELETE FROM LoaiXe WHERE MaLoai=? ";
    String SELECT_ALL_SQL=" SELECT*FROM LoaiXe";
    String SELECT_BY_ID_SQL=" SELECT * FROM LoaiXe WHERE MaLoai=?";

    @Override
    public void insert(LoaiXe entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaLoai(),entity.getTenLoai(),entity.getThongtinloai());
    }

    @Override
    public void update(LoaiXe entity) {
    JdbcHelper.update(UPDATE_SQL,entity.getTenLoai(),entity.getThongtinloai(), entity.getMaLoai());
    }

    @Override
    public void delete(Object id) {
        JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public LoaiXe selectById(Object id) {
        List<LoaiXe> list =this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<LoaiXe> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<LoaiXe> selectBySql(String sql, Object... args) {
     List<LoaiXe> list = new ArrayList<LoaiXe>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
             LoaiXe entity = new LoaiXe();
              entity.setMaLoai(rs.getString("MaLoai"));
              entity.setTenLoai(rs.getString("TenLoai"));
              entity.setThongtinloai(rs.getString("ThongTinLoai"));
              list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
