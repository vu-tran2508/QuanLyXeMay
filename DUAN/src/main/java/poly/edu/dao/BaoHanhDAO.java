/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import poly.edu.entity.BaoHanh;
import poly.edu.helper.JdbcHelper;

/**
 *
 * @author pdo18
 */
public class BaoHanhDAO extends DAO<BaoHanh, Object>{
    String INSERT_SQL="INSERT INTO BaoHanh (MaBH,MaNV,MaKH,MaXe,NgayMua,NgayHH) VALUES(?,?,?,?,?,?)";
    String UPDATE_SQL="UPDATE BaoHanh SET MaNV=?,MaKH=?,MaXe=?,NgayMua=? , NgayHH=? WHERE MaBH = ? ";
    String DELETE_SQL =" DELETE FROM BaoHanh WHERE MaBH=? ";
    String SELECT_ALL_SQL=" SELECT*FROM BaoHanh";
    String SELECT_BY_ID_SQL=" SELECT * FROM BaoHanh WHERE MaBH=?";

    @Override
    public void insert(BaoHanh entity) {
        JdbcHelper.update(INSERT_SQL,entity.getMaBH(),entity.getMaNV(),entity.getMaKH(),entity.getMaXe(),entity.getNgayMua()
        ,entity.getNgayHH());
    }

    @Override
    public void update(BaoHanh entity) {
    JdbcHelper.update(UPDATE_SQL,entity.getMaNV(),entity.getMaKH(),entity.getMaXe(),entity.getNgayMua()
        ,entity.getNgayHH(),entity.getMaBH());  
    }

    @Override
    public void delete(Object id) {
        JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public BaoHanh selectById(Object id) {
        List<BaoHanh> list =this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<BaoHanh> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<BaoHanh> selectBySql(String sql, Object... args) {
     List<BaoHanh> list = new ArrayList<BaoHanh>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
              BaoHanh entity = new BaoHanh();
              entity.setMaBH(rs.getString("MaBH"));
              entity.setMaNV(rs.getString("MaNV"));
              entity.setMaKH(rs.getString("MaKH"));
              entity.setMaXe(rs.getInt("MaXe"));
              entity.setNgayMua(rs.getDate("NgayMua"));
              entity.setNgayHH(rs.getDate("NgayHH"));
              list.add(entity);
                
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
