/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.helper;

import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import poly.edu.entity.NhanVien;

/**
 *
 * @author pdo18
 */
public class ShareHelper {

 public static NhanVien USER=null;
    
    
    public static void clear(){
        ShareHelper.USER=null;
    }
    public static boolean isLogin(){
        return ShareHelper.USER !=null;
        
    }
    public static boolean isManager(){
        return ShareHelper.isLogin()&& USER.isChucVu();
        
    }
}
