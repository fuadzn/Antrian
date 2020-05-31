/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antrian.presenter;

import antrian.listener.QueryInterface;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ZuhdanNur
 */
public class ViewPresenter implements QueryInterface {
    
    String code = "";
    
    public String getCode() {
        return code;
    }
    
    @Override
    public void select(String table) {
        
        String sql = "SELECT id,no_antrian FROM "+table +" where finish = 1 order by id desc limit 1";
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
    }

    @Override
    public int getLastRow(String table) {
        return 0;
    }
    
    Connection coon; 
     
     public void setConnection(Connection connect) {
         this.coon = connect;
     }
    
}
