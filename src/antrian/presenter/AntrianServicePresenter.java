/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antrian.presenter;

import antrian.listener.QueryInterface;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ZuhdanNur
 */
public class AntrianServicePresenter implements QueryInterface {
    
    Connection coon; 
     
     public void setConnection(Connection connect) {
         this.coon = connect;
     }
    
    String code = ""; 
    
    public String getCode () {
        return code;
    }
    
    @Override
    public void select(String table) {
        String sql = "SELECT id,no_antrian FROM "+table +" where finish = 0 order by id asc limit 1";
        try (
             Statement stmt  = this.coon.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
             
             if(rs.next()){
                code = rs.getString(2);
             } else {
                 code = "Tidak Ada";
             }
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insert(String table) {
         String sql = "UPDATE "+table+" SET finish = 1 "
                + "WHERE no_antrian = ?";

        try (
                PreparedStatement pstmt = this.coon.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, code);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int getLastRow(String table) {
        return 0;
    }
    
}
