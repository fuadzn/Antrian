/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antrian.presenter;


import java.sql.Connection;
import antrian.listener.QueryInterface;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import static antrian.constant.Constant.*;
/**
 *
 * @author ZuhdanNur
 */
public class HomePresenter implements QueryInterface {
     Connection coon; 
     
     public void setConnection(Connection connect) {
         this.coon = connect;
     }
     
    private String antrian = "";
    
    public String getAntrian() {
        return antrian;
    }

    @Override
    public void select(String table) {
        
    }

    @Override
    public void insert(String table) {
        
        int lastRow = getLastRow(table) + 1;
        
        String generatedCode = "";
        if(table == TABLE_TELLER) {
            generatedCode = generateKode(lastRow ,"T");
        } else {
            generatedCode = generateKode(lastRow,"C");
        }
        
        String sql = "INSERT INTO "+table+"(name,no_antrian) VALUES(?,?)";
        
        try (
              PreparedStatement pstmt = this.coon.prepareStatement(sql)
                ) {
            pstmt.setString(1,"");
            pstmt.setString(2, generatedCode);
            pstmt.executeUpdate();
            
            antrian = generatedCode;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int getLastRow(String table) {
        String sql = "SELECT count(*) FROM "+table;
        try (
             Statement stmt  = this.coon.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
             
             rs.next();
            
             return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
     
     
}
