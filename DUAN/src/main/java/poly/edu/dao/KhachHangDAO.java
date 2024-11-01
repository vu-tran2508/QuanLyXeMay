/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import poly.edu.entity.KhachHang;
import poly.edu.entity.NhanVien;
import poly.edu.helper.JdbcHelper;

/**
 *
 * @author pdo18
 */
public class KhachHangDAO extends DAO<KhachHang, Object> {
    String INSERT_SQL="INSERT INTO KhachHang(MaKH,TenKH,GioiTinh,DiaChi,SDT,NgayCN) VALUES(?,?,?,?,?,?)";
    String UPDATE_SQL="UPDATE KhachHang SET TenKH=?,GioiTinh=?,DiaChi=?,SDT=? ,NgayCN =?  WHERE MaKH = ? ";
    String DELETE_SQL =" DELETE FROM KhachHang WHERE MaKH=? ";
    String SELECT_ALL_SQL=" SELECT*FROM KhachHang";
    String SELECT_BY_ID_SQL=" SELECT * FROM KhachHang WHERE MaKH=?";

    @Override
    public void insert(KhachHang entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaKH(),entity.getTenKH(),entity.isGioiTinh(),entity.getDiaChi(),
               entity.getSDT(),entity.getNgaycapnhat());
    }

    @Override
    public void update(KhachHang entity) {
    JdbcHelper.update(UPDATE_SQL,entity.getTenKH(),entity.isGioiTinh(),entity.getDiaChi(),
               entity.getSDT(),entity.getNgaycapnhat(), entity.getMaKH());
    }

    @Override
    public void delete(Object id) {
        JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public KhachHang selectById(Object id) {
        List<KhachHang> list =this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhachHang> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<KhachHang> selectBySql(String sql, Object... args) {
     List<KhachHang> list = new ArrayList<KhachHang>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
              KhachHang entity = new KhachHang();
              entity.setMaKH(rs.getString("MaKH"));
              entity.setTenKH(rs.getString("TenKH"));
              entity.setGioiTinh(rs.getBoolean("GioiTinh"));
              entity.setDiaChi(rs.getString("DiaChi"));
              entity.setSDT(rs.getString("SDT"));
              entity.setNgaycapnhat(rs.getDate("NgayCN"));
              list.add(entity);
                
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
