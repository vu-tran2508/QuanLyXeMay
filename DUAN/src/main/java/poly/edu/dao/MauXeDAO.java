/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import poly.edu.entity.MauXe;
import poly.edu.helper.JdbcHelper;

/**
 *
 * @author pdo18
 */
public class MauXeDAO extends DAO<MauXe, Object>{
    String INSERT_SQL="INSERT INTO MauXe(MaMau,TenMau) VALUES(?,?)";
    String UPDATE_SQL="UPDATE MauXe SET TenMau=? WHERE MaMau = ? ";
    String DELETE_SQL =" DELETE FROM MauXe WHERE MaMau=? ";
    String SELECT_ALL_SQL=" SELECT*FROM MauXe";
    String SELECT_BY_ID_SQL=" SELECT * FROM MauXe WHERE MaMau=?";

    @Override
    public void insert(MauXe entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaMau(),entity.getMauXe());
    }

    @Override
    public void update(MauXe entity) {
    JdbcHelper.update(UPDATE_SQL,entity.getMauXe(), entity.getMaMau());
    }

    @Override
    public void delete(Object id) {
        JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public MauXe selectById(Object id) {
        List<MauXe> list =this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<MauXe> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<MauXe> selectBySql(String sql, Object... args) {
     List<MauXe> list = new ArrayList<MauXe>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
             MauXe entity = new MauXe();
              entity.setMaMau(rs.getString("MaMau"));
              entity.setMauXe(rs.getString("TenMau"));
              list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
