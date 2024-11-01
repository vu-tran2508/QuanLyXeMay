/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import poly.edu.entity.NhanVien;

import poly.edu.helper.JdbcHelper;

/**
 *
 * @author pdo18
 */
public class NhanVienDAO extends DAO<NhanVien, Object>{
    
       
    String INSERT_SQL="INSERT INTO NhanVien(MaNV,MatKhau,HoTen,GioiTinh,ChucVu,DiaChi,SDT,ThongTin,Hinh) VALUES(?,?,?,?,?,?,?,?,?)";
    String UPDATE_SQL="UPDATE NhanVien SET MatKhau=?,HoTen=?,GioiTinh=?,ChucVu=? ,DiaChi =? ,SDT= ?,ThongTin = ?,Hinh=? WHERE MaNV = ? ";
    String DELETE_SQL =" DELETE FROM NhanVien WHERE MaNV=? ";
    String SELECT_ALL_SQL=" SELECT*FROM NhanVien";
    String SELECT_BY_ID_SQL=" SELECT * FROM NhanVien WHERE MaNV=?";

    @Override
    public void insert(NhanVien entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaNV(),entity.getMatKhau(),entity.getHoTen(),entity.isGioiTinh(),
               entity.isChucVu() ,entity.getDiaChi(),entity.getSDT(),entity.getThongTin(),entity.getHinh());
    }

    @Override
    public void update(NhanVien entity) {
    JdbcHelper.update(UPDATE_SQL,entity.getMatKhau(),entity.getHoTen(),entity.isGioiTinh(),
               entity.isChucVu() ,entity.getDiaChi(),entity.getSDT(),entity.getThongTin(),entity.getHinh(), entity.getMaNV());
    }

    @Override
    public void delete(Object id) {
        JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public NhanVien selectById(Object id) {
        List<NhanVien> list =this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
     List<NhanVien> list = new ArrayList<NhanVien>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
              NhanVien entity = new NhanVien();
              entity.setMaNV(rs.getString("MaNV"));
              entity.setMatKhau(rs.getString("MatKhau"));
              entity.setHoTen(rs.getString("HoTen"));
              entity.setGioiTinh(rs.getBoolean("GioiTinh"));
              entity.setChucVu(rs.getBoolean("ChucVu"));
              entity.setDiaChi(rs.getString("DiaChi"));
              entity.setSDT(rs.getString("SDT"));
              entity.setThongTin(rs.getString("ThongTin"));
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
    

